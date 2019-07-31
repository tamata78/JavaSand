package String;

import org.apache.commons.codec.digest.DigestUtils;

public class HashSandbox {
    public static void main(String[] args) {
        // 16進数文字列でMD5値を取得する
        String orgString = "3024573SAF6_101_302aSAF6_101_302a";
        String hexString = DigestUtils.md5Hex(orgString);
        System.out.println(orgString);
        System.out.println(hexString);
        System.out.println(hexString.length());
    }
}
