import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        1번도시 -> 나머지 도시로 가는 가장 빠른 시간 구하기

        도시의 개수 N : 1 ~ 500
        버스 노선 개수 M : 1 ~ 6,000
        시간 : -10,000 ~ 10,000

        음수사이클 발생시 -1출력
        음수사이클 감별 필요하니 벨만-포드 알고리즘 접근
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] edges = new int[M][3];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            edges[i][0] = start;
            edges[i][1] = end;
            edges[i][2] = time;
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        //N-1번 모든 엣지 탐색
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                int start = edges[j][0];
                int end = edges[j][1];
                int time = edges[j][2];

                if (dist[start] == Long.MAX_VALUE)
                    continue;

                if (dist[start] + time < dist[end]) {
                    dist[end] = dist[start] + time;
                }
            }
        }

        //N번째 반복에서 dist 변경생기면 음의 사이클 존재
        boolean minusCycle = false;
        for (int i = 0; i < M; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            int time = edges[i][2];

            if (dist[start] == Long.MAX_VALUE)
                continue;

            if (dist[start] + time < dist[end]) {
                minusCycle = true;
                break;
            }
        }


        StringBuilder sb = new StringBuilder();
        if (minusCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i < N + 1; i++) {
                if (dist[i] == Long.MAX_VALUE)
                    sb.append(-1);
                else
                    sb.append(dist[i]);
                sb.append("\n");
            }

        }
        System.out.print(sb);
    }
}