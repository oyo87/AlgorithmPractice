import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] box;

    static int delta[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        /*
            상자의 크기 N,M : 2~100
            상자의 수 H : 1~100
            
            BFS 구현
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        Queue<Integer[]> q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        q.add(new Integer[]{i, j, k, 0});
                    }
                }
            }
        }

        int answer = 0;
        //bfs하면서 answer구하기
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int h = poll[0];//박스높이
            int r = poll[1];//row
            int c = poll[2];//col
            int day = poll[3];//익은 날짜

            answer = Math.max(answer, day);

            //상우하좌 덜익은토마토면 익게하기
            for (int i = 0; i < 4; i++) {
                int nr = r + delta[i][0];
                int nc = c + delta[i][1];
                if (0 <= nr && 0 <= nc && nr < N && nc < M && box[h][nr][nc] == 0) {
                    q.add(new Integer[]{h, nr, nc, day + 1});
                    box[h][nr][nc] = 1;
                }
            }
            //윗칸 아래칸 익게하기
            if (0 <= h - 1 && box[h - 1][r][c] == 0) {
                q.add(new Integer[]{h - 1, r, c, day + 1});
                box[h - 1][r][c] = 1;

            }
            if (h + 1 < H && box[h + 1][r][c] == 0) {
                q.add(new Integer[]{h + 1, r, c, day + 1});
                box[h + 1][r][c] = 1;
            }


        }

        //박스안에 익지않은 토마토가 존재하면 -1출력
        loop:
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        answer = -1;
                        break loop;
                    }
                }
            }
        }

        System.out.print(answer);

    }
}