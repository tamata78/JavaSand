package primitive.char_sample;

public class CharSand {
    public static void main(String[] args) {
        // charはintへ暗黙変換できる char:16bit、int:32bitのため
        int charInt = 'あ';
        System.out.println(charInt); // 12354 「あ」は16進数で3042これを10進数に直すと12354となる

        // String → char サロゲートペア文字は、文字化ける
        char c1 = "ABC".charAt(1);

        // char → 16進数表記
        System.out.println(Integer.toHexString(c1)); // int型にcharを代入している

    }
}
