import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//3의배수면 3나누기 2의배수면 2나누기
//10일때 일단 문제가 발생한다. 수학적으로 해결하려하니 쉽지않다. 642..!
//방법은 DP였다.
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
		}
		bw.write(String.valueOf(dp[N]));

		bw.flush();
		bw.close();
	}
}
