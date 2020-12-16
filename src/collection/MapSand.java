package collection;

import java.util.Map;

/**
 * Map Java7以前
 *
 * @author L-YN1405-u
 *
 */
public class MapSand {
	public static void main(String[] args) {
		Map<Integer, String> testMap = Map.of(
		        0, "hoge",
		        1, "fuga",
		        2, "piyo"
		);

	    for(Map.Entry<Integer, String> entry : testMap.entrySet()) {
	    	System.out.println("key=" + entry.getKey());
	    	System.out.println("value=" + entry.getValue());
	    }
	}

}
