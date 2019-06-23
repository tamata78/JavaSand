package http;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class HttpUtils {

	public static HttpURLConnection createConnect(String strUrl, String reqMethod) throws Exception {
		// 実行APIのURL設定
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		// リクエスト設定
		conn.setRequestMethod(reqMethod);
		// conn.setInstanceFollowRedirects(false);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-type", "text/xml");
		conn.setRequestProperty("accept", "text/xml");

		return conn;
	}

	public static void name() {

	}

	public static void execApi(HttpURLConnection conn, String param) {
		try {
			// リクエストパラメータ設定
			if (param != null) {
				PrintWriter out = new PrintWriter(conn.getOutputStream());
				out.write(param);
				out.flush();
				out.close();
			}

			// 接続確立、レスポンス取得
			conn.connect();

		} catch (Exception e) {
			// error log
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
			doc = builder.parse(in);
			in.close();
		} catch (Exception e) {
			return null;
		}

		return doc;
	}
}
