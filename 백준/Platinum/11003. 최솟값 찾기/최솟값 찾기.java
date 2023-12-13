import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            숫자의 개수 N : 1~5,000,000
            범위 L : 1~5,000,000
            값 : -1,000,000,000 ~ 1,000,000,000

            첫풀이
            arr에 숫자 저장
            PriorityQueue<Integer[]> 값, 인덱스 저장, 값 오름차순 정렬해서 최소값 peek()으로 알수있게
            arr순회하면서
            새로운 값 추가
            boolean 빠지는위치 true
            while(peek 인덱스 = true)
                poll
            최소값answer배열 저장

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];
        int[] answer = new int[N];

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        for (int i = 0; i < L; i++) {
            pq.add(new Integer[]{arr[i], i});
            answer[i] = pq.peek()[0];
        }
        for (int i = L; i < N; i++) {
            pq.add(new Integer[]{arr[i], i});
            visited[i - L] = true;
            while (visited[pq.peek()[1]])
                pq.poll();
            answer[i] = pq.peek()[0];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.print(sb);


    }
}