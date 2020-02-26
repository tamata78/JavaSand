package http;

import java.net.HttpURLConnection;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class HttpSand {

    public static void main(String[] args) {
        // 外部API Get
        try {
            HttpURLConnection conn = HttpUtils.connectGet("http://www.XXXXXXXXX.xxx/servPersonalInfo", "text/plain");
            HttpUtils.execApiGet(conn);

            System.out.println("ヘッダー要素[" + conn.getHeaderFields() + "]");
            System.out.println("レスポンスメッセージ[" + conn.getResponseMessage() + "]");
            if (HttpURLConnection.HTTP_OK != conn.getResponseCode()) {
                // error log
            }

            // レスポンスがXMLの場合
            Document doc = HttpUtils.getApiResXml(conn);
            NodeList nodes = doc.getElementsByTagName("response1");
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println(nodes.item(i).getFirstChild().getNodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 外部API Post
        try {
            HttpURLConnection conn = HttpUtils.connectPost("http://www.XXXXXXXXX.xxx/servPersonalInfo",
                    "application/json; charset=UTF-8");
            String json = "";
            HttpUtils.execApiPost(conn, json);

            System.out.println("ヘッダー要素[" + conn.getHeaderFields() + "]");
            System.out.println("レスポンスメッセージ[" + conn.getResponseMessage() + "]");
            if (HttpURLConnection.HTTP_OK != conn.getResponseCode()) {
                // error log
            }

            // レスポンスがJsonの場合
            String resJson = HttpUtils.getApiResJson(conn);
            System.out.println("レスポンスJson[" + resJson + "]");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
