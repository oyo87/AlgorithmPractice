import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][][] visited;
    static String[] template = {"XX..", "..XX", "X.X.", ".X.X"};//상하좌우

    public static void main(String[] args) throws IOException {
        /*
        배열 크기 가로세로 모두 1~1000
        'X"는 벽, '.'은 빈공간

        탐색 구현
        상   하
        XX   ..
        ..   XX
        좌   우
        X.   .X
        X.   .X

        4가지 패턴 찾기

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N <= 2 || M <= 2) {//첫줄,마지막줄,첫열,마지막열은 모두 벽
            System.out.print(0);
            return;
        }
        visited = new boolean[N - 1][M - 1][2];//[][][0]하,[1]우 두 방향만 체크
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        StringBuilder sb;
        int answer = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                sb = new StringBuilder();
                sb.append(map[i][j]);
                sb.append(map[i][j + 1]);
                sb.append(map[i + 1][j]);
                sb.append(map[i + 1][j + 1]);
                for (int k = 0; k < 4; k++) {
                    if (possible(i, j, sb.toString(), k)) {
                        answer++;
                    }
                }
            }
        }
        System.out.print(answer);

    }

    static boolean possible(int r, int c, String str, int i) {
        //i 0123 -> 상하좌우

        if (str.equals(template[i])) {//패턴 같은지 검증
            // 액자 걸 자리에 이미 액자걸려있는지 확인
            if (i == 0 || i == 1) {
                if (!visited[r][c][0] && !visited[r][c + 1][0]) {
                    visited[r][c][0] = true;
                    visited[r][c + 1][0] = true;
                    return true;
                }
            } else {// i==2 || i==3
                if (!visited[r][c][1] && !visited[r + 1][c][1]) {
                    visited[r][c][1] = true;
                    visited[r + 1][c][1] = true;
                    return true;
                }
            }
        }

        return false;
    }
}