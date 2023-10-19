import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int n;
    static int m;

    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        /*
        가로세로 크기 1~50

        전체 탐색 시작
        방문하지 않은 L이 발견되면
        bfs 가장 먼 지점 탐색 후 거리 answer 저장
        반복
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        //init
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'W') //물 지역은 미리 방문처리
                    visited[i][j] = true;
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    bfs(r, c);
                }
            }
        }

        System.out.print(answer);

    }

    static void bfs(int r, int c) {
        //r,c에서 시작해서 가장 먼 지점 탐색
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{r, c, 0});

        boolean[][] tempVisited = new boolean[n][m];
        tempVisited[r][c] = true;
        int dist = 0;
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();

            dist = poll[2];
            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + delta[i][0];
                int nc = poll[1] + delta[i][1];
                if (0 <= nr && 0 <= nc && nr < n && nc < m && map[nr][nc] == 'L' && !tempVisited[nr][nc]) {
                    tempVisited[nr][nc] = true;
                    q.add(new Integer[]{nr, nc, dist + 1});
                }
            }
        }

        answer = Math.max(answer, dist);
    }
}