import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//n은 10000이하
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		boolean[] prime = new boolean[10001];
		for (int i = 2; i < 10001; i++)
			prime[i] = true;

		// 에라토스테네스의체 소수는 true 아니면 false
		for (int i = 2; i <= Math.sqrt(10001); i++) {
			for (int j = i + i; j < 10001; j += i) {
				prime[j] = false;
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());// 합을 만들 숫자
			int temp = n / 2;

			for (int i = temp; 2 <= i; i--) {// 두 수 차이가 적어야해서 비슷한것부터 시작해서 점점 벌려나가며탐색
				if (prime[i] && prime[n - i]) {// 둘다소수
					sb.append(i).append(" ").append(n - i).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}

}
