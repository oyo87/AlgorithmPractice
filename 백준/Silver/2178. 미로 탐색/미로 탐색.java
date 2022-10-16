
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		Queue<int[]> q = new LinkedList<>();
		int[] init = { 0, 0, 1 };// row, col, depth
		visited[0][0] = true;
		q.add(init);
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int row = poll[0];
			int col = poll[1];
			int depth = poll[2];

			if (row == N - 1 && col == M - 1) {
				System.out.println(depth);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int dr = delta[i][0];
				int dc = delta[i][1];

				if (0 <= row + dr && row + dr < N && 0 <= col + dc && col + dc < M && !visited[row + dr][col + dc]
						&& map[row + dr][col + dc] == 1) {// 배열 범위 내, 방문 안했고, 맵 값이 1이라면
					int[] temp = { row + dr, col + dc, depth + 1 };
					visited[row + dr][col + dc] = true;
					q.add(temp);
				}
			}

		}
	}
}
