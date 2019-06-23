package file;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import file.bean.Syain;

public class JsonSandbox {

	public static void main(String[] args) {
		// JSONからJavaオブジェクトに変換
		String testJson1 = "{\"id\":1, \"name\":\"taro\",\"sikaku\":[\"基本\",\"応用\"]}";
		Syain syain1 = new Syain();
		ObjectMapper mapper = new ObjectMapper();
		try {
			syain1 = mapper.readValue(testJson1, Syain.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// JavaオブジェクトからJSONに変換
		List<String> sikaku = Arrays.asList("基本", "応用");
		Syain syain2 = new Syain();
		syain2.setId(1);
		syain2.setN("taro");
		syain2.setSikaku(sikaku);
		ObjectMapper mapper2 = new ObjectMapper();

		try {
			String testJson2 = mapper2.writeValueAsString(syain2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		// JSONのキー項目を指定して値を取得
		try {
			JsonNode node1 = mapper2.readTree(testJson1);
			int id = node1.get("id").asInt();
			String name = node1.get("name").asText();
			String sikaku1 = node1.get("sikaku").get(0).asText();
			String sikaku2 = node1.get("sikaku").get(1).asText();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}