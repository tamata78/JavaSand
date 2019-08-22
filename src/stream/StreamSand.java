package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamSand {
    public static void main(String[] args) {
        // array -> stream
        String[] strArray = { "hoge", "huga" };
        Stream<String> streamArray = Arrays.stream(strArray);
        streamArray.forEach(s -> System.out.println(streamArray));

        // strem -> array
        Stream<String> streamArray2 = Stream.of(strArray);
        streamArray2.forEach(s -> System.out.println(streamArray2));

    }
}
