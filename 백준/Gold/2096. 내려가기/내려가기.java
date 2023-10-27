import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        줄 수 N : 1~100,000
        숫자 범위 0~9

        최대점수, 최소점수 출력
        dp활용하면 될듯하다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][3];
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] min = new int[N + 1][3];
        int[][] max = new int[N + 1][3];
        min[1][0] = arr[1][0];
        min[1][1] = arr[1][1];
        min[1][2] = arr[1][2];
        max[1][0] = arr[1][0];
        max[1][1] = arr[1][1];
        max[1][2] = arr[1][2];

        for (int i = 2; i < N + 1; i++) {
            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + arr[i][0];
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + arr[i][0];

            min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + arr[i][1];
            max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + arr[i][1];

            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + arr[i][2];
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + arr[i][2];
        }

        int[] answer = new int[2];//최대, 최소점수
        answer[0] = 0;
        answer[1] = 2111111111;
        for (int i = 0; i < 3; i++) {
            answer[0] = Math.max(answer[0], max[N][i]);
            answer[1] = Math.min(answer[1], min[N][i]);
        }

        System.out.print(answer[0] + " " + answer[1]);

    }
}