package http;

import java.net.HttpURLConnection;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class HttpSandbox {
	public static void main(String[] args) {
		// 外部API Get
		try {
			HttpURLConnection conn = HttpUtils.createConnect("http://www.XXXXXXXXX.xxx/servPersonalInfo", "GET");
			HttpUtils.execApi(conn, "request1=aaa&request2=bbb");

			System.out.println("ヘッダー要素[" + conn.getHeaderFields() + "]");
			System.out.println("レスポンスメッセージ[" + conn.getResponseMessage() + "]");
			if (HttpURLConnection.HTTP_OK != conn.getResponseCode()) {
				// error log
			}

			// レスポンスがXMLの場合
			Document doc = HttpUtils.getApiResXml(conn);
			NodeList nodes = doc.getElementsByTagName("response1");
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
