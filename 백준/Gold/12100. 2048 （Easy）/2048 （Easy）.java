import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] cloneMap;
    static int answer = 2;

    public static void main(String[] args) throws IOException {
        /*
            보드의 크기 N : 1~20
            0은 빈칸, 숫자는 2~1024 사이의 2의 배수로 시작
            한번의 이동에서 합쳐진 블록은 또 다른 블록과 합쳐질 수 없다.

            각 방향에 맞게 이동, 합치기 구현

            최대 5번이동 완탐
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(map, 0);

        System.out.print(answer);
    }

    static void recursion(int[][] map, int depth) {

        if (depth == 5) {
            //최대값 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    answer = Math.max(answer, map[i][j]);
                }
            }
            return;
        }

        for (int dir = 0; dir < 4; dir++) {//상우하좌 이동방향
            //clone map
            cloneMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cloneMap[i][j] = map[i][j];
                }
            }

            cloneMap = move(cloneMap, dir);
            recursion(cloneMap, depth + 1);
        }
    }

    static int[][] move(int[][] map, int dir) {
        //상으로 이동
        if (dir == 0) {
            for (int i = 0; i < N; i++) {
                int index = 0; // 블록 이동 인덱스
                int block = 0; // 블록 내부 값
                for (int j = 0; j < N; j++) {
                    if (map[j][i] != 0) {
                        if (block == map[j][i]) {//블록 합치기
                            map[index - 1][i] = block * 2;//합쳐진곳
                            block = 0;
                            map[j][i] = 0;//합쳐지면서 빈공간
                        } else {//블록 이동
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index++;
                        }
                    }
                }
            }
        } else if (dir == 1) {//우로 이동
            for (int i = 0; i < N; i++) {
                int index = N - 1;
                int block = 0;
                for (int j = N - 1; j >= 0; j--) {
                    if (map[i][j] != 0) {
                        if (block == map[i][j]) {
                            map[i][index + 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        } else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index--;
                        }
                    }
                }
            }
        } else if (dir == 2) {//하로 이동
            for (int i = 0; i < N; i++) {
                int index = N - 1;
                int block = 0;
                for (int j = N - 1; j >= 0; j--) {
                    if (map[j][i] != 0) {
                        if (block == map[j][i]) {
                            map[index + 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        } else {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index--;
                        }
                    }
                }
            }
        } else {//좌로 이동
            for (int i = 0; i < N; i++) {
                int index = 0;
                int block = 0;
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 0) {
                        if (block == map[i][j]) {
                            map[i][index - 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        } else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index++;
                        }
                    }
                }
            }
        }

        return map;
    }
}