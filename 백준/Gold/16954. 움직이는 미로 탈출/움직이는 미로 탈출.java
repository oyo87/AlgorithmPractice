import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        크기 : 8 * 8
        맨위의 벽이 바닥으로 내려오는 7턴 까지 9방향 이동하며 벽에 부딪히지 않으면 오른쪽 위로 이동 가능
        9^7 : 약 470만

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //map 생성
        char[][][] map = new char[9][8][8]; //[0]turn, [1]row, [2]col
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[0][i][j] = str.charAt(j);
            }
        }

        //7턴까지 벽을 한칸씩 내린 map 생성
        for (int i = 1; i < 8; i++) {
            for (int j = i; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    map[i][j][k] = map[i - 1][j - 1][k];
                }
            }
        }

        //bfs
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{7, 0, 0}); //시작위치는 7,0
        int[][] delta = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {0, 0}};//제자리 포함 9방탐색
        boolean success = false;
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int turn = poll[2];

            if (turn == 8) {
                success = true;
                break;
            }

            for (int i = 0; i < 9; i++) {
                int nr = delta[i][0] + r;
                int nc = delta[i][1] + c;

                //배열내, 다음 이동위치가 현재 벽이아니고, 다음턴에 벽과 겹치지 않는 위치면 큐에 추가
                if (0 <= nr && 0 <= nc && nr < 8 && nc < 8 && map[turn][nr][nc] != '#' && map[turn + 1][nr][nc] != '#') {
                    q.add(new Integer[]{nr, nc, turn + 1});
                }
            }
        }

        if (success)
            System.out.print(1);
        else
            System.out.print(0);
    }
}