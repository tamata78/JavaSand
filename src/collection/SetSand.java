package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class SetSand {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(1);

        Set<Integer> set = new HashSet<Integer>(list);
        Stream.of(set).forEach(System.out::println);

    }

}
