import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        파일합치기
        챕터의 수 K 3~1,000,000
        파일의 크기 1~10000

        greedy접근 작은거부터 골라서 합치기
        priority queue 이용
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int K;
        long answer;
        long temp;
        PriorityQueue<Long> pq;

        for (int tc = 0; tc < T; tc++) {
            answer = 0;
            K = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            while (1 < pq.size()) {
                temp = pq.poll() + pq.poll();

                answer += temp;
                pq.add(temp);
            }

            System.out.println(answer);
        }

    }
}