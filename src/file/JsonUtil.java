package file;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	final static ObjectMapper mapper = new ObjectMapper();

    /**
     *
     * POJOクラスをJsonに書き出す
     *
     * @param src
     *            対象オブジェクト
     * @param type
     *            対象オブジェクトの型
     * @return Json
     */
//    public static String writer(final Object src, final Class<?> type) {
//        ObjectWriter writer = mapper.writerWithType(type);
//        String jsonString = "";
//        try {
//            jsonString = writer.writeValueAsString(src);
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(JsonUtil1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return jsonString;
//    }

    /**
     *
     * Jsonを読み込んでPOJOクラスに設定する
     *
     * @param src
     *            対象データ
     * @param type
     *            オブジェクト型
     * @return 対象オブジェクト
     */
//    public static <T> T reader(final String src,
//	    final Class<?> type) {
//        ObjectReader reader = mapper.readerForUpdating(type);
//			Syain syain1 = reader.readValue(testJson1);
//
//	return (T) JSON.decode(src, type);
//    }
}
