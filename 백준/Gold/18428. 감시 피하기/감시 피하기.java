import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int N;

    public static void main(String[] args) throws IOException {
        /*
        array크기 N : 3~6
        전체 선생님의 수는 1~5
        전체 학생의 수 1~30
        빈칸은 최소 3개이상

        X에 하나씩 두면서 조합 완탐
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] originArr = new char[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                originArr[i][j] = st.nextToken().charAt(0);
            }
        }

        comb(originArr, 0);

        System.out.print("NO");
    }

    static void comb(char[][] originArr, int depth) {

        if (depth == 3) {
            if (success(originArr)) {
                System.out.print("YES");
                System.exit(0);
            }
            return;
        }


        //originArr -> arr clone
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = originArr[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'X') {
                    arr[i][j] = 'O';
                    comb(arr, depth + 1);
                    arr[i][j] = 'X';
                }
            }
        }
    }

    static boolean success(char[][] arr) {
        Queue<Integer[]> q;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'T') {
                    //bfs 선생님시작 상하좌우에 학생있으면 안됨
                    q = new LinkedList<>();
                    for (int k = 0; k < 4; k++) {
                        q.add(new Integer[]{i, j, k});
                    }
                    while (!q.isEmpty()) {
                        Integer[] poll = q.poll();
                        int r = poll[0];
                        int c = poll[1];
                        int dir = poll[2];


                        int nr = r + delta[dir][0];
                        int nc = c + delta[dir][1];

                        if (0 <= nr && 0 <= nc && nr < N && nc < N) {
                            if (arr[nr][nc] == 'S') {
                                return false;
                            }
                            if (arr[nr][nc] == 'X') {
                                q.add(new Integer[]{nr, nc, dir});
                            }
                        }

                    }
                }
            }
        }

        return true;
    }
}