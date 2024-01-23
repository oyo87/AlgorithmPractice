import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static char[][] map = new char[12][6];
    static boolean[][] visited = new boolean[12][6];

    static int count = 1;

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        /*
            뿌요뿌요 구현하기
            상하좌우 4개이상 연결되었을경우 폭발
            아래로 땡기기
            폭발 반복하며 연쇄 체크
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        boolean boom = true;
        while (boom) {
            boom = false;
            visited = new boolean[12][6];
            //전체순회하며 .아니고 !visited라면 bfs진행, 4이상연결되면 폭발
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        count = 1;
                        visited[i][j] = true;
                        bfs(i, j, map[i][j]);
                        if (4 <= count)
                            boom = true;
                    }
                }
            }

            if (boom) {
//                System.out.println("시작");
//                for (int i = 0; i < 12; i++) {
//                    for (int j = 0; j < 6; j++) {
//                        System.out.print(map[i][j]);
//                    }
//                    System.out.println();
//                }
                answer++;
                drpp();
//                System.out.println("경계");
//                for (int i = 0; i < 12; i++) {
//                    for (int j = 0; j < 6; j++) {
//                        System.out.print(map[i][j]);
//                    }
//                    System.out.println();
//                }
//                System.out.println("끝");
            }

        }
        System.out.print(answer);


    }

    static void drpp() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; 0 <= j; j--) {
                if (map[j][i] == '.') {
                    for (int k = j - 1; 0 <= k; k--) {
                        if (map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    static void bfs(int row, int col, char color) {
        Queue<Integer[]> q = new LinkedList<>();
        Queue<Integer[]> address = new LinkedList<>();
        q.add(new Integer[]{row, col});
        address.add(new Integer[]{row, col});
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];


            for (int i = 0; i < 4; i++) {
                int nr = r + delta[i][0];
                int nc = c + delta[i][1];

                if (0 <= nr && 0 <= nc && nr < 12 && nc < 6 && !visited[nr][nc] && map[nr][nc] == color) {
                    visited[nr][nc] = true;
                    q.add(new Integer[]{nr, nc});
                    address.add(new Integer[]{nr, nc});
                    count++;
                }
            }
        }
        if (4 <= count) {
            while (!address.isEmpty()) {
                Integer[] poll = address.poll();
                int r = poll[0];
                int c = poll[1];

                map[r][c] = '.';
            }
        }
    }
}