import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        보드의 크기 N : 2~100
        사과의 개수 K : 0~100
        뱀의 방향 변환 횟수 L : 1 ~ 100
        게임시작후 X초 끝난 뒤 방향회전 : 1 ~ 10,000
        방향 전환 정보 C : L or D

        게임이 몇초에 끝나는지 출력

        int[][] map, visited, queue
        head(r,c,direction)

        매초마다 direction방향 이동
        이동시 queue에 추가, visited true
            이미 방문한곳 or 벽이면 끝
        사과가 아닐경우 queue에서 하나빼서 visited false

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 1;//사과
        }

        int L = Integer.parseInt(br.readLine());
        int time = 0;

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        char C = st.nextToken().charAt(0);
        boolean[][] visited = new boolean[N][N];
        Queue<Integer[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new Integer[]{0, 0});
        int[] head = {0, 0, 1};//r,c, 방향 0,1,2,3 == 상 우 하 좌
        int command = 1;//L 명령 받은 횟수
        boolean commandEnd = false;
        while (true) {
            int r = head[0];
            int c = head[1];
            int dir = head[2];

            //움직임
            if (time <= X || command == L) {
                if (command == L)
                    commandEnd = true;

                time++;

                int nr = r;//next r
                int nc = c;//next c

                if (dir == 0) {//상
                    nr--;
                } else if (dir == 1) {//우
                    nc++;
                } else if (dir == 2) {//하
                    nr++;
                } else {//좌
                    nc--;
                }

                if (nr < 0 || nc < 0 || N <= nr || N <= nc || visited[nr][nc]) {//배열 벗어나거나 꼬리밟음
                    break;
                }

                q.add(new Integer[]{nr, nc});
                if (map[nr][nc] == 0) {//사과가 없는경우 꼬리 감소
                    Integer[] poll = q.poll();//꼬리줄이기
                    visited[poll[0]][poll[1]] = false;
                } else {//이동방향이 사과면 사과 제거
                    map[nr][nc] = 0;
                }

                visited[nr][nc] = true;

                head[0] = nr;
                head[1] = nc;
                if (time == X) {
                    if (C == 'L') {//좌측 0->3 1->0 2->1 3->2
                        head[2] = (dir + 3) % 4;
                    } else {//우측 0->1 1->2 2->3 3->0
                        head[2] = (dir + 1) % 4;
                    }

                    if (command < L) {
                        st = new StringTokenizer(br.readLine());
                        X = Integer.parseInt(st.nextToken());
                        C = st.nextToken().charAt(0);
                        command++;
                    }

                }
                continue;
            }

        }

        System.out.print(time);
    }
}