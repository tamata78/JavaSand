package resource;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

public class ResourceUtils {

    public static final String APPLICATION_PROPERTIES = "application";

    public static final String APPLICATION_PROPERTIES_FILE_NAME = "application.properties";

    // properties read
    public static final ResourceBundle RB_APPLICATION_PROPERTIES = ResourceBundle
            .getBundle(APPLICATION_PROPERTIES);

    public static String getPropertiesVal(final String key) {
        if (StringUtils.isEmpty(key)) {
            return null;

        }
        return RB_APPLICATION_PROPERTIES.getString(key);
    }

    /**
     * application.propertiesからkeyに紐づく値を取得する
     * @param key
     * @param arguments 埋め込み文字列
     * @return 取得値
     */
    public static String getAppStr(final String key, final Object... arguments) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return MessageFormat.format(RB_APPLICATION_PROPERTIES.getString(key), arguments);
    }

    /**
     * プロパティファイル読み込み
     * 文字コードをUTF-8で指定する場合
     *
     * @return
     */
    public static Properties loadAppStrUtf8Java6() {
        Properties prop = new Properties();
        // 読み込み
        try {
            InputStream istream = new FileInputStream(APPLICATION_PROPERTIES_FILE_NAME);
            InputStreamReader isr = new InputStreamReader(istream, StandardCharsets.UTF_8);
            prop.load(isr);

            istream.close();
            isr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    /**
     * プロパティファイル読み込み
     * 文字コードをUTF-8で指定する場合
     *
     * @return
     */
    public static Properties loadAppStrUtf8() {
        Properties prop = new Properties();
        // ResourceUtils.class.getClassLoader()でstaticメソッド内からクラスパス配下のファイルを読み込みできる
        try (InputStream is = ResourceUtils.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES_FILE_NAME);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr)) {

            prop.load(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
