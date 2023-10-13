import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        표의 크기 N : 1~1024
        합을 구해야하는 횟수 M : 1~100,000
        표안의 값 : 1~1000

        가로구간합 미리 구해두고 연산
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[N + 1][N + 1];
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] = sum[i][j - 1] + arr[i][j];
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int answer = 0;
            for (int i = r1; i <= r2; i++) {
                answer += sum[i][c2] - sum[i][c1 - 1];
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb);

    }
}