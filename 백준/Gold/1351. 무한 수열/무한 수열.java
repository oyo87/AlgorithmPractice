import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static long N, P, Q;
	static Map<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		/*
		 * N : 0~10^12
		 * 
		 * P : 2이상
		 * 
		 * Q : Q<=10^9
		 * 
		 * N 범위가 매우 크다. dp를 배열이 아닌 Map으로 해결
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());

		System.out.print(recursion(N));

	}

	static long recursion(long num) {

		// A0 = 1
		if (num == 0)
			return 1;

		if (map.containsKey(num))
			return map.get(num);

		long a = (long) Math.floor(num / P);
		long b = (long) Math.floor(num / Q);

		// Ai = Ai/P + Ai/Q 내림(값을 넘지 않는 가장 큰 정수)
		map.put(num, recursion(a) + recursion(b));
		return map.get(num);
	}
}