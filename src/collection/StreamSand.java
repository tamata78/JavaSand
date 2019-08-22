package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import collection.bean.Person;

public class StreamSand {

    public static void main(String[] args) {
        /** 配列 **/
        // array -> stream
        String[] strArray = { "a", "b", "c" };
        Stream<String> aryStream1 = Arrays.stream(strArray);
        aryStream1.forEach(s -> System.out.println(s));
        Stream<String> aryStream2 = Stream.of(strArray);

        // stream -> array
        Stream<String> streamArray2 = Stream.of(strArray);
        streamArray2.forEach(s -> System.out.println(s));

        /** Map */
        Map<String, String> map = new HashMap<String, String>();
        Stream<Entry<String, String>> stream = map.entrySet().stream();

        // Map作成(重複上書き)
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Tom", 21));
        persons.add(new Person("Bob", 25));
        persons.add(new Person("Alice", 19));
        Map<String, Integer> personMap = persons.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge, (befIndex, aftIndex) -> aftIndex));

        /** List表示 **/
        List<String> nameList = persons.stream().map(Person::getName).collect(Collectors.toList());
        nameList.stream().forEach(System.out::println);

        /** CSV作成 */
        String nameCSV = persons.stream().map(p -> String.format("\"%s\"", p.getName()))
                .collect(Collectors.joining(","));
        System.out.println(nameCSV);

    }

}
