import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static int[][] map;

    static boolean[][] visited;

    static int answer = Integer.MAX_VALUE;

    static Queue<Integer[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        /*
        미로의 크기 R,C : 1~1,000

        불가능 or 가장 빠른 탈출시간 구하기

        bfs이용
        매턴마다 지훈이 4방향 이동, 불 4방향 확장
        지훈이가 벽 끝에 도착한순간 최단기간 탈출
        bfs동안 탈출못할경우 IMPOSSIBLE

        벽을 -1로 저장, 불은 1로 저장

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = temp.charAt(j);
                if (c == '#') {//벽
                    map[i][j] = -1;
                } else if (c == 'F') {//불
                    map[i][j] = 1;
                } else if (c == 'J') {//지훈
                    q.add(new Integer[]{i, j, 1});//row,col,time
                    visited[i][j] = true;
                }
            }
        }

        //불 큐에 추가
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1)
                    q.add(new Integer[]{i, j, -1});//row,col,불
            }
        }

        bfs();

        if (answer == Integer.MAX_VALUE)
            System.out.print("IMPOSSIBLE");
        else
            System.out.print(answer);

    }

    static void bfs() {
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//상 우 하 좌 이동


        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int status = poll[2];//시간 or 불

            if (status == -1) {//불
                for (int i = 0; i < 4; i++) {
                    int nr = r + delta[i][0];
                    int nc = c + delta[i][1];

                    if (0 <= nr && 0 <= nc && nr < R && nc < C && map[nr][nc] == 0) {
                        q.add(new Integer[]{nr, nc, -1});
                        map[nr][nc] = 1;
                    }
                }
            } else {//지훈
                if (map[r][c] == 1)//불
                    continue;

                if ((r == 0 || r == R - 1 || c == 0 || c == C - 1) && map[r][c] == 0) {//탈출공간 도착
                    answer = status;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = r + delta[i][0];
                    int nc = c + delta[i][1];

                    if (0 <= nr && 0 <= nc && nr < R && nc < C && map[nr][nc] == 0 && !visited[nr][nc]) {
                        q.add(new Integer[]{nr, nc, status + 1});
                        visited[nr][nc] = true;
                    }
                }
            }


        }
    }
}