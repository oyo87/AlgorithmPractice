import java.util.Scanner;

//dp를 이용한다.
//구글검색을 해보며 규칙을 알게되었다..
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] dp = new int[n + 1];

		int answer = 0;
		if (n % 2 == 1) {// 홀수 불가
			answer = 0;
		} else {
			dp[0] = 1;
//			dp[1] = 0;
			dp[2] = 3;//가로가로가로, 가로아래 세로세로, 세로세로아래 가로

			for (int i = 4; i <= n; i += 2) {
				dp[i] = dp[i - 2] * dp[2];
				for (int j = i - 4; 0 <= j; j -= 2) {
					dp[i] += dp[j] * 2;
				}
			}

			answer = dp[n];
		}
		System.out.println(answer);
	}
}
