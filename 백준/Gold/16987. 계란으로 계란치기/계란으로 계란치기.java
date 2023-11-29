import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        /*
            계란의 수 N : 1~8
            계란의 내구도 S : 1~300
            계란의 무게 W : 1~300

            1,2,3 규칙 수행하며 가장 많은 계란 깨기
            계란수가 8이하이므로 재귀로 모두 탐색


         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] egg = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken());
            egg[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(egg, 0, 0);

        System.out.print(answer);
    }

    static void dfs(int[][] egg, int brokenEgg, int now) {
        if (now == N) {
            answer = Math.max(answer, brokenEgg);
            return;
        }

        if (egg[now][0] <= 0 || brokenEgg == N - 1) {//현재 계란이 깨졌거나, 나머지 모든 계란이 깨진 상태
            dfs(egg, brokenEgg, now + 1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == now)
                continue;

            if (0 < egg[i][0]) {
                int brokenCount = 0;

                egg[i][0] -= egg[now][1];
                egg[now][0] -= egg[i][1];

                if (egg[i][0] <= 0)
                    brokenCount++;
                if (egg[now][0] <= 0)
                    brokenCount++;

                dfs(egg, brokenEgg + brokenCount, now + 1);

                egg[i][0] += egg[now][1];
                egg[now][0] += egg[i][1];
            }
        }

    }
}