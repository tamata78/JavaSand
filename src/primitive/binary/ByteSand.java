package primitive.binary;

import java.io.UnsupportedEncodingException;

import resource.ResourceUtils;

public class ByteSand {

    /** 機種依存文字 **/
    // ▼機種依存ではない文字
    public static final String NO_MACHINE_DEPEND_CHAR = "あa∵￢";
    // ▼PC-9800シリーズなど、NECのパソコンが日本で主流だったころに独自に定義されていた文字
    public static final String MACHINE_DEPEND_CHAR_STANDARD = "①㎏";
    // ▼NECがIBMパソコンの導入を考慮した時に定義した文字
    public static final String MACHINE_DEPEND_CHAR_NEC = "侊犱罇霳";
    // ▼IBMが独自に定義した文字
    public static final String MACHINE_DEPEND_CHAR_IBM = "彅￤嵭琇詹鮏";
    // サロゲートペア文字でcharAtやsubstringが上手く動かなくなる文字
    public static final String SURROGATE_PAIR_CHAR_PROBREM = "𠮷";
    // サロゲートペア文字だけど、charAtやsubstringは上手く動かく文字
    public static final String SURROGATE_PAIR_CHAR_NOPROBREM = "浩滋潮炭𠢹";
    // 機種文字各種
    public static final String MACHINE_DEPEND_CHAR_VARIOUS = "①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳ⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩ㍉㌔㌢㍍㌘㌧㌃㌶㍑㍗㌍㌦㌣㌫㍊㌻㎜㎝㎞㎎㎏㏄㎡㍻〝〟№㏍℡㊤㊥㊦㊧㊨㈱㈲㈹㍾㍽㍼∮∑∟⊿ⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹ￤＇＂纊褜鍈銈蓜俉炻昱棈鋹曻彅丨仡仼伀伃伹佖侒侊侚侔俍偀倢俿倞偆偰偂傔僴僘兊兤冝冾凬刕劜劦勀勛匀匇匤卲厓厲叝﨎咜咊咩哿喆坙坥垬埈埇﨏塚增墲夋奓奛奝奣妤妺孖寀甯寘寬尞岦岺峵崧嵓﨑嵂嵭嶸嶹巐弡弴彧德忞恝悅悊惞惕愠惲愑愷愰憘戓抦揵摠撝擎敎昀昕昻昉昮昞昤晥晗晙晴晳暙暠暲暿曺朎朗杦枻桒柀栁桄棏﨓楨﨔榘槢樰橫橆橳橾櫢櫤毖氿汜沆汯泚洄涇浯涖涬淏淸淲淼渹湜渧渼溿澈澵濵瀅瀇瀨炅炫焏焄煜煆煇凞燁燾犱犾猤猪獷玽珉珖珣珒琇珵琦琪琩琮瑢璉璟甁畯皂皜皞皛皦益睆劯砡硎硤硺礰礼神祥禔福禛竑竧靖竫箞精絈絜綷綠緖繒罇羡羽茁荢荿菇菶葈蒴蕓蕙蕫﨟薰蘒﨡蠇裵訒訷詹誧誾諟諸諶譓譿賰賴贒赶﨣軏﨤逸遧郞都鄕鄧釚釗釞釭釮釤釥鈆鈐鈊鈺鉀鈼鉎鉙鉑鈹鉧銧鉷鉸鋧鋗鋙鋐﨧鋕鋠鋓錥錡鋻﨨錞鋿錝錂鍰鍗鎤鏆鏞鏸鐱鑅鑈閒隆﨩隝隯霳霻靃靍靏靑靕顗顥飯飼餧館馞驎髙髜魵魲鮏鮱鮻鰀鵰鵫鶴鸙黑";

    public static void main(String[] args) throws UnsupportedEncodingException {
        // String → 文字コード(Shift-JIS)で変換 → byte配列
        byte[] checkByte = "①".getBytes("Windows-31j");

        // byte配列 → 16進2桁表示
        String hexStr = String.format("%02X", checkByte[0]);
        System.out.println(hexStr);

        // byte型数値を符号なしで扱う
        byte byteVal = (byte) 0xFF; // 11111111
        int intVal = byteVal; // 符号あり -127〜128の範囲の数値を表せる
        System.out.printf("int型 intVal (16進数表示):%x%n", intVal);
        System.out.printf("int型 intVal (10進数表示):%d%n", intVal);
        int unsignedIntVal = byteVal & 0xFF; // 符号なしに変換 0〜255の範囲の数値を表せる。最上位ビットが符号
        System.out.printf("int型 intVal (16進数表示):%x%n", unsignedIntVal);
        System.out.printf("int型 intVal (10進数表示):%d%n", unsignedIntVal);

        // 禁則文字チェック
//        System.out.println(checkProhibitedChar(NO_MACHINE_DEPEND_CHAR));
//        System.out.println(checkProhibitedChar("aa①aa"));
//        System.out.println(checkProhibitedChar("あい侊うえお"));
//        System.out.println(checkProhibitedChar("あい彅うえお"));
//        System.out.println(checkProhibitedChar("あい𠮷うえお"));
//        System.out.println(checkProhibitedChar("あい㍉うえお"));
//        System.out.println(checkProhibitedChar("あいうえお"));

        // コードポイント
        System.out.println("===コードポイント===");
        System.out.println(checkProhibitedSurrogateChar("あい𠮷うえお"));
//        System.out.println(checkProhibitedSurrogateChar(MACHINE_DEPEND_CHAR_VARIOUS));

    }

    /** 禁則文字. **/
    private static final String INVALID_CHARACTER = "invalid.character";

    /**
     * 禁則文字チェック
     *
     * @param targetStr
     * @return 禁則文字あり：false 禁則文字なし:true
     */
    private static boolean checkProhibitedChars(String targetStr) {
        String prohibitedChars = ResourceUtils.getPropertiesVal(INVALID_CHARACTER);

        for (int i = 0; i < targetStr.length(); i++) {
            byte[] checkByte = new byte[targetStr.length()];
            String strChar = targetStr.substring(i, i + 1);
            try {
                checkByte = strChar.getBytes("Windows-31j");
//                checkByte = strChar.getBytes("UTF-8");
                // System.out.println(targetStr.charAt(i));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // ２バイト文字でない場合はチェックしない
//            if (checkByte.length != 2) {
//                System.out.println("2byteじゃない文字" + strChar);
//                continue;
//            }

            if (checkByte.length > 1) {
                System.out.println(
                        String.format("%02X", checkByte[0]) + String.format("%02X", checkByte[1]) + ":" + strChar);
            } else {
                System.out.println(String.format("%02X", checkByte[0]) + ":" + strChar);
            }

//          System.out.println(String.format("%02X", checkByte[0]) + String.format("%02X", checkByte[1]) + String.format("%02X", checkByte[2]) + ":" + strChar);

        }

        // charAtは、機種依存文字(≒サロゲートペア)を考慮できない
//        for(int i = 0; i < targetStr.codePointCount(0, targetStr.length()); i++) {
//            char targetChar = targetStr.charAt(i);
//
//            for (int prohibitedIndex = 0; prohibitedIndex < prohibitedChars.length(); prohibitedIndex++) {
//                if(targetChar.equals(prohibitedChars.charAt(prohibitedIndex))) {
//
//                }
//            }
//
//        }

        return true;

    }

    private static boolean isLeadByte(int charByte) {
        return ((0x81 <= charByte) && (charByte <= 0x9F)) || ((0xE0 <= charByte) && (charByte <= 0xFC));
    }

    // charByte が SJIS ２バイト文字の第２バイトのときそのときに限り真を返す．
    private static boolean isTrailByte(int charByte) {
        // Shift_JIS 漢字 第2バイト : 0x40〜0x7E, 0x80〜0xFC 、制御文字delete(0x7F)
        return (0x40 <= charByte) && (charByte <= 0xFC) && (charByte != 0x7F);
    }

    /**
     * 機種依存文字を含むか
     *
     * @param target
     * @return trueなら機種依存文字を含む
     * @throws UnsupportedEncodingException
     */
    public static boolean hasMachineCharacters(String target) throws UnsupportedEncodingException {
        byte charArray[] = target.getBytes("MS932");
        for (int i = 0; i < charArray.length; i++) {
            int charByte = charArray[i] & 0xFF;
            if (isLeadByte(charByte)) {
                // charByte が２バイト文字の第１バイトの場合
                if (++i >= charArray.length) {
                    // 第２バイトが存在しない場合：エラー
                    return true;
                }
            }

            int charByte2 = charArray[i] & 0xFF;
            if (!isTrailByte(charByte2)) {
                // 第２バイトが不正：エラー
                return true;
            }

            int targetChar = (charByte << 8) | charByte2;
            if ((0x8740 <= targetChar) && (targetChar <= 0x879E)) {
                // 13区 (NEC特殊文字)：機種依存 > Windowsでは表示できるMacで文字化け
                return true;
            }

            if ((0xED40 <= targetChar) && (targetChar <= 0xEFFC)) {
                // 89-92区 (NEC選定IBM拡張文字)：機種依存 > 句点コード
                return true;
            }

            if ((0xFA40 <= targetChar) && (targetChar <= 0xfC4B)) {
                // 115-119区 (IBM拡張文字)：機種依存
                return true;
            }
        }

        return false;
    }

    /**
     * 禁則文字チェックします (サロゲートペア文字考慮なし)
     *
     * @param チェック対象文字列
     * @return true 禁則文字あり false 禁則文字なし
     */
    public static boolean checkProhibitedChar(String str) {

        // 1文字ずつチェックしていく
        for (int i = 0; i < str.length(); i++) {

            byte[] checkByte;

            try {
                // 1文字分をバイト配列として取得
                checkByte = str.substring(i, i + 1).getBytes("Windows-31j");
            } catch (UnsupportedEncodingException e) {
                return false;
            }

            // 対象文字列
            String strChar = str.substring(i, i + 1);
            if (checkByte.length > 1) {
                System.out.println(
                        String.format("%02X", checkByte[0]) + String.format("%02X", checkByte[1]) + ":" + strChar);
            } else {
                System.out.println(String.format("%02X", checkByte[0]) + ":" + strChar);
            }

            // ２バイト文字でない場合はチェックしない
            if (checkByte.length != 2) {
                continue;
            }

            // 1のビット列と論理積をとって、符号なしにする
            int checkInt1 = checkByte[0] & 0xFF; // 0xFF(00000000 11111111) 下位8ビットを取得することで符号なしバイトを取得
            int checkInt2 = checkByte[1] & 0xFF;

            // 上位8ビットと下位8ビットとして論理和をとり、0x0000の整数値として取得
            int targetChar = (checkInt1 << 8) | checkInt2;

            /*
             * 16進表記で下記の範囲なら入力不可
             */

            if (Integer.decode("0x8740").intValue() <= targetChar
                    && targetChar <= Integer.decode("0x879C").intValue()) {
                // 13区 (NEC特殊文字)：機種依存 > Windowsでは表示できるMacで文字化け
                return false;
            }

            if (Integer.decode("0xED40").intValue() <= targetChar
                    && targetChar <= Integer.decode("0xEDFC").intValue()) {
                // 89-92区 (NEC選定IBM拡張文字)：機種依存 > 句点コード
                return false;
            }

            if (Integer.decode("0xFA40").intValue() <= targetChar
                    && targetChar <= Integer.decode("0xFC4C").intValue()) {
                // 115-119区 (IBM拡張文字)：機種依存
                return false;
            }

        }

        return true;

    }

    /**
     * 禁則文字チェックします (サロゲートペア文字考慮あり)
     *
     * @param チェック対象文字列
     * @return true 禁則文字あり false 禁則文字なし
     */
    public static boolean checkProhibitedSurrogateChar(String str) {
        // サロゲートペア文字を考慮して文字数カウント
        int cpCount = str.codePointCount(0, str.length());
        int[] codePoints = new int[cpCount];

        // 1文字ずつチェックしていく
        for (int i = 0, j = 0, codePoint; i < str.length(); i += Character.charCount(codePoint)) {
            codePoint = str.codePointAt(i);
            // codePoints[j++] = codePoint;

            // 対象文字列
            int[] tmpStrChar = { codePoint };
            String strChar = new String(tmpStrChar, 0, 1);
            byte[] checkByte = new byte[2];

            try {
                checkByte = strChar.getBytes("Windows-31j");
            } catch (UnsupportedEncodingException e) {
            }

            // 1のビット列と論理積をとって、符号なしにする
            int checkInt1 = checkByte[0] & 0xFF; // 0xFF(00000000 11111111) 下位8ビットを取得することで符号なしバイトを取得
            int checkInt2 = 0;
            int targetChar = 0;
            if (checkByte.length > 1) {
                checkInt2 = checkByte[1] & 0xFF;
                targetChar = (checkInt1 << 8) | checkInt2;
            } else {
                targetChar = (checkInt1 << 8); // windows-31jでbyte配列を上手く取得できない場合
            }

            System.out.println(String.format("%02X", targetChar) + ":" + strChar);
//            System.out.println(String.format("%02X", codePoint) + ":" + strChar);

            /*
             * 16進表記で下記の範囲なら入力不可
             */

            if (Integer.decode("0x8740").intValue() <= targetChar
                    && targetChar <= Integer.decode("0x879C").intValue()) {
                // 13区 (NEC特殊文字)：機種依存 > Windowsでは表示できるMacで文字化け
                return false;
            }

            if (Integer.decode("0xED40").intValue() <= targetChar
                    && targetChar <= Integer.decode("0xEDFC").intValue()) {
                // 89-92区 (NEC選定IBM拡張文字)：機種依存 > 句点コード
                return false;
            }

            if (Integer.decode("0xFA40").intValue() <= targetChar
                    && targetChar <= Integer.decode("0xFC4C").intValue()) {
                // 115-119区 (IBM拡張文字)：機種依存
                return false;
            }

        }

        return true;

    }

}
