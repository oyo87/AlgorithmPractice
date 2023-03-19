import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static boolean[] visited;
    static ArrayList<Node>[] list;
    static int farthestNode; //가장 먼 vertex를 저장해둘것
    static int answer = 0;

    static class Node {
        int vertex;
        int distance;

        public Node(int v, int distance) {
            this.vertex = v;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {


        //정점번호, 정점까지의 거리가주어짐
        //리스트로 일단 다 등록해주고
        //DFS 두번 돌면서 처음에 가장먼곳중 한군데 찾고, 두번째에 가장 먼곳에서 먼곳까지의 거리 측정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];

        for (int i = 1; i < V + 1; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i < V + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int firstV = Integer.parseInt(st.nextToken()); // 처음 나온 정점
            int vNum = Integer.parseInt(st.nextToken());// 정점번호
            while (vNum != -1) {
                int dis = Integer.parseInt(st.nextToken());//거리
                list[firstV].add(new Node(vNum, dis));
                vNum = Integer.parseInt(st.nextToken());
            }
        }

        //임의의 정점 1에서 가장 먼것을 찾아서 node에 저장
        dfs(1, 0);
        visited = new boolean[V + 1];
        dfs(farthestNode, 0);

        System.out.println(answer);
    }

    private static void dfs(int vertex, int distance) {
        if (answer < distance) {
            answer = distance;
            farthestNode = vertex;//가장 먼곳
        }

        visited[vertex] = true;
        for (int i = 0; i < list[vertex].size(); i++) {
            Node node = list[vertex].get(i);
            if (!visited[node.vertex]) {
                visited[node.vertex] = true;
                dfs(node.vertex, node.distance + distance);
            }
        }
    }
}