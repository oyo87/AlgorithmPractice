import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int cheeseCount = 0;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        /*
        BFS이용 구현하기
        모눈종이의 크기 N,M : 5~100

        외부공기 체크하기 : 테두리전체 순회하면서 0이고, 방문하지 않은곳있으면 bfs로 외부공기 체크
        체크한 외부공기 바탕으로 1인데 4변중 2변이상 외부공기면 한시간후 사라질치즈

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cheeseCount++;
            }
        }

        solution();
        System.out.print(answer);
    }

    static void solution() {
        //-1 외부공기, 0공기, 1치즈, 2사라질 치즈


        while (true) {
            //외부공기 체크 0 -> -1
            Queue<Integer[]> q = new LinkedList<>();
            q.add(new Integer[]{0, 0});
            map[0][0] = -1;
            while (!q.isEmpty()) {
                Integer[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];

                for (int i = 0; i < 4; i++) {
                    int nr = r + delta[i][0];
                    int nc = c + delta[i][1];

                    if (0 <= nr && 0 <= nc && nr < N && nc < M && map[nr][nc] == 0) {
                        map[nr][nc] = -1;
                        q.add(new Integer[]{nr, nc});
                    }
                }
            }

            //맵 전체순회 하면서 1인것 찾아서 두면이상 -1이면 2가됨 큐에넣어줌
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    if (map[i][j] == 1) {
                        int temp = 0;
                        for (int k = 0; k < 4; k++) {
                            int nr = i + delta[k][0];
                            int nc = j + delta[k][1];

                            if (map[nr][nc] == -1)
                                temp++;
                            if (2 <= temp) {
                                map[i][j] = 2;
                                q.add(new Integer[]{i, j});
                                cheeseCount--;
                                break;
                            }
                        }
                    }
                }
            }

            answer++;
            if (cheeseCount == 0)
                return;

            //큐에들어간 2를 -1로변경
            while (!q.isEmpty()) {
                Integer[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];

                map[r][c] = -1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == -1)
                        map[i][j] = 0;
                }
            }
        }

    }
}