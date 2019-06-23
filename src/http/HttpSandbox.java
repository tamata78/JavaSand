package http;

import java.net.HttpURLConnection;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class HttpSandbox {
	public static void main(String[] args) {
		// 外部API Get
		try {
			HttpURLConnection conn = HttpUtils.apiGet("http://www.XXXXXXXXX.xxx/servPersonalInfo",
					"request1=aaa&request2=bbb");

			// レスポンスがXMLの場合
			Document doc = HttpUtils.getApiResXml(conn);
			NodeList nodes = doc.getElementsByTagName("response1");
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
