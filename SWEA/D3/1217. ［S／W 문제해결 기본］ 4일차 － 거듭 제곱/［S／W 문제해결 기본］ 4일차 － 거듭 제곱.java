import java.util.Scanner;

public class Solution {

	static int sum;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int testnum = sc.nextInt();
			sb.append("#").append(testnum).append(" ");

			int num = sc.nextInt();
			int pow = sc.nextInt(); // 몇제곱할지
			sum = 1;
			sb.append(Recursion(num, pow)).append("\n");
		}
		System.out.println(sb);
	}

	private static int Recursion(int num, int pow) {
		if (pow == 0)
			return sum;
		sum *= num;
		sum = Recursion(num, pow - 1);
		return sum;

	}
}
