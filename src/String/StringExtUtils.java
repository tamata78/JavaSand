package String;

import java.util.Arrays;

public class StringUtils {
    /**
     * 配列文字列を結合する<br>
     * StreamAPIなし
     * 
     * @param strArray
     * @return
     */
    public static String combineStrArray(String[] strArray) {
        StringBuilder buf = new StringBuilder(strArray.length);
        for (String str : strArray) {
            buf.append(str);
        }
        return buf.toString();
    }

    /**
     * 配列文字列を結合する<br>
     * StreamAPIあり
     * 
     * @param strArray
     * @return
     */
    public static String combineStrArrayStream(String[] strArray) {
        return Arrays.stream(strArray).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
