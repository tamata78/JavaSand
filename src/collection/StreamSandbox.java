package jp.grv.sandbox.batch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSandbox {

	public static void main(String[] args) {
		/** Streamクラス変換 **/
		// コレクション
		List<String> list = new ArrayList<String>();
		Stream<String> listStream = list.stream();

		// 配列
		String[] strArray = new String[] { "a", "b", "c" };
		Stream<String> aryStream1 = Arrays.stream(strArray);
		Stream<String> aryStream2 = Stream.of(strArray);

		// Map
		Map<String, String> map = new HashMap<String, String>();
		Stream<Entry<String, String>> stream = map.entrySet().stream();

		/** List表示 **/
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Tom", 21));
		persons.add(new Person("Bob", 25));
		persons.add(new Person("Alice", 19));

		// List作成
		List<String> nameList = persons.stream().map(Person::getName).collect(Collectors.toList());
		nameList.stream().forEach(System.out::println);

		// CSV作成
		String nameCSV = persons.stream().map(p -> String.format("\"%s\"", p.getName()))
				.collect(Collectors.joining(","));
		System.out.println(nameCSV);

		// Map作成(重複上書き)
		Map<String, Integer> personMap = persons.stream()
				.collect(Collectors.toMap(Person::getName, Person::getAge, (befIndex, aftIndex) -> aftIndex));

	}

}
