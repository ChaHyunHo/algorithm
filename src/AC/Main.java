package AC;

import java.io.*;
import java.util.*;

public class Main {

    static String[] R;

    static Deque<Integer> dq = new LinkedList<>();
    /**
     *
     * 최상단 입력 함수 갯수 ex) 4 =>4개 RDD, DD, RDD, D
     * 수행할 함수이름 ex) RDD
     * 배열의 갯수 4
     * 배열 입력 ex) [1,2,3,4]
     * [2,1] 출력
     */

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(br.readLine());
//        R = new String[T];
//
//        for(int i = 0; i < T; i++) {
//            dq = new LinkedList<Integer>();
//            String fn = br.readLine(); // 함수 이름
//            int len = Integer.parseInt(br.readLine()); // 배열 갯수
//            String arr = br.readLine(); // 입력 배열
//            ArrayList<Integer> list = new ArrayList<>();
//
//            if(len == 0) {
//                R[i] = "error";
//            } else {
//                arr = arr.replaceAll("\\[","");
//                arr = arr.replaceAll("\\]","");
//                String[] RArr = arr.split(",");
//
//                for(int j = 0; j < RArr.length; j++) {
//                   dq.add(Integer.parseInt(RArr[j]));
//                }
//                R[i] = calc(list, fn);
//            }
//        }
//
//        for(int i = 0; i < R.length; i++) {
//            System.out.println(R[i]);
//        }

        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        int testcase = Integer.parseInt (br.readLine ());
        while (testcase-- > 0) {
            String str1[] = br.readLine ().split ("");
            int N = Integer.parseInt (br.readLine ());
            String str2 = br.readLine ();
            ArrayList<String> arr = new ArrayList<> (Arrays.asList (str2.substring (1, str2.length () - 1).split (",")));
            boolean escape = false;
            boolean isReverse = false;
            for (String command : str1) {
                if (escape) break;
                switch (command) {
                    case "R":
                        isReverse = !isReverse;
                        break;
                    default:
                        if (arr.size () == 0 || N == 0) {
                            bw.write ("error\n");
                            escape = true;
                        } else {
                            if (isReverse) arr.remove (arr.size () - 1);
                            else arr.remove (0);
                        }
                        break;
                }
            }
            if (!escape) {
                bw.write ("[");
                StringBuilder temp = new StringBuilder ("");
                if (isReverse) {
                    for (int i = arr.size () - 1; i >= 0; i--) {
                        temp.append (arr.get (i));
                        temp.append (",");
                    }
                } else {
                    for (int i = 0; i < arr.size (); i++) {
                        temp.append (arr.get (i));
                        temp.append (",");
                    }
                }
                if (temp.length () > 0) bw.write (temp.substring (0, temp.length () - 1));
                else bw.write (temp.toString ());
                bw.write ("]\n");
            }
        }
        bw.flush ();
    }

    public static String calc(ArrayList<Integer> list, String fn) {
        String str = "";
        for (int i = 0; i < fn.length(); i++) {

            if (fn.charAt(i) == 'R') R(list);

            if (fn.charAt(i) == 'D') {
                if (list.size() == 0) {
                    return "error";
                } else {
                    D(list);
                }
            }

            if(fn.length() - 1 == i) str = list.toString();
        }
        return str;
    }

    public static void R(ArrayList<Integer> list) {
        Collections.reverse(list);
    }

    public static void D(ArrayList<Integer> list) {
        list.remove(0);
    }
}
