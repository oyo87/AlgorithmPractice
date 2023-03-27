import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;
    static PriorityQueue<Node> queue;

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int dist;

        public Node(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }


        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1]; //unionFind의 parent
        for (int i = 1; i < parent.length; i++)
            parent[i] = i;

        queue = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            queue.add(new Node(start, end, dist));
        }
        int usedEdge = 0;//사용한 E의 수
        int answer = 0;//거리
        while (usedEdge < V - 1) {//간선-1개의 엣지를 선택하면 끝
            Node poll = queue.poll();
            if(find(poll.start) != find(poll.end)){
                union(poll.start, poll.end);
                usedEdge++;
                answer += poll.dist;
            }
        }

        System.out.println(answer);
    }

    public static void union(int num1, int num2) {
        if (find(num1) != find(num2)) {
            parent[find(num2)] = find(num1);
        }
    }

    public static int find(int num){
        if(parent[num] == num)
            return num;
        return parent[num] = find(parent[num]);
    }
}