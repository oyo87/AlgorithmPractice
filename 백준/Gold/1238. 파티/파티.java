import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;//학생(정점)
    static int M;//도로(엣지)
    static int X;//최종도착지
    static ArrayList<Node>[] list;
    static ArrayList<Node>[] reverseList;

    static class Node implements Comparable<Node> {
        int end;//도착지
        int dist;//거리

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist; // 오름차순
        }
    }


    public static void main(String[] args) throws IOException {

        //오고가는길 양방향 다익스트라 최대길이 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//학생(정점) 수
        M = Integer.parseInt(st.nextToken());//도로(엣지) 수
        X = Integer.parseInt(st.nextToken());//최종도착지점

        list = new ArrayList[N + 1];
        reverseList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();//정방향
            reverseList[i] = new ArrayList<>();//양방향
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, dist)); // 정방향 그래프 정보 입력
            reverseList[end].add(new Node(start, dist)); // 역방향 그래프 정보 입력
        }

        int[] distResult = dijkstra(list); // X에서 모든 정점까지의 최단 거리
        int[] reverseDistResult = dijkstra(reverseList); // 모든 정점에서 X까지의 최단 거리

        int answer = 0;
        for (int i = 1; i < N + 1; i++)
            answer = Math.max(answer, distResult[i] + reverseDistResult[i]);
        System.out.println(answer);
    }

    public static int[] dijkstra(ArrayList<Node>[] parameterList) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));

        boolean[] visited = new boolean[N + 1];
        int[] distArr = new int[N + 1]; // 인덱스부터 X까지의 거리
        Arrays.fill(distArr, Integer.MAX_VALUE); //초기화
        distArr[X] = 0; //도착지 자기자신

        //BFS
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node forNode : parameterList[cur]) {
                    if (!visited[forNode.end] && distArr[cur] + forNode.dist < distArr[forNode.end]) {
                        distArr[forNode.end] = distArr[cur] + forNode.dist;
                        pq.add(new Node(forNode.end, distArr[forNode.end]));
                    }
                }
            }

        }
        return distArr;

    }
}