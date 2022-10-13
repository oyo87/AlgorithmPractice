import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] W = new int[N + 1];// 무게
		int[] V = new int[N + 1];// 가치
		int[][] dp = new int[N + 1][K + 1];// 행 물품의 무게, 열 1~k까지의 무게, 값 : 물품의 최대가치누적
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {// i==현재 넣어볼 물건
			for (int j = 1; j < K + 1; j++) {// j==현재 넣을수있는무게
				if (W[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[N][K]);

	}
}