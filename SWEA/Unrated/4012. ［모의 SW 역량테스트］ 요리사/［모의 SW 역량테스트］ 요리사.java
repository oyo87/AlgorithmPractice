import java.util.Scanner;

public class Solution {

	static int N;
	static int min;
	static int[][] synergy;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			min = Integer.MAX_VALUE;
			synergy = new int[N][N];
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {// 2차원 시너지 배열 생성
				for (int j = 0; j < N; j++) {
					synergy[i][j] = sc.nextInt();
				}
			}
			Recursion(0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		} // tc 끝
		System.out.println(sb);
	}

	static void Recursion(int depth, int start) {
		if (depth == N / 2) {
			// 조건
			int tempA = 0;
			int tempB = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visit[i] && visit[j]) {
						tempA += synergy[i][j] + synergy[j][i];
					} else if (!visit[i] && !visit[j])
						tempB += synergy[i][j] + synergy[j][i];
				}
			}
			min = Math.min(min, Math.abs(tempA - tempB));

			return;
		}

		for (int i = start; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				Recursion(depth + 1, i + 1);// 두번째인덱스로 위치를 잡는다. 그래야 조합이 됨. 이거 없이하니 중복된것들도 다 돌려서 시간초과
				visit[i] = false;
			}
		}

	}
}
