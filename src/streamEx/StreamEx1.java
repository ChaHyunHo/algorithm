package streamEx;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamEx1 {

    public static void main(String[] args) throws IOException {

        // 배열 스트림
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream_1 = Arrays.stream(arr);
        Stream<String> streamOfArryPart = Arrays.stream(arr, 1, 3);
        System.out.println(Arrays.toString(streamOfArryPart.toArray()));

        // 컬렉션 스트림
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream_2 = list.stream();
        Stream<String> parallelStream = list.parallelStream();
        System.out.println( Arrays.toString(parallelStream.toArray()));

        // 스트림 빌더
        Stream<String> builderStream = Stream.<String>builder()
                .add("차")
                .add("현")
                .add("호")
                .build();

        System.out.println(Arrays.toString(builderStream.toArray()));

        // 스트림 generate()
        Stream<String> generatedStream = Stream.generate(() -> "gen").limit(5);
        System.out.println(Arrays.toString(generatedStream.toArray()));

        Stream<String> stringStream = Pattern.compile(",").splitAsStream("Eric, Elena, Java");

        System.out.println(Arrays.toString(stringStream.toArray()));




    }


    // 비어있는 스트림
    public static Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

}
