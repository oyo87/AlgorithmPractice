import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 수열 A의 크기 : 1~1,000 수열A를 이루는 수 : 1~1,000
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// LIS
		int[] dp = new int[N];
		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j <= i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = 1;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}

		StringBuilder sb = new StringBuilder();

		sb.append(max).append("\n");

		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; 0 <= i; i--) {
			if (dp[i] == max) {
				stack.push(arr[i]);
				max--;
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}

		System.out.print(sb);

	}
}