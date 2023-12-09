import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int E;
    static int v1;
    static int v2;
    static long answer = Integer.MAX_VALUE;

    static ArrayList<Integer[]>[] edges;

    public static void main(String[] args) throws IOException {
        /*
            정점의 개수 N : 2~800
            간선 개수 E : 0~200,000
            정점간거리 : 1~1,000

            시작 -> v1->v2->목적지
            시작 -> v2->v1->목적지 중 최단경로출력
            불가능하면 -1
            데이크스트라 활용 최단거리 구하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[start].add(new Integer[]{end, cost});
            edges[end].add(new Integer[]{start, cost});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long tempAnswer = 0;

        //dijkstra 1->v1->v2->N
        tempAnswer += dijkstra(1, v1);
        tempAnswer += dijkstra(v1, v2);
        tempAnswer += dijkstra(v2, N);

        answer = Math.min(answer, tempAnswer);

        tempAnswer = 0;
        //dijkstra 1->v2->v1->N
        tempAnswer += dijkstra(1, v2);
        tempAnswer += dijkstra(v2, v1);
        tempAnswer += dijkstra(v1, N);

        answer = Math.min(answer, tempAnswer);

        if (answer == Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(answer);
    }

    static long dijkstra(int start, int end) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        pq.add(new Integer[]{start, 0});

        while (!pq.isEmpty()) {
            Integer[] poll = pq.poll();
            int now = poll[0];
            int cost = poll[1];

            if (visited[now])
                continue;
            visited[now] = true;

            for (int i = 0; i < edges[now].size(); i++) {
                int nextV = edges[now].get(i)[0];
                int nextCost = edges[now].get(i)[1];

                if (cost + nextCost < dist[nextV] && !visited[nextV]) {
                    pq.add(new Integer[]{nextV, cost + nextCost});
                    dist[nextV] = cost + nextCost;
                }
            }
        }

        return dist[end];

    }
}