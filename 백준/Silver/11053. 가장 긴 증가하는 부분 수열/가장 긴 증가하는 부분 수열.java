import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LIS
//DP
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N + 1];
		int dp[] = new int[N + 1]; // dp[i] == i번째 수열일때 가장 긴 증가 부분수열 길이

		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		dp[1] = 1;
		int answer = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);

	}
}