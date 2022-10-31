import java.util.Scanner;

// DP문제
// 풀이를 참고하며 진행했다..@_@
public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 0부터 N까지의 정수
		int K = sc.nextInt(); // K개를 더해서 합이 N인개 구하기. 범위는 둘다 1~200

		int[][] dp = new int[K + 1][N + 1]; // k번 더해서 n이 되는 경우의 수
		for (int i = 1; i <= K; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000; //1,000,000,000으로 나눈 나머지 출력해야함
			}
		}
		System.out.println(dp[K][N]);
	}

}