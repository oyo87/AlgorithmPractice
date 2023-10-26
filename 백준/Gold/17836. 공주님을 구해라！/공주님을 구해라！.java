import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        /*
        성의크기 N,M : 3~100
        구할 제한시간 T 1~10000

        그람고려없이 최단으로 가는것 한번돌리고

        그람획득후 벽부수고 이동하는 최단 구하기
        bfs인자로 r,c,,이동횟수,그람여부0,1(미획득,획득)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new Integer[]{0, 0, 0});
        visited[0][0] = true;
        int answer = -1;
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int time = poll[2];

            if (T < time)
                break;

            if (r == N - 1 && c == M - 1) {
                answer = poll[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + delta[i][0];
                int nc = c + delta[i][1];
                if (0 <= nr && 0 <= nc && nr < N && nc < M && map[nr][nc] != 1 && !visited[nr][nc]) {
                    q.add(new Integer[]{nr, nc, time + 1});
                    visited[nr][nc] = true;
                }
            }
        }

        q.clear();
        visited = new boolean[N][M];
        q.add(new Integer[]{0, 0, 0, 0});
        visited[0][0] = true;
        boolean[][] visited2 = new boolean[N][M];//그람에서부터시작
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int time = poll[2];
            int skill = poll[3];

            if (T < time)
                break;
            if (r == N - 1 && c == M - 1) {
                if (answer == -1)
                    answer = time;
                else
                    answer = Math.min(answer, time);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + delta[i][0];
                int nc = c + delta[i][1];
                //스킬미사용일때는 일반탐색
                if (skill == 0) {
                    if (0 <= nr && 0 <= nc && nr < N && nc < M && !visited[nr][nc] && map[nr][nc] != 1) {
                        int temp = 0;
                        if (map[nr][nc] == 2) {//다음목적지에 그람이있을경우
                            temp = 1;
                            visited2[nr][nc] = true;
                        }
                        q.add(new Integer[]{nr, nc, time + 1, skill + temp});
                        visited[nr][nc] = true;
                    }
                } else if (skill == 1) { //그람획득시에는 벽도이동가능, 초기화된 visited사용
                    if (0 <= nr && 0 <= nc && nr < N & nc < M && !visited2[nr][nc]) {
                        q.add(new Integer[]{nr, nc, time + 1, skill});
                        visited2[nr][nc] = true;
                    }
                }
            }
        }


        if (answer == -1)
            System.out.print("Fail");
        else
            System.out.print(answer);

    }
}