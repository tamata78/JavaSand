package batch;

public class ThreadSandox {

	public static void main(String[] args) {
		// シンプルスレッド処理実行
		SimpleMultiThread thread = new SimpleMultiThread("1", "add");
		thread.start();

	}
}

class SimpleMultiThread extends Thread {
	// 内部で必要なパラメータを指定
	String status;
	String action;

	public SimpleMultiThread(String status, String action) {
		this.status = status;
		this.action = action;
	}

	// 処理
}
