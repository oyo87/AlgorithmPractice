import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int[][] map;
	static int[][][] delta = {

			{},

			{ { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, // 상우하좌

			{ { -1, 0 }, { 1, 0 } }, // 상하

			{ { 0, -1 }, { 0, 1 } }, // 좌우

			{ { -1, 0 }, { 0, 1 } }, // 상우

			{ { 1, 0 }, { 0, 1 } }, // 하우

			{ { 1, 0 }, { 0, -1 } }, // 하좌

			{ { -1, 0 }, { 0, -1 } }// 상좌

	};// [숫자][1이면 4,2~7까지는 2][2]

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 배열x축
			M = sc.nextInt();// 배열y축
			int R = sc.nextInt();// 출발지점x축
			int C = sc.nextInt();// 출발지점y축
			int L = sc.nextInt();// 탈출후소요시간 만약 1이라면 제자리 2라면 한칸씩움직이기가능
			int answer = 0;

			map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			Queue<int[]> q = new LinkedList<>();
			visited[R][C] = true;
			int[] init = { R, C, map[R][C], 0 };// r, c, 해당값, depth
			q.add(init);
			while (!q.isEmpty()) {
				int[] pollTemp = q.poll();
				if (pollTemp[3] == L - 1)// depth가 L-1이면 꺼내기만하기
					continue;
				for (int i = 0; i < delta[pollTemp[2]].length; i++) {
					if (RangeCheck(pollTemp[0], pollTemp[1], pollTemp[2], i)) {// 배열범위내인지, 0이아닌지 체크

						if (!visited[pollTemp[0] + delta[pollTemp[2]][i][0]][pollTemp[1] + delta[pollTemp[2]][i][1]]) {// 방문을
																														// 안했으면
							int[] addTemp = { pollTemp[0] + delta[pollTemp[2]][i][0],
									pollTemp[1] + delta[pollTemp[2]][i][1],
									map[pollTemp[0] + delta[pollTemp[2]][i][0]][pollTemp[1] + delta[pollTemp[2]][i][1]],
									pollTemp[3] + 1 };
							// 이동할 위치에서 원래 위치로 돌아올 수 있으면 이동할위치 방문처리해주고 q에 넣어주자
							for (int j = 0; j < delta[addTemp[2]].length; j++) {
								if (RangeCheck(addTemp[0], addTemp[1], addTemp[2], j)) {
									if (addTemp[0] + delta[addTemp[2]][j][0] == pollTemp[0]
											&& addTemp[1] + delta[addTemp[2]][j][1] == pollTemp[1]) {
										visited[addTemp[0]][addTemp[1]] = true;
										q.add(addTemp);
									}
								}
							}

						}
					}
				}
			} // BFS end

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] == true)
						answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);

		} // tc end
	}// main end

	private static boolean RangeCheck(int r, int c, int pipe, int idx) {
		if (0 <= r + delta[pipe][idx][0] && r + delta[pipe][idx][0] < N && 0 <= c + delta[pipe][idx][1]
				&& c + delta[pipe][idx][1] < M && map[r + delta[pipe][idx][0]][c + delta[pipe][idx][1]] != 0)
			return true;
		return false;
	}
}
