import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static int answer = 0;

    static int deleteNode = 0;

    public static void main(String[] args) throws IOException {
        /*
            노드의 개수 N : 1~50

            N의 개수는 적다.
            dfs이용 탐색하면서 리프노드 개수 완탐

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent != -1) {
                list[i].add(parent);
                list[parent].add(i);
            } else
                root = i;
        }

        visited = new boolean[N];
        deleteNode = Integer.parseInt(br.readLine());
        if (deleteNode != root)
            dfs(root);

        System.out.print(answer);


    }

    static void dfs(int now) {

        visited[now] = true;
        int childNode = 0;
        for (int i = 0; i < list[now].size(); i++) {
            int next = list[now].get(i);

            if (!visited[next] && next != deleteNode) {
                childNode++;
                dfs(next);
            }
        }

        if (childNode == 0)//리프노드
            answer++;


    }
}