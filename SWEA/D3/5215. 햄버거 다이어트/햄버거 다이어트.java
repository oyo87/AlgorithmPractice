import java.util.Scanner;

//부분수열 케이스 구한후 칼로리 조건범위내일때 max 점수를 구한다.
public class Solution {

	static boolean[] visit;
	static int N; // 재료의 수
	static int L; // 제한 칼로리
	static int max;
	static int[][] arr;

	static void Recursion(int n) {
		if (n == N) {
			int SumTaste = 0;
			int SumKcal = 0;
			for (int i = 0; i < N; i++) {
				if (visit[i] == true) {
					SumTaste += arr[i][0];
					SumKcal += arr[i][1];
				}
			}
			if (SumKcal <= L)
				max = Math.max(max, SumTaste);
			return;
		} else {
			visit[n] = true;
			Recursion(n + 1);
			visit[n] = false;
			Recursion(n + 1);
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 재료의 수
			L = sc.nextInt();// 제한 칼로리
			arr = new int[N][2];// 맛, 칼로리를 담는다.
			max = 0; // 최대 맛 저장

			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}

			visit = new boolean[N];
			Recursion(0);
			System.out.println("#" + tc + " " + max);

		} // tc for 끝
	}
}
