import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R;
    static int C;
    static char[][] map;
    static int answer = 1;
    static boolean[] visited = new boolean[26];
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        /*
            범위 R,C : 1~20

            알파벳 겹치지 않고 최대한 몇칸을 지날수 있는가

            dfs탐색
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.print(answer);
    }

    static void dfs(int r, int c, int length) {
        if (visited[map[r][c] - 'A']) {
            answer = Math.max(answer, length);
            return;
        }

        visited[map[r][c] - 'A'] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];

            if (0 <= nr && 0 <= nc && nr < R && nc < C) {
                dfs(nr, nc, length + 1);
            }

        }
        visited[map[r][c] - 'A'] = false;
    }

}