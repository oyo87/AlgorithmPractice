import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        수열의 크기 N : 1~2,000
        칠판에 적은 수 : 1~100,000
        질문의 개수 M : 1~1,000,000
        시작과 끝지점 S,E : 1<=S<=E<=N

        팰린드롬인경우 1, 아닌경우 0
        직접 비교 X

        dp로접근
        1. s,e가 같은경우 팰린드롬
        2. s,e가 s+1일경우 두 값이 같은경우 팰린드롬
        3. s,e가 s+2이상인경우 arr[s],arr[e]값이 같고 dp[s+1][e-1]이 팰린드롬이면 팰린드롬

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //dp init
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = i; j < N + 1; j++) {
                if (i == j) {//1
                    dp[i][j] = 1;
                } else if (i == j - 1 && arr[i] == arr[j]) {//2
                    dp[i][j] = 1;
                }
            }
        }
        //3
        for (int i = N; 0 < i; i--) {
            for (int j = i + 2; j < N + 1; j++) {
                if (arr[i] == arr[j] && dp[i + 1][j - 1] == 1)
                    dp[i][j] = 1;
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dp[s][e]).append("\n");
        }

        System.out.print(sb);
    }

}