package http;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class HttpUtils {

	public static HttpURLConnection apiGet(String strUrl, String param) throws Exception {
		// 0. connect out api
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.connect();

		// 1. send parameter
		PrintWriter out = new PrintWriter(conn.getOutputStream());
		out.write(param);
		out.flush();
		out.close();

		return conn;
	}

	public static Document getApiResXml(HttpURLConnection conn) throws Exception {
		// get xml
		InputStream in = conn.getInputStream();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(in);
		in.close();

		return doc;
	}
}
