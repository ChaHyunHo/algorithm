package deudbojab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    static int T = 0;
    /**
     * HashSet의 경우 중복된 원소를 포함하지 않기때문에 ArrayList보다 효율적임
     */
    static HashSet<String> DB = new HashSet<>(); // ArrayList일 경우 시간초과남 ;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        ArrayList<String> R = new ArrayList<>();

        for (int i =0; i < N; i++) {
            String temp = br.readLine();
            DB.add(temp);
        }

        for(int i = 0; i < M; i++) {
            String temp = br.readLine();
            if (DB.contains(temp)) {
                T++;
                R.add(temp);
                continue;
            }
        }

        System.out.println(T);
        R.stream().sorted() // Collections.sort() 선언해서 하는것보다 조금빠름
                .forEach(a -> System.out.println(a.toString()));

    }
}
