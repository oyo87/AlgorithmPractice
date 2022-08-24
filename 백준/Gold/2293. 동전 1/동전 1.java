import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//주어진 동전들을 최소화해서 합을 만들기
//DP로 인한 풀이. 2차원배열하면 메모리초과
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer((br.readLine()));

		int n = Integer.parseInt(st.nextToken());// 동전의개수
		int k = Integer.parseInt(st.nextToken());// 원하는 합
		int[] coin = new int[n + 1];// 사용가능동전
		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[k + 1];
		dp[0] = 1;//0원을 만드는 케이스는 아무것도 하지않는 케이스 하나.

		for (int i = 1; i <= n; i++) {
			for (int j = coin[i]; j <= k; j++) {//현재금액부터시작
				dp[j] += dp[j - coin[i]];// 점화식. 현재위치에서 현재금액뺀곳만큼 더하면됨
			}
		}

		bw.write(String.valueOf(dp[k]));
		bw.flush();
		bw.close();
	}
}
