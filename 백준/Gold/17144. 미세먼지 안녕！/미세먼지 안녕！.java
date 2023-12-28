import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int T;
    static int[][] map1;
    static int[][] map2;

    static int[][] now;//현재시간대의 상태
    static int[][] next;//다음시간대의 상태
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int[] upper = {-1, -1};//청정기 상단
    static int[] lower = {-1, -1};//청정기 하단
    static int time;

    public static void main(String[] args) throws IOException {
        /*
            맵크기 R,C : 6~50
            지난 시간초 T : 1~1,000

            맵 값 : -1~1,000

            미세먼지 확산 진행 : 현재 미세먼지(퍼뜨려야함), 새로 확산된 미세먼지 구별필요 맵 두개만들어서 하나씩 활용하기
            공기청정기 작동 : 위,아래 각 for 4번사용해서 구현
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map1 = new int[R][C];
        map2 = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map1[i][j] = Integer.parseInt(st.nextToken());

                //청정기 상단,하단위치저장
                if (map1[i][j] == -1) {
                    if (upper[0] == -1)
                        upper = new int[]{i, j};
                    else
                        lower = new int[]{i, j};
                }
            }
        }

        //T초간 미세먼지확산,공기청정기작동진행
        time = 0;
        while (time < T) {
            if (time % 2 == 0) {
                now = map1;
                next = map2;
            } else {
                now = map2;
                next = map1;
            }

            spreadDust();//먼지확산

            cleanUpper();//청정기윗부분

            cleanLower();//청정기아랫부분

            time++;
        }

        //남아있는미세먼지양 출력
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (0 < next[i][j])
                    answer += next[i][j];
            }
        }

        System.out.print(answer);

    }

    static void cleanUpper() {
        int r = upper[0];
        int c = upper[1];

        //상
        for (int i = r - 1; 0 < i; i--) {
            next[i][c] = next[i - 1][c];
        }

        //우
        for (int i = c; i < C - 1; i++) {
            next[0][i] = next[0][i + 1];
        }

        //하
        for (int i = 0; i < r; i++) {
            next[i][C - 1] = next[i + 1][C - 1];
        }

        //좌
        for (int i = C - 1; c + 1 < i; i--) {
            next[r][i] = next[r][i - 1];
        }
        next[r][c + 1] = 0;
    }

    static void cleanLower() {
        int r = lower[0];
        int c = lower[1];

        //하
        for (int i = r + 1; i < R - 1; i++) {
            next[i][c] = next[i + 1][c];
        }

        //우
        for (int i = c; i < C - 1; i++) {
            next[R - 1][i] = next[R - 1][i + 1];
        }

        //상
        for (int i = R - 1; r < i; i--) {
            next[i][C - 1] = next[i - 1][C - 1];
        }

        //좌
        for (int i = C - 1; c + 1 < i; i--) {
            next[r][i] = next[r][i - 1];
        }
        next[r][c + 1] = 0;


    }

    static void spreadDust() {


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                next[i][j] = now[i][j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (0 < now[i][j]) {//확산
                    for (int k = 0; k < 4; k++) {
                        int nr = i + delta[k][0];
                        int nc = j + delta[k][1];

                        if (0 <= nr && 0 <= nc && nr < R && nc < C && next[nr][nc] != -1) {//배열내, 빈공간
                            next[nr][nc] += now[i][j] / 5;
                            next[i][j] -= now[i][j] / 5;
                        }
                    }
                }
            }
        }


    }
}