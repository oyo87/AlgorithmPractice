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
             건물의 개수 N : 2~1,000
             건물 건설순서 규칙의 개수 K : 1~100,000
             건물 건설 시간 : 0~100,000

             특정 건물을 가장 빨리 지을때까지 걸리는 최소시간 구하기

             특정건물에서 시작해서 해당 건물을 짓기위해 필요한 전단계들 타고가면서 최대시간 체크
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] buildTime = new int[N + 1];//해당 건물 건설 시간

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            int[] inDegree = new int[N + 1];
            ArrayList<Integer>[] list = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list[start].add(end);

                inDegree[end]++;
            }

            int W = Integer.parseInt(br.readLine());

            //위상정렬
            Queue<Integer> q = new LinkedList<>();
            int[] result = new int[N + 1];//해당 건물건설까지 걸리는 시간

            for (int i = 1; i < N + 1; i++) {
                result[i] = buildTime[i];

                if (inDegree[i] == 0)
                    q.add(i);
            }

            while (!q.isEmpty()) {
                Integer poll = q.poll();

                for (int i = 0; i < list[poll].size(); i++) {
                    int next = list[poll].get(i);
                    result[next] = Math.max(result[next], result[poll] + buildTime[next]);
                    inDegree[next]--;

                    if (inDegree[next] == 0)
                        q.add(next);
                }
            }
            sb.append(result[W]).append("\n");
        }//tc end
        System.out.print(sb);
    }
}