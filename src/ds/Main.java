package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    // 단어 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] arr = new String[N];
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr ,(a, b) -> {

            if(a.length() == b.length())
                return a.compareTo(b);
            else
                return a.length() - b.length();
        });

        for(int i = 0; i < arr.length; i++) {

            if(!list.contains(arr[i]))
                list.add(arr[i]);
        }

        list.forEach(a -> System.out.println(a));

    }
}
