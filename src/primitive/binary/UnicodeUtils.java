package primitive.binary;

public class UnicodeUtils {

    /**
     * Unicode文字列に変換する("あ" -> "\u3042")
     * @param str
     * @return
     */
    public static String convToUnicode(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(String.format("\\u%04X", Character.codePointAt(str, i)));
        }
        return sb.toString(); // Unicode
    }

    /**
     * Unicode文字列から元の文字列に変換する ("\u3042" -> "あ")
     * @param unicode
     * @return
     */
    private static String convToString(String unicode) {
        String[] codeStrs = unicode.split("\\\\u");
        int[] codePoints = new int[codeStrs.length - 1]; // 先頭の空白を除く
        for (int i = 0; i < codePoints.length; i++) {
            codePoints[i] = Integer.parseInt(codeStrs[i + 1], 16);
        }
        String encodedText = new String(codePoints, 0, codePoints.length);
        return encodedText;
    }
}
