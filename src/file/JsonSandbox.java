package file;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import file.bean.Syain;

public class JsonSandbox {

	public static void main(String[] args) {
		// JavaオブジェクトからJSONに変換
		List<String> sikaku = Arrays.asList("基本", "応用");
		Syain syain2 = new Syain();
		syain2.id = 1;
		syain2.n = "taro";
		syain2.sikaku = sikaku;

		Map<String, String> positionMap = new HashMap<String, String>();
		positionMap.put("group", "develop");
		positionMap.put("position1", "reader");
		positionMap.put("position2", "reader");
		positionMap.put("group2", "develop");
		syain2.position = positionMap;

		Map<String, Syain> map = new HashMap<String, Syain>();
		map.put("paramStr", syain2);

        JacksonSand(map);

		// Jsonicを用いて指定OBJへデコード
		String testJson3 = JsonicUtil.serialize(syain2);
		System.out.println(testJson3);
		Syain syain3 = JsonicUtil.deserialize(testJson3, Syain.class);

	}

    private static void JacksonSand(Map<String, Syain> map) {
        ObjectMapper mapper = JsonUtil.mapper;

        // JSONからJavaオブジェクトに変換
        String testJson1 = "{\"id\":1, \"name\":\"taro\",\"sikaku\":[\"基本\",\"応用\"]}";
        try {
            ObjectReader reader = mapper.readerFor(Syain.class);
            Syain syain1 = reader.readValue(testJson1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

		try {
			String testJson2 = writer.writeValueAsString(map);
			System.out.println(testJson2);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		// JSONのキー項目を指定して値を取得
		try {
			JsonNode node1 = mapper.readTree(testJson1);
			int id = node1.get("id").asInt();
			String name = node1.get("name").asText();
			String sikaku1 = node1.get("sikaku").get(0).asText();
			String sikaku2 = node1.get("sikaku").get(1).asText();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Jsonノード作成
		// Jacksonで直接JSONを組み立てる方法


    }
}