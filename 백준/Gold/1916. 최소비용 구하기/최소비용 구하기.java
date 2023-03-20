import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//dfs 메모리초과?
public class Main {
    static int N; // 도시의 수 정점
    static int M; // 버스의 수 간선
    static ArrayList<Node>[] list;
    static int A; //시작지점
    static int B; //끝나는지점
    static int[] distance;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());//시작도시
        B = Integer.parseInt(st.nextToken());//출발도시

        dijkstra(A);

        System.out.println(distance[B]);
    }

    static void dijkstra(int start) {
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int vertex = node.vertex;

            if (visited[vertex])
                continue;
            visited[vertex] = true;

            for (Node n : list[vertex]) {
                int nextVertex = n.vertex;
                int nextDistance = distance[vertex] + n.distance;

                if (nextDistance < distance[nextVertex]) {
                    distance[nextVertex] = nextDistance;
                    queue.offer(new Node(nextVertex, nextDistance));
                }
            }
        }
    }
}