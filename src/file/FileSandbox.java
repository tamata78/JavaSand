package jp.grv.sandbox.batch;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

public class FileSandbox {

	public static void main(String[] args) {
		// バッファリングしつつ、ファイル出力
		String filePath = "/var/app/data/out.txt";
		try (BufferedOutputStream outBuffer = new BufferedOutputStream(new FileOutputStream(filePath, true))) {
			List<String> logTexts = Arrays.asList("aaa", "bbb", "ccc");
			for (String logText : logTexts) {
				outBuffer.write(logText.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
