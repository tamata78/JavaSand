package file;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * ファイル出力用クラス. 旧同名クラスの簡略版
 *
 */
public class FileOutput implements AutoCloseable {
	private static final int BUFFER_SIZE = 1 * 1024; // 256KBが最も効率良い？大き過ぎるとメモリや出力ラグの懸念
	private String lineFeed; // 改行コード
	private BufferedWriter writer = null;
	private boolean isFlushed = true;

	public static final String ENCODE_UTF8 = "UTF-8";
	public static final String ENCODE_MS932 = "MS932";
	public static final String ENCODE_EUC = "EUC_JP";

	public static final String LINE_FEED_LF = "\n";
	public static final String LINE_FEED_CRLF = "\r\n";

	public FileOutput(String path) throws Exception {
		this.lineFeed = LINE_FEED_LF;
		open(path, false, ENCODE_UTF8, BUFFER_SIZE);
	}

	public FileOutput(String path, boolean append) throws Exception {
		this.lineFeed = LINE_FEED_LF;
		open(path, append, ENCODE_UTF8, BUFFER_SIZE);
	}

	public FileOutput(String path, boolean append, String encode, String lineFeed) throws Exception {
		this.lineFeed = lineFeed;
		open(path, append, encode, BUFFER_SIZE);
	}

	public FileOutput(String path, boolean append, int buffSize) throws Exception {
		this.lineFeed = LINE_FEED_LF;
		open(path, append, ENCODE_UTF8, buffSize);
	}

	private void open(String path, boolean append, String encode, int buffSize) throws Exception {
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, append), encode), buffSize);
	}

	public void close() throws Exception {
		if (writer != null) {
			try {
				writer.close();
			} catch (RuntimeException e) {
			}
		}
		writer = null;
	}

	public void flush() {
		if (writer != null) {
			try {
				if (!isFlushed) {
					writer.flush();
					isFlushed = true;
				}
			} catch (IOException e) {
			}
		}
	}

	public void write(String text) throws Exception {
		if (writer == null)
			return;
		try {
			writer.write(text);
			if (isFlushed) {
				isFlushed = false;
			}
		} catch (Exception e) {
			close();
			throw (e);
		}
	}

	public void writeLine(Object... args) throws Exception {
		if (args != null) {
			for (Object arg : args) {
				if (arg != null) {
					write(arg.toString());
					write(lineFeed);
				}
			}
		}
	}
}
