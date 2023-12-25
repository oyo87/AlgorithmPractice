import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        /*
            거점지 방문 횟수 n : 1~5,000
            거점지에서 충전하는 개수 a : 1~100
            선물의가치 1~100,000

            PriorityQueue에 선물가치 내림차순으로 저장
            선물없을시 -1 선물있을시 poll

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("0")) {//선물주기
                if (pq.isEmpty())
                    answer.append(-1);
                else
                    answer.append(pq.poll());

                answer.append("\n");
            } else {//선물충전
                StringTokenizer st = new StringTokenizer(str);

                int giftCount = Integer.parseInt(st.nextToken());
                for (int j = 0; j < giftCount; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        System.out.print(answer);


    }

}