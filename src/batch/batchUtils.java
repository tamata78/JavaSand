package batch;

import java.net.InetAddress;

public class batchUtils {

	/**
	 * 実行しているマシンのホスト名を取得します。
	 * @return ホスト名
	 * ※予期せぬ例外が発生した場合は、文字列 "UnknownHost" を返します。
	 */
	public static String getHostName() {
	    try {
	        return InetAddress.getLocalHost().getHostName();
	    }catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "UnknownHost";
	}

}
