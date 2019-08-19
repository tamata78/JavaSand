package resource;

import java.util.Properties;

public class ResourceSand {
    public static void main(String[] args) {
        // 文字コード指定なしで文字化けしない値を読み込む
        String val = ResourceUtils.getPropertiesVal("invalid.character");
        System.out.println(val);

        // 文字コード指定ありで文字化けする可能性のある値を読み込む
        Properties prop = ResourceUtils.loadAppStrUtf8();
        System.out.println(prop.get("invalid.character"));

    }
}
