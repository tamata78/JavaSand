package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

public class ListSand {
    public static void main(String[] args) {
        // Listに複数要素を追加しつつ、初期化
        List<String> list1 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        System.out.println("List1 = " + list1);

        // 二つのリストの重複要素を削除
        List<String> listA = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        List<String> listB = new ArrayList<String>(Arrays.asList("A", "D", "E"));

        listA.addAll(listB);
        List<String> listC = new ArrayList<String>(new LinkedHashSet<String>(listA));
        Set<String> listD = new LinkedHashSet<String>(listA); // Setのままでいいならこれでよい
        System.out.println("重複ありリスト = " + listA);
        System.out.println("重複なしリスト = " + listC);

        // リストのディープコピー
        ArrayList<String> listOrg = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        List<String> listDeepCopy1 = new ArrayList<String>(listOrg);

        // カンマ区切り文字列作成
        List<String> joinList = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        System.out.println("カンマ区切り文字列: " + String.join(",", joinList));

        // カンマ区切り文字列作成(Integerリストの場合)
        List<Integer> joinIntegerIdList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        StringJoiner sj = new StringJoiner(",");
        for (Integer joinIntegerId : joinIntegerIdList) {
            sj.add(String.valueOf(joinIntegerId));
        }

        String mes = new StringBuilder("creativeIds = ").append(sj.toString()).toString();
        System.out.println(mes);

        // List → Array
        List<String> shopIdList = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        String[] shopIdArray = shopIdList.toArray(new String[shopIdList.size()]);
        System.out.println(Arrays.toString(shopIdArray));

    }
}
