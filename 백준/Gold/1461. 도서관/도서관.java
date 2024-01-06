import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        /*
            책의 개수 N, 한번에 들수있는 책의 개수  M : 1~50
            책의 위치 : 0을 제외한 -10,000 ~ 10,000

            -방향 pq, +방향 pq로 진행
            마지막은 왕복X
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (0 < temp) {
                plus.add(temp);
            } else {
                minus.add(temp * -1);
            }
        }
        int min = 0;
        int max = 0;
        if (!plus.isEmpty())
            max = plus.peek();
        if (!minus.isEmpty())
            min = minus.peek();

        //왕복기준 계산
        work(plus);
        work(minus);

        // 마지막은 도착하면즉시 끝나므로 마지막에 왕복하면서 늘어난 발걸음 제거
        if (min <= max) {
            answer -= max;
        } else {
            answer -= min;
        }

        System.out.print(answer);

    }

    static void work(PriorityQueue<Integer> pq) {

        while (!pq.isEmpty()) {
            int temp = pq.poll();
            for (int i = 0; i < M - 1 && !pq.isEmpty(); i++) {
                pq.poll();
            }
            answer += temp * 2;//왕복
        }
    }

}