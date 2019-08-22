package primitive.binary;

import java.io.UnsupportedEncodingException;

public class CodePointSand {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String testStr = "abcあいう";

        /** コードポイント取得 */
        System.out.println("=== サロゲートペア文字なし。char=コードポイント ===");
        for (char c : testStr.toCharArray()) {
            // charのint変換がコードポイント
            System.out.printf("%s => %#x%n", c, (int) c); // コードポイントは16進数表示
        }

        System.out.println("=== サロゲートペア文字あり。2桁charを考慮 ===");
        for (int i = 0, j = 0, codePoint; i < testStr.length(); i += Character.charCount(codePoint)) {
            codePoint = testStr.codePointAt(i);
            System.out.printf("%s => %#x%n", (char) codePoint, codePoint);
        }

        /** 文字列 16進数表示(文字コード指定) */
        System.out.println("=== 16進数表示(UTF-8指定) ===");
        for (char c2 : testStr.toCharArray()) {
            byte[] bytes = new String(new char[] { c2 }).getBytes("UTF-8"); // 文字コードUTF-8でのバイト値を出力
            System.out.print(c2 + "=> 0x");
            for (byte b : bytes) {
                System.out.printf(Integer.toHexString(b & 0xFF));
            }
            System.out.println();
        }

        /** 16進数文字列を文字に変換する */
        System.out.println("=== 16進数文字を文字に変換 ===");
        String[] specHexUnicodeCodePoints = { "0x3042", "0x3044", "0x3046", "0x61", "0x62", "0x63" };
        for (String str : specHexUnicodeCodePoints) {
            char c = (char) Integer.decode(str).intValue();
            System.out.printf("%s => %s%n", str, c);
        }

        System.out.println("=== 基数明示されていない16進数文字を文字に変換 ===");
        String[] specHexUnicodeCodePoints2 = { "3042", "3044", "3046", "61", "62", "63" };
        for (String str : specHexUnicodeCodePoints2) {
            char c = (char) Integer.parseInt(str, 16);
            System.out.printf("%s => %s%n", str, c);
        }

    }
}
