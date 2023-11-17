import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static char[][] map;

    static boolean[][] visited;
    static int endR;
    static int endC;
    static Queue<Integer[]> q = new LinkedList<>();
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        /*
            맵 크기 R,C = 1~50

            BFS로 탐색 가능해보인다.
            물, 고슴도치 위치 큐에 넣고
            물이라면 4방향 물로, (돌,비버굴 제외)
            고슴도치라면 4방향이동 (물,돌제외)
            되돌아갈 필요 없으니 고슴도치위치 visited사용

            비버굴 도착하면 시간 출력
            큐빌때까지 도착 못하면 KAKTUS
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        int startR = -1;
        int startC = -1;
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == '*') {
                    q.add(new Integer[]{i, j, -1});//-1 == 물
                } else if (map[i][j] == 'D') {
                    endR = i;
                    endC = j;
                } else if (map[i][j] == 'S') {
                    map[i][j] = '.';
                    startR = i;
                    startC = j;
                    visited[i][j] = true;
                }
            }
        }
        q.add(new Integer[]{startR, startC, 0});// 0 == 이동시간


        bfs();
        if (answer == -1)
            System.out.print("KAKTUS");
        else
            System.out.print(answer);

    }

    static void bfs() {
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};// 상 우 하 좌

        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int time = poll[2];//-1이라면 물

            if (time == -1) {//물이면 4방향 확장
                for (int i = 0; i < 4; i++) {
                    int nr = r + delta[i][0];
                    int nc = c + delta[i][1];

                    if (0 <= nr && 0 <= nc && nr < R && nc < C && map[nr][nc] == '.') {//평지를 물로변경
                        q.add(new Integer[]{nr, nc, -1});
                        map[nr][nc] = '*';
                    }
                }

            } else {//4방향 이동, 비버집이라면 return
                for (int i = 0; i < 4; i++) {
                    int nr = r + delta[i][0];
                    int nc = c + delta[i][1];

                    //다음 이동지점이 배열범위내, 평지이거나 비버위치면 이동가능
                    if (0 <= nr && 0 <= nc && nr < R && nc < C && (map[nr][nc] == '.' || map[nr][nc] == 'D') && !visited[nr][nc]) {
                        if (map[nr][nc] == 'D') {
                            answer = time + 1;
                            return;
                        }
                        q.add(new Integer[]{nr, nc, time + 1});
                        visited[nr][nc] = true;
                    }
                }


            }

        }
    }
}