import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 최대 1000글자의 알파벳 대문자 주 문자여 ㄹ주어짐 LCS길이, LCS 출력하기 LCS가 0인경우 출력 X
		 * 
		 * DP
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();

		// LCS by dp
		int max = 0;
		int[][] dp = new int[A.length() + 1][B.length() + 1];
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				if (A.charAt(i) == B.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
				max = Math.max(max, dp[i + 1][j + 1]);
			}
		}

		if (max == 0) {
			System.out.print(0);
			return;
		}
		StringBuilder sb = new StringBuilder();
		// 숫자가 올라가는 부분 찾아서 append
		int i = A.length();
		int j = B.length();

		while (0 < i && 0 < j) {

			if (dp[i][j] == dp[i - 1][j])
				i--;
			else if (dp[i][j] == dp[i][j - 1])
				j--;
			else {
				sb.append(B.charAt(j-1));
				i--;
				j--;
			}
		}
		sb.reverse();

		System.out.println(max);
		System.out.print(sb);

	}
}