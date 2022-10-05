import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//직접 모양 만들고 다 구한다..? 너무 번거롭다.
//T자 블럭을 제외하면 4번탐색한 DFS로 모든 블럭이 처리가 가능하다
//T자 블럭의 탐색은 직접 따로 구현해준다.
public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int answer; // 최대값
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 상우하좌

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, arr[i][j], 1);
				visited[i][j] = false;
			}
		}

		System.out.println(answer);
	}

	private static void dfs(int row, int col, int sum, int depth) {
		if (depth == 4) {
			answer = Math.max(answer, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (rangeCheck(row, col, i)) {
				int nextRow = row + delta[i][0];
				int nextCol = col + delta[i][1];
				if (!visited[nextRow][nextCol]) {
					if (depth == 2) {// T자는 두번째탐색때 상하좌우한번추가
						visited[nextRow][nextCol] = true;
						dfs(row, col, sum + arr[nextRow][nextCol], depth + 1);// T자모양 계산위해 상하좌우 하나씩 더해두고 지금상태로.
						visited[nextRow][nextCol] = false;
					}

					visited[nextRow][nextCol] = true;
					dfs(nextRow, nextCol, sum + arr[nextRow][nextCol], depth + 1);
					visited[nextRow][nextCol] = false;

				}
			}
		}

	}

	private static boolean rangeCheck(int row, int col, int i) {
		if (0 <= row + delta[i][0] && row + delta[i][0] < N && 0 <= col + delta[i][1] && col + delta[i][1] < M)
			return true;
		return false;
	}
}
