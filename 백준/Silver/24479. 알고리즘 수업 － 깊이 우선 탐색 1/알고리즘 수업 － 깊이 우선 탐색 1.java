import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] al;
    static int[] arr;
    static int[] answer;
    static int count = 1;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        al = new ArrayList[N + 1];
        answer = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al[a].add(b);
            al[b].add(a);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(al[i]);
        }

        dfs(R);

        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);

    }

    private static void dfs(int num) {

        visited[num] = true;
        answer[num] = count++;
        for (int i = 0; i < al[num].size(); i++) {
            if (!visited[al[num].get(i)]) {
                visited[al[num].get(i)] = true;
                dfs(al[num].get(i));
            }
        }


    }
}
