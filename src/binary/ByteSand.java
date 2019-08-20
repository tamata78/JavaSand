package binary;
import java.io.UnsupportedEncodingException;

public class ByteSand {

    private static boolean isLeadByte(int charByte) {
        return ((0x81 <= charByte) && (charByte <= 0x9F)) || ((0xE0 <= charByte) && (charByte <= 0xFC));
    }

    // charByte が SJIS ２バイト文字の第２バイトのときそのときに限り真を返す．
    private static boolean isTrailByte(int charByte) {
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
     * Windowsの機種依存文字かどうかをチェックします
     * @param チェック対象文字列
     * @return true 機種依存文字 false 非機種依存文字
     */
    public static boolean checkPrintStringToTicket( String str ) {

        //1文字ずつチェックしていく
        for (int i = 0; i < str.length(); i++) {

            byte[] checkByte;

            try {
                //1文字分をバイト配列として取得
                checkByte = str.substring( i , i+1 ).getBytes("Windows-31j");
            } catch (UnsupportedEncodingException e) {
                return false;
            }

            //２バイト文字でない場合はチェックしない
            if( checkByte.length != 2 ){
                continue;
            }

            //1のビット列と論理積をとって、符号なしにする
            int checkInt1 = checkByte[0] & 0xFF ;
            int checkInt2 = checkByte[1] & 0xFF ;

            //上位8ビットと下位8ビットとして論理和をとり、0x0000の整数値として取得
            int targetChar = (checkInt1 << 8) | checkInt2;

            /*
            * 16進表記で下記の範囲なら入力不可
            */

            if( Integer.decode( "0x8740" ).intValue() <= targetChar && targetChar <= Integer.decode( "0x879C" ).intValue() ){
                return false ;
            }

            if( Integer.decode( "0xED40" ).intValue() <= targetChar && targetChar <= Integer.decode( "0xEDFC" ).intValue() ){
                return false ;
            }

            if( Integer.decode( "0xFA40" ).intValue() <= targetChar && targetChar <= Integer.decode( "0xFC4C" ).intValue() ){
                return false ;
            }

        }

        return true;

    }
}
