package String;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

public class HashSand {
	// MD5hashを生成する件数
    private static final int md5hasGenNum = 100000;

	public static void main(String[] args) {
        // 16進数文字列でMD5値を取得する
        String orgString = "3024573SAF6_101_302aSAF6_101_302a";
        String hexString = DigestUtils.md5Hex(orgString);
        System.out.println(orgString);
        System.out.println(hexString);
        System.out.println(hexString.length());

        // MD5の衝突を確認
        List<String> hashList = new ArrayList<String>();
        StringBuilder builder = new StringBuilder("3d733ed275577a0c08569545e0d75d5l7");
        for (int i = 0; i < md5hasGenNum; i++) {
        	String createStr = builder.append(i).toString();
        	String hashStr = DigestUtils.md5Hex(createStr);

        	if (hashList.size() > 0) {
        		if (hashList.contains(hashStr)) {
					System.out.println("createStr=" + createStr);
					System.out.println("conflict num=" + i);
					break;
				}
        	}

        	if (i % 1000 == 0) System.out.println("complate num=" + i);

        	hashList.add(hashStr);
        	builder.setLength(0); // str clear
		}

        if (hashList.size() == md5hasGenNum) {
        	System.out.println("no conflict. finish");
        } else {
        	System.out.println("★conflict★. finish");
        }
    }
}
