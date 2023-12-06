import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        카드의 개수 n : 2~1,000
        카드 합체 횟수 m : 0 ~ 15,000
        처음 카드의 상태 : 1~1,000,000

        가장 작아야하니 가장 작은값 둘을 더하기
        우선순위큐사용, long 자료형
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        int count = 0;
        while (count < m) {
            Long sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
            count++;
        }

        long answer = 0;
        while (!pq.isEmpty())
            answer += pq.poll();

        System.out.print(answer);


    }
}