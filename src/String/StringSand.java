package String;

import org.apache.commons.lang3.StringUtils;

public class StringSand {
	public static void main(String[] args) {
		// 前3文字切り取り
		String res = "12345".substring(0, 3);
		System.out.println(res);

		// nullを空文字変換
		String nullString =  StringUtils.defaultString(null);
		System.out.println(":" + nullString + ":");
	}
}
