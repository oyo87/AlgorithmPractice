import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static String[][] arr;
    static Set<Integer> set = new HashSet<>();

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        /*
        완전제곱수 : 어떤 정소를 제곱한 수

        표 사이즈 1~9 * 1~9
        표 값 : 0~9
        만들수있는 최대 수 : 999,999,999

        Set에 완전제곱수 저장
        행, 열 등차수열 이루는것 완탐

        종료조건에 대한 이해를 잘못했었다.
        배열 끝까지 등차수열 이어나가는것이 아니라 중간에 멈추기도 가능함

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp.substring(j, j + 1);
            }
        }



        for (int i = 0; i * i < 999999999; i++) {
            set.add(i * i);
        }

        if (N == 1 && M == 1 && set.contains(Integer.parseInt(arr[0][0]))) {
            System.out.print(arr[0][0]);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //i==r, j==c

                // 등차수열
                for (int k = -N + 1; k < N; k++) {
                    for (int l = -M + 1; l < M; l++) {
                        if (k == 0 && l == 0)
                            continue;
                        recursion(new StringBuilder(arr[i][j]), i, j, k, l, 1);//row, col, row증가량 plus row, col증가량 plus col
                    }
                }
            }
        }

        System.out.print(answer);
    }

    static void recursion(StringBuilder sb, int r, int c, int pr, int pc, int depth) {

        int temp = Integer.parseInt(sb.toString());

        if (set.contains(temp) && answer < temp) {
            answer = temp;
        }

        int nr = pr * depth + r;
        int nc = pc * depth + c;

        //다음 탐색값이 배열 범위가 아니라면 종료

        if (nr < 0 || nc < 0 || N <= nr || M <= nc) {
            return;
        }

        StringBuilder newSb = new StringBuilder(sb);

        newSb.append(arr[nr][nc]);
        recursion(newSb, r, c, pr, pc, depth + 1);

    }
}