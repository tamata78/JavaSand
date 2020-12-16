package collection;

import java.util.List;

public class ListSandJava8orMore {
    public static void main(String[] args) {
        // Listに複数要素を追加しつつ、初期化
        List<String> list1 = List.of("a","b","c");  // 要素数が多ければ多いほど、Arrays.asList()の方が早いらしい。。
        System.out.println("List1 = " + list1);

    }
}
