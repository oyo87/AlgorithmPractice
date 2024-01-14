import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char[][] map;

    static Queue<Integer[]> q = new LinkedList<>();

    static boolean[][] visited1;

    static boolean[][] visited2;

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        /*
            맵 크기 N : 1~100

            정상, 적록색약인 사람의 구역수
            정상 : bfs, visited활용 구역수 체크
            적록색약 : R,G를 하나로 취급하는 bfs 진행
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int[] answer = new int[2];//0일반, 1적록색약

        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];//적록색약
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    q.add(new Integer[]{i, j});
                    visited1[i][j] = true;
                    bfs(true);
                    answer[0]++;
                }

                if (!visited2[i][j]) {
                    q.add(new Integer[]{i, j});
                    visited2[i][j] = true;
                    bfs(false);
                    answer[1]++;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.print(sb);

    }

    static void bfs(boolean normal) {


        if (normal) {//일반
            while (!q.isEmpty()) {
                Integer[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];
                char color = map[r][c];

                for (int i = 0; i < 4; i++) {
                    int nr = r + delta[i][0];
                    int nc = c + delta[i][1];

                    if (0 <= nr && 0 <= nc && nr < N && nc < N && !visited1[nr][nc] && map[nr][nc] == color) {
                        visited1[nr][nc] = true;
                        q.add(new Integer[]{nr, nc});
                    }
                }
            }
        } else {//적록색약
            while (!q.isEmpty()) {
                Integer[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];
                char color = map[r][c];

                if (color == 'B') {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + delta[i][0];
                        int nc = c + delta[i][1];

                        if (0 <= nr && 0 <= nc && nr < N && nc < N && !visited2[nr][nc] && map[nr][nc] == color) {
                            visited2[nr][nc] = true;
                            q.add(new Integer[]{nr, nc});
                        }
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + delta[i][0];
                        int nc = c + delta[i][1];

                        if (0 <= nr && 0 <= nc && nr < N && nc < N && !visited2[nr][nc] && (map[nr][nc] == 'R' || map[nr][nc] == 'G')) {
                            visited2[nr][nc] = true;
                            q.add(new Integer[]{nr, nc});
                        }
                    }

                }

            }
        }

    }
}