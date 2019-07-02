package file;

import net.arnx.jsonic.JSON;

public class JsonicUtil {
	/**
	 *
	 * シリアライズ
	 *
	 * @param src シリアライズ対象オブジェクト
	 * @return シリアライズデータ
	 */
	public static String serialize(final Object src) {
		return JSON.encode(src);
	}

	/**
	 *
	 * デシリアライズ
	 *
	 * @param src  デシリアライズ対象データ
	 * @param type オブジェクト型
	 * @return デシリアライズオブジェクト
	 */
	public static <T> T deserialize(final String src, final Class<? extends T> type) {
		return JSON.decode(src, type);
	}

}
