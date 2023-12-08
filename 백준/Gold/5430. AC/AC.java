import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        테스트케이스 T : 최대 100
        명령어 p의 길이 : 1 ~ 100,000
        배열에있는 수의 개수 n : 0~100,000
        배열내의 정수 값 : 1 ~ 100
        명령어 길이의 합과 수의 개수의 합은 70만넘지않음

        Deque를 활용해서 수가 뒤집힌상황이면 뒤에서, 아니면 앞에서 버리기

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answerSb = new StringBuilder();

        loop:
        for (int tc = 0; tc < T; tc++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new LinkedList<>();
            StringBuilder arrSb = new StringBuilder(br.readLine());

            if (n != 0) {
                arrSb.deleteCharAt(0);// [제거
                arrSb.deleteCharAt(arrSb.length() - 1);// ] 제거

                StringTokenizer st = new StringTokenizer(arrSb.toString(), ",");
                for (int i = 0; i < n; i++) {
                    dq.addLast(Integer.parseInt(st.nextToken()));
                }
            }

            boolean reverse = false;
            for (int i = 0; i < p.length(); i++) {
                char command = p.charAt(i);

                if (command == 'R') {
                    reverse = !reverse;
                } else {//'D'
                    if (dq.isEmpty()) {
                        answerSb.append("error").append("\n");
                        continue loop;
                    }
                    if (reverse)
                        dq.removeLast();
                    else
                        dq.removeFirst();
                }
            }

            StringBuilder tempSb = new StringBuilder();
            tempSb.append("[");
            if (!reverse) {
                while (!dq.isEmpty()) {
                    tempSb.append(dq.removeFirst()).append(",");
                }
            } else {
                while (!dq.isEmpty()) {
                    tempSb.append(dq.removeLast()).append(",");
                }
            }
            if (tempSb.length() != 1) {
                tempSb.deleteCharAt(tempSb.length() - 1);//마지막, 제거
            }
            tempSb.append("]").append("\n");

            answerSb.append(tempSb);
        }

        System.out.print(answerSb);


    }
}