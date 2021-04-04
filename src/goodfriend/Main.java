package goodfriend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] inputValue = br.readLine().split(" ");
            int N = Integer.parseInt(inputValue[0]);
            int K = Integer.parseInt(inputValue[1]);

            Queue<Integer>[] queues = new Queue[21];

            int[] friendGroup = new int[N];

            for (int i = 0; i < 21; i++) {
                queues[i] = new LinkedList<>();
            }

            long cnt = 0;
            for (int i = 0; i < N; i++) {
                int length = br.readLine().trim().length(); // 입력한 친구이름 길이 변수

                if(queues[length].isEmpty()){ // 큐[길이(최대 20자)]에 등록된 해당 길이가 없다면 true
                    queues[length].offer(i); // 해당 길이를 큐에 등록
                } else {
                    while(i- queues[length].peek() > K){  // 해당 친구의 이름수가 (큐[length]에 등록된 이전 친구의 이름길이) 같지만 등수의 차이가 K보다 크면
                        queues[length].poll();  // queues[length]에 등록된 맨앞에값을 꺼내주면서 반복함
                        if(queues[length].isEmpty()){ // 꺼냈으니 값이 없으면서 반복문 멈춤
                            break;
                        }
                    }

                    cnt += queues[length].size();// 해당 친구의 이름수가 같고 등수의 차이가 K보다 작거나 같으면 좋은친구 한쌍 추가
                    queues[length].offer(i); // 큐에 해당 길이에 인덱스 추가
                }
            }

            System.out.println(cnt);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
