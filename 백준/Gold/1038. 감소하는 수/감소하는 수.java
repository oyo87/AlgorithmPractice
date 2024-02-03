import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static List<Long> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		/*
		 * N : 0~1,000,000 N번째 감소하는 수 출력
		 * long 필요 9876543210
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N <= 10) {
			System.out.print(N);
			return;
		}

		if (1023 <= N) {// 0~9로 만들 수 있는 10자리의 숫자 조합(2^10) - 아무것도선택안한것
			System.out.print(-1);
			return;
		}

		for (int i = 0; i < 10; i++) {
			recursion(i);
		}

		Collections.sort(list);
		System.out.print(list.get(N));

	}

	static void recursion(long num) {
		list.add(num);
		long mod = num % 10;
		if (mod == 0)
			return;

		for (long i = mod - 1; 0 <= i; i--) {
			long next = num * 10 + i;
			recursion(next);
		}
	}
}