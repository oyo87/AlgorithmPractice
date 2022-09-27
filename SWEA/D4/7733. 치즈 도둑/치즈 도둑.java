import java.util.Scanner;

//입력받고
//day마다 day==면 0으로
//0,0부터 0이 아닌것들중에 visit안한곳 탐색, 종료되면 덩어리tempResult++
public class Solution {
	static int N;
	static int[][] map;
	static int maxTaste;
	static boolean[][] visit;
	static int day;
	static int maxResult;
	static int tempResult;
	static StringBuilder sb;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 상우하좌

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					maxTaste = Math.max(maxTaste, map[i][j]);// day를 maxTaste날까지만 계산하면 된다.
				}
			}

			visit = new boolean[N][N];
			day = 1;
			maxResult = 1;// 최대덩어리 기본값은 1
			tempResult = 0;
			while (day <= maxTaste) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == day)
							map[i][j] = 0;
					}
				} // day와 동일한 맛은 0으로 설정

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visit[i][j] && map[i][j] != 0) {
							Recursion(i, j);
							tempResult++;
							maxResult = Math.max(maxResult, tempResult);
						}
					}
				}
				visit = new boolean[N][N];
				tempResult = 0;
				day++;

			} // while end
			sb.append("#").append(tc).append(" ").append(maxResult).append("\n");
		} // tc end
		System.out.println(sb);
	}

	static void Recursion(int x, int y) {
		if (visit[x][y]) {
			return;
		}

		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			if (rangeCheck(x, y, i) && 0 < map[x + delta[i][0]][y + delta[i][1]]) {// 이동할곳이 0보다크면 이동
				Recursion(x + delta[i][0], y + delta[i][1]);
			}
		}

	}

	static boolean rangeCheck(int x, int y, int i) { // 인덱스 범위 벗어나는지체크
		if (0 <= x + delta[i][0] && x + delta[i][0] < N && 0 <= y + delta[i][1] && y + delta[i][1] < N)
			return true;
		return false;
	}
}
