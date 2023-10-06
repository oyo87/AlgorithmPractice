import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        전깃줄 개수 1~100
        위치의 번호 1~500

        LIS(최장증가부분수열)을 활용해서 풀이가능
        없애야하는 전깃줅의 최소 개수를 구하기 위해 주어진 전체 전선 수에서 LIS를 뺀다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] pole = new int[N][2];//전봇대 [][0] = A ,[][1] = B

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pole[i][0] = Integer.parseInt(st.nextToken());
            pole[i][1] = Integer.parseInt(st.nextToken());
        }

        //A전봇대 기준으로 정렬
        Arrays.sort(pole, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int[] dp = new int[N];
        int max = 0;//주어진 input내에서 연결가능한 최대 전선 수
        //LIS
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (pole[j][1] < pole[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.print(N - max);


    }
}