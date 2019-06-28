package http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class HttpUtils {
	public static HttpURLConnection connectGet(String strUrl, String contentType) throws Exception {
		// 実行APIのURL設定
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		/** リクエスト設定 **/
		conn.setRequestMethod("GET");
		conn.addRequestProperty("Content-Type", contentType);

		return conn;
	}

	public static HttpURLConnection connectPost(String strUrl, String contentType) throws Exception {
		// 実行APIのURL設定
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		/** リクエスト設定 **/
		conn.setRequestMethod("POST");
		// リクエストのボディ送信を許可する。POSTパラメータを許可
		conn.setDoOutput(true);
		conn.addRequestProperty("Content-Type", contentType);

		return conn;
	}

	public static void addRequestProp(HttpURLConnection conn) {
		// 接続タイムアウト
		conn.setConnectTimeout(100000);
		// レスポンスデータ読み取りタイムアウト
		conn.setReadTimeout(100000);
		// User-Agent
		conn.setRequestProperty("User-Agent", "Android");
		// Accept-Language
		conn.setRequestProperty("Accept-Language", Locale.getDefault().toString());

		// Content-Type
		conn.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
		// conn.setRequestProperty("Content-type", "text/xml");

		// 受信可能なデータのメディアタイプ
		conn.setRequestProperty("accept", "text/xml");
		// レスポンスのボディ受信を許可する
		conn.setDoInput(true);
		// 自動リダイレクトを許可する
		conn.setInstanceFollowRedirects(false);

	}

	public static void execApiGet(HttpURLConnection conn) {
		try {
			conn.connect();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void execApiPost(HttpURLConnection conn, String bodyData) {
		if (bodyData == null) {
			return;
		}

		// try with resourcesでオブジェクト自動開放
		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));) {
			out.write(bodyData);
			out.flush();
			out.close();

		} catch (Exception e) {
			// error log
		}
	}

	public static void execApiPostJava6(HttpURLConnection conn, String bodyData) {
		if (bodyData == null)
			return;

		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			out.write(bodyData);
			out.flush();
			out.close();

		} catch (IOException e) {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * レスポンス結果のXMLを取得する.
	 * 
	 * @param conn 接続コネクション(レスポンス結果)
	 * @return doc レスポンスXML
	 */
	public static Document getApiResXml(HttpURLConnection conn) {
		InputStream in = null;
		Document doc = null;
		try {
			in = conn.getInputStream();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(new BufferedInputStream(in));
			in.close();
		} catch (Exception e) {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			return null;
		}

		return doc;
	}

	public static String getApiResJson(HttpURLConnection conn) {
		StringBuilder builder = new StringBuilder();
		InputStream in = null;
		try {
			in = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;

			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			in.close();
		} catch (Exception e) {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			return null;
		}

		return builder.toString();
	}

	// javax.ws.rsのClientクラスでのhttp通信
	private static Client client = ClientBuilder.newClient();

	public static String jerseyGet() {
		// ドメイン、パスディレクトリ、クエリパラメータ付与を行い、アクセス対象を生成
		WebTarget target = client.target("https://api.example.com").path("/oauth/access_token").queryParam("token",
				"shortAccessToken");

		try {
			// リクエスト発行、戻り値の型を指定。
			String result = target.request().get(String.class);
			return result;
		} catch (BadRequestException e) {
			System.out.println("response=" + e.getResponse().readEntity(String.class));
			throw e;
		}
	}

	// jerseyを使ったPOST通信
	public static String jerseyPost() {
		Entity<Form> entity = Entity.entity(new Form().param("name", "Taro").param("subtype", "CUSTOM"),
				MediaType.APPLICATION_FORM_URLENCODED_TYPE);
		try {
			String result = client.target("https://api.example.com").path("/path_to_post_method").request().post(entity,
					String.class);
			return result;
		} catch (BadRequestException e) {
			System.out.println("response=" + e.getResponse().readEntity(String.class));
			throw e;
		}
	}

}
