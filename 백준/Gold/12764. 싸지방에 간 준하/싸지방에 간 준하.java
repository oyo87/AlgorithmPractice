import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            사람의 수 N : 1~100,000
            컴퓨터 이용 시작, 종료 시간 P,Q : 0~1,000,000

            모든 사람이 기다리지 않아도 되는 컴퓨터의 최소 개수 X 출력
            컴퓨터 각 자리별 몇명의 사람이 사용했는지 출력

            use Count int[N] n개의 컴퓨터별 사용횟수을 관리해주고

            PriorityQueue(컴퓨터번호) N개만큼 사용해서 현재 비어있는 컴퓨터 관리
            PriorityQueue이용해서 컴퓨터 사용, 종료, answer 계산

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] useCount = new int[N];

        PriorityQueue<Integer> canUse = new PriorityQueue<>();//사용가능 컴퓨터
        for (int i = 0; i < N; i++) {
            canUse.add(i);
        }

        //[0] = 시간 [1] = 0은 시작시간이라는의미 1은 종료시간이라는의미
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });

        int[][] input = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        for (int i = 0; i < N; i++) {
            int start = input[i][0];
            int end = input[i][1];
            pq.add(new Integer[]{start, 0, i});
        }

        int max = 0;
        while (!pq.isEmpty()) {
            Integer[] poll = pq.poll();
            int time = poll[0];
            int status = poll[1];

            if (status == 0) {//시작시간
                int computerNumber = canUse.poll();
                useCount[computerNumber]++;

                max = Math.max(max, computerNumber);

                int index = poll[2];
                pq.add(new Integer[]{input[index][1], 1, computerNumber});//끝나는시간 저장
            } else {//끝시간
                int computerNumber = poll[2];
                canUse.add(computerNumber);//사용중인 컴퓨터 반환
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max + 1).append("\n");
        for (int i = 0; i < max + 1; i++)
            sb.append(useCount[i]).append(" ");

        System.out.print(sb);


    }
}