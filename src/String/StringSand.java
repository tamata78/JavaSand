package String;

import org.apache.commons.lang3.StringUtils;

public class StringSand {
	public static void main(String[] args) {
		// substring 前3文字切り取り
		String res = "12345".substring(0, 3);
		System.out.println(res);

		// defaultString nullを空文字変換
		String nullString =  StringUtils.defaultString(null);
		System.out.println(":" + nullString + ":");

		// StringBuilder 文字列結合。コンストラクタへのint挿入は、キャパシティー設定になるため、文字列変換を行う
		String shopId = new StringBuilder(String.valueOf(1)).append("123").toString();
		System.out.println(shopId);

		StringBuilder sb = new StringBuilder();
		sb.setLength(0); // StringBuilderのクリア方法

		// trim 先頭、末尾の改行や制御文字全般、スペースを除去する
		String trimTargetStr = "\taaa \n";
		String afStr = trimTargetStr.trim();
		System.out.println("「" +  trimTargetStr + "」");
		System.out.println("「" +  afStr + "」");

	}
}
