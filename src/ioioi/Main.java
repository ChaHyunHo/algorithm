package ioioi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R = 0;
    static String P = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String tempStr = br.readLine();
        char S[] = new char[M];

        for (int i = 0; i < M; i++) {
            S[i] = tempStr.charAt(i);
        }
        int count = 0;

        for (int i = 1; i < S.length - 1; i++) {
            if(S[i - 1] == 'I' && S[i] == 'O' && S[i + 1] == 'I' )  {
                count ++;
                if(count == N)  {
                    count --; // 같은 패턴 증가 후 초기화 (같은패턴이 또있을수 있음)
                    R++;
                }
                i++; // IOIOI  첫번째 인덱스에서 I에 같은 패턴이 존재시에 다음에는 인덱스("O")는 무조건 패턴이 일치하지 않으므로 i증가

            } else {
                count = 0;
            }
        }

        System.out.println(R);
    }
}
