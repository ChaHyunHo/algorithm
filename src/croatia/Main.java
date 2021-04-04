package croatia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    static String arr[] = {"c=","c-","dz=","d-","lj","nj","s=","z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String tempStr ="";
        Stream<String> stream = Arrays.stream(arr);

        int cnt = getCnt(str,0);
        System.out.println(cnt);

    }

    public static int getCnt(String s, int cnt) {

        if(s.length() == 0) return cnt; // 입력한 문자 0이되면 cnt 반환
        int matched = Arrays.stream(arr)
                .filter(a -> a.length() <= s.length()) // 현재 입력문자보다 변환할 문자가 크면 true
                .filter(a -> s.startsWith(a)) // arr 포함된 문자를 찾으면 true
                .map(a -> a.length()) // 변환될 문자의 수를 반환
                .findFirst().orElse(1);

        return getCnt(s.substring(matched), cnt+1);
    }
}
