import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        단 두 그룹으로 정점 분할이 가능한지 파악
        테스트케이스 K : 2~5
        정점의 개수 V :  1~20000
        간선의 개수 E : 1~200,000

        bfs탐색, int[] 방문배열로 1,2로 집합 파악
        내가 1일경우 연결된 정점이 0이면 2로, 2라면 pass, 1이라면 이분그래프가 아님

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < K; tc++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] list = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList<>();
            }

            int[] visited = new int[V + 1];
            Queue<Integer> q = new LinkedList<>();
            //리스트에 간선 등록
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
                list[end].add(start);
            }

            boolean success = true;
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    q.add(i);
                    visited[i] = 1;

                    while (!q.isEmpty()) {
                        int vertex = q.poll();
                        int group = visited[vertex];

                        for (int j = 0; j < list[vertex].size(); j++) {
                            int nextVertex = list[vertex].get(j);
                            int nextGroup = group % 2 + 1;

                            if (visited[nextVertex] == 0) {
                                q.add(nextVertex);
                                visited[nextVertex] = nextGroup;
                            } else if (visited[nextVertex] == group) {
                                success = false;
                                break;
                            }
                        }
                    }
                }
            }

            if (success)
                sb.append("YES");
            else
                sb.append("NO");

            sb.append("\n");


        }

        System.out.print(sb);

    }
}