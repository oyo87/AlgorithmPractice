import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            테스트케이스 최대 100개
            빌딩 너비와 높이 w,h : 1~1,000

            불을 먼저 이동시키고 상근이 이동하기
            bfs
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[w][h];
            Queue<Integer[]> q = new LinkedList<>();
            boolean[][] visitedFire = new boolean[w][h];
            for (int i = 0; i < w; i++) {
                String str = br.readLine();
                for (int j = 0; j < h; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '*') {
                        q.add(new Integer[]{i, j, -1});//불의 row,column, 불을 나타내는표시(-1)
                        visitedFire[i][j] = true;
                    }
                }
            }

            boolean[][] visited = new boolean[w][h];
            //상근이 넣어주기
            search:
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] == '@') {
                        q.add(new Integer[]{i, j, 0});
                        visited[i][j] = true;
                        break search;
                    }
                }
            }

            int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            int escapeTime = -1;
            bfs:
            while (!q.isEmpty()) {
                Integer[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];
                int depth = poll[2];//불이면 -1

                if (depth == -1) {//불이면 상하좌우 불붙이기
                    for (int i = 0; i < 4; i++) {
                        int nr = r + delta[i][0];
                        int nc = c + delta[i][1];

                        if (0 <= nr && 0 <= nc && nr < w && nc < h && (map[nr][nc] == '.' || map[nr][nc] == '@') && !visitedFire[nr][nc]) {
                            map[nr][nc] = '*';
                            visitedFire[nr][nc] = true;
                            q.add(new Integer[]{nr, nc, -1});

                        }
                    }
                } else {//상근이인경우 이동
                    for (int i = 0; i < 4; i++) {
                        int nr = r + delta[i][0];
                        int nc = c + delta[i][1];

                        //나가는곳이면 탈출
                        if (nr < 0 || nc < 0 || w <= nr || h <= nc) {
                            escapeTime = depth + 1;
                            break bfs;
                        }

                        //상근이 이동
                        if (map[nr][nc] == '.' && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            q.add(new Integer[]{nr, nc, depth + 1});
                        }
                    }
                }
            }

            if (escapeTime == -1)
                answer.append("IMPOSSIBLE");
            else
                answer.append(escapeTime);
            answer.append("\n");
        }

        System.out.print(answer);

    }
}