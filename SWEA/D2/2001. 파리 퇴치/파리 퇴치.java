import java.util.Scanner;

//설계
//현재 위치arr[r][c] 부터 r+m, c+m 범위를 탐색하며 모두 더한다.
//탐색 범위는 N-m, N-m 까지만 하면 된다.
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 5 <= N <= 15
			int M = sc.nextInt();// 2 <= M <= N

			int[][] arr = new int[N][N];
			int max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			} // 2차원배열 채우기

			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;

					//
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							sum += arr[i + k][j + l];
						}
					} // arr[i][j]부터 arr[i+M][j+M]범위까지의 모든 합을 담음
					max = Math.max(max, sum);

				} // arr배열 col 반복문
			} // arr배열 row 반복문
			System.out.printf("#%d %d\n", tc, max);
		} // tc 반복문
	}
}
