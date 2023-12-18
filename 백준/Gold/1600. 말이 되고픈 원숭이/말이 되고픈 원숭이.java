import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int W;
    static int H;
    static int[][] map;
    static int answer = -1;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//상우하좌
    static int[][] horseMove = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        /*
        말의움직임횟수 K : 0~30
        맵크기 W,H : 1~200
        0은 평지, 1은 장애물

        최소한의 동작으로 시작지점 도착하기.bfs사용

        Queue<Integer[]> 현재위치, 사용한 말 움직임횟수, 이동횟수 기록
        상하좌우이동,
        말 8방향 이동
        
        boolean[r][c][말이동횟수] visited 활용

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.print(answer);

    }

    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[H][W][K + 1];//r,c,말이동횟수

        q.add(new Integer[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int horseCount = poll[2];//말이동횟수
            int cost = poll[3];

            if (r == H - 1 && c == W - 1) {
                answer = cost;
                return;
            }

            //상우하좌 이동
            for (int i = 0; i < 4; i++) {
                int nr = r + delta[i][0];
                int nc = c + delta[i][1];

                if (0 <= nr && 0 <= nc && nr < H && nc < W && !visited[nr][nc][horseCount] && map[nr][nc] != 1) {
                    visited[nr][nc][horseCount] = true;
                    q.add(new Integer[]{nr, nc, horseCount, cost + 1});
                }
            }

            //말 8방향 이동
            if (horseCount < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = r + horseMove[i][0];
                    int nc = c + horseMove[i][1];

                    if (0 <= nr && 0 <= nc && nr < H && nc < W && !visited[nr][nc][horseCount + 1] && map[nr][nc] != 1) {
                        visited[nr][nc][horseCount + 1] = true;
                        q.add(new Integer[]{nr, nc, horseCount + 1, cost + 1});
                    }
                }
            }

        }
    }
}