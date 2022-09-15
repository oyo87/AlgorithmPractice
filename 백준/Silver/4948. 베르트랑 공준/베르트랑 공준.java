import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;

			boolean[] prime = new boolean[(2 * n) + 1];

			if (n == 0)
				break;

			prime[0] = prime[1] = true;

			// 에라토스테네스의 체
			for (int i = 2; i * i <= 2 * n; i++) {
				if (!prime[i]) {
					for (int j = i * i; j <= 2 * n; j += i) {
						prime[j] = true;
					}
				}
			}

			for (int i = n + 1; i <= 2 * n; i++) {
				if (prime[i] == false)
					count++;
			}
			System.out.println(count);
		}

	}

}