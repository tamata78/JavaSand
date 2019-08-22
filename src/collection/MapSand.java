package collection;

import java.util.HashMap;
import java.util.Map;

public class MapSand {
	public static void main(String[] args) {
		Map<String, String> testMap = new HashMap<String, String>();
	    testMap.put("key1", "value1");
	    testMap.put("key2", "value2");

	    for(Map.Entry<String, String> entry : testMap.entrySet()) {
	    	System.out.println("key=" + entry.getKey());
	    	System.out.println("value=" + entry.getValue());
	    }
	}

}
