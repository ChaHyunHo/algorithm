package loseBraket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split("-");
        int resultNum = 0;

        for (int i = 0; i < str.length; i++) {

            if (str[i].indexOf("+") != -1) {
                int totalNum = 0;
                String[] plusNum = str[i].split("\\+");

                for (int j = 0; j < plusNum.length; j++) {
                    totalNum += Integer.parseInt(plusNum[j]);
                }

                if (i == 0) {
                    resultNum += totalNum;
                    continue;
                } else {
                    resultNum -= totalNum;
                    continue;
                }
            }

            if (i == 0) {
                resultNum += Integer.parseInt(str[i]);
            } else {
                resultNum -= Integer.parseInt(str[i]);
            }
        }
        System.out.println(resultNum);
    }
}
