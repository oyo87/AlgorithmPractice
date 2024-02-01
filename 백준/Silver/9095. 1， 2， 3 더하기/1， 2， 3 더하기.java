import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 테스트케이스의 개수 T
		 * 정수 n : 1~10
		 * 
		 * 1 = 1 1개
		 * 2 = 1+1, 2 2개
		 * 3 = 1+1+1, 2+1, 1+2,  3 4개
		 * 4 = 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 3+1, 1+3 7개
		 * 5 = 1+1+1+1+1, 1+1+1+2 * 4개, 1+2+2 * 3개, 1+3+1 * 3개, 3+2 *2개, 13개
		 *...
		 *점화식
		 * 
		 */

		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4; i<11; i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}

		System.out.print(sb);
	}
}