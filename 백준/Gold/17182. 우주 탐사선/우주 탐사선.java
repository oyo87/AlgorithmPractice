import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int K;
    static ArrayList<Integer[]>[] edges;
    static int[][] dist;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        /*
            행성의 개수 N : 2~10
            ana호가 발사되는 행성의 위치 K ; 0~N-1
            각 행성간 이동시간 T : 0~1000

            모든행성 탐사위한 최소 시간

            최단경로이므로 데이크스트라의 모든 최단거리 구하고
            dfs로 전체를 탐사하는데 걸리는 최소시간 구하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //edges init
        edges = new ArrayList[N];
        for (int i = 0; i < N; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (i == j)
                    st.nextToken();
                else
                    edges[i].add(new Integer[]{j, Integer.parseInt(st.nextToken())});
            }
        }

        //get dist
        dist = new int[N][N];//[i][j] i에서 j까지가는데 최소값
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < N; i++) {
            dijkstra(i);
        }

        //get answer
        boolean[] visited = new boolean[N];
        visited[K] = true;
        dfs(K, visited, 0, 1);

        System.out.print(answer);

    }

    static void dfs(int now, boolean[] visited, int cost, int depth) {
        if (depth == N) {
            answer = Math.min(answer, cost);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == now)
                continue;

            if (!visited[i]) {
                visited[i] = true;
                dfs(i, visited, cost + dist[now][i], depth + 1);
                visited[i] = false;
            }

        }

    }

    static void dijkstra(int start) {

        dist[start][start] = 0;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        pq.add(new Integer[]{start, 0});

        boolean[] visited = new boolean[N];
        while (!pq.isEmpty()) {
            Integer[] poll = pq.poll();
            int now = poll[0];
            int nowCost = poll[1];
            visited[now] = true;

            for (int i = 0; i < edges[now].size(); i++) {
                int next = edges[now].get(i)[0];
                int nextCost = edges[now].get(i)[1];

                if (!visited[next] && nowCost + nextCost < dist[start][next]) {
                    dist[start][next] = nowCost + nextCost;
                    pq.add(new Integer[]{next, nowCost + nextCost});
                }
            }
        }

    }
}