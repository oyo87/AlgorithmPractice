import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger bi = new BigInteger("2");

		int N = sc.nextInt();
		bi = bi.pow(N);
		bi = bi.subtract(new BigInteger("1")); // 하노이탑 이동 횟수는 2의 n제곱 -1이다.
		System.out.println(bi);
		if (N <= 20)
			hanoi(N, 1, 2, 3);//1번, 2번, 3번막대
	}

	static void hanoi(int n, int start, int middle, int end) {
		if (n == 1) {
			System.out.println(start + " " + end);
			return;
		}

		hanoi(n - 1, start, end, middle);
		System.out.println(start + " " + end);
		hanoi(n - 1, middle, start, end);
		return;
	}
}
