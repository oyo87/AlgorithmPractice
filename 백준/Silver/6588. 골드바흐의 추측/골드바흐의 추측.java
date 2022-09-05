import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//에라토스테네스의 체를 이용하여 100만이하소수를 구해두고
//b-a가 큰것부터 하나하나 판별해보기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = 1000000;
		boolean[] primeNumber = new boolean[max + 1];
		for (int i = 2; i <= max; i++) {
			primeNumber[i] = true;
		}

		for (int i = 2; i <= max; i++) {
			for (int j = i * 2; j <= max; j += i) {
				if (primeNumber[j] == false)
					continue;
				primeNumber[j] = false;
			}
		}

		while (true) {
			StringBuilder sb = new StringBuilder();
			int test = Integer.parseInt(br.readLine());
			boolean flag = false;
			if (test == 0)
				break;
			for (int i = 2; i <= test / 2; i++) {
				if (primeNumber[i] && primeNumber[test - i]) {
					sb.append(test + " = " + i + " + " + (test - i));
					flag = true;
					break;
				}
			}
			if (flag)
				System.out.println(sb);
			else
				System.out.println("Goldbach's conjecture is wrong.");
		}

	}
}
