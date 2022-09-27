import java.util.Scanner;

public class Solution {
	static int[] ticket = new int[4];
	static int result;
	static int[] month = new int[16]; // 넉넉하게 16까지 받아둔다.
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < 4; i++)
				ticket[i] = sc.nextInt();
			result = ticket[3]; // 1년권을 일단 최소값으로
			for (int i = 1; i <= 12; i++)
				month[i] = sc.nextInt();
			recursion(1, 0);

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		} // tc끝
		System.out.println(sb);
	}

	static void recursion(int depth, int fee) {// depth == 월
		if (12 < depth) {
			result = Math.min(result, fee);
			return;
		}

		if (ticket[0] * month[depth] <= ticket[1]) {// 일일권이 더 저렴
			recursion(depth + 1, fee + ticket[0] * month[depth]); // 일일권 사용
		} else
			recursion(depth + 1, fee + ticket[1]);// 일개월권 사용
		recursion(depth + 3, fee + ticket[2]);// 3개월권 사용

	}
}
