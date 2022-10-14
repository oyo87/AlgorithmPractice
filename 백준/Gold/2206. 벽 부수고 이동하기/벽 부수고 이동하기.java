import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int answer = -1;
	static boolean[][][] visited;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[2][N][M]; // 아무것도 안부수고 움직이던 visited와 부순이후 visited
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		Queue<int[]> q = new LinkedList<>();
		int[] init = { 0, 0, 0, 1 };// row, col, skill, depth
		q.add(init);
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int row = poll[0];
			int col = poll[1];
			int skill = poll[2];
			int depth = poll[3];

			if (row == N - 1 && col == M - 1) {// 가장 먼저 도착한게있으면 마무리 좌표를 1,1시작하게 입력을줘서 도착지점을 -1씩해주었다.
				answer = depth;
				break;
			}
			for (int i = 0; i < 4; i++) {
				if (skill == 0) {//벽안깬경우
					if (rangeCheck(row, col, i) && !visited[0][row + delta[i][0]][col + delta[i][1]]) {// 배열범위내부이고 방문
																										// 안한곳이면
						if (map[row + delta[i][0]][col + delta[i][1]] == 1) {// 벽인데 부수기가능
							visited[1][row + delta[i][0]][col + delta[i][1]] = true;
							int[] temp = { row + delta[i][0], col + delta[i][1], skill + 1, depth + 1 };
							q.add(temp);
						} else if (map[row + delta[i][0]][col + delta[i][1]] == 0) {// 벽이아닌경우
							visited[0][row + delta[i][0]][col + delta[i][1]] = true;
							visited[1][row + delta[i][0]][col + delta[i][1]] = true;
							int[] temp = { row + delta[i][0], col + delta[i][1], skill, depth + 1 };
							q.add(temp);
						}
					}
				} else {// skill==1 벽깨고돌아다니는중
					if (rangeCheck(row, col, i) && !visited[1][row + delta[i][0]][col + delta[i][1]]) {// 배열범위내부이고 방문
						// 안한곳이면
						if (map[row + delta[i][0]][col + delta[i][1]] == 0) {// 벽이아닌경우
							visited[1][row + delta[i][0]][col + delta[i][1]] = true;
							int[] temp = { row + delta[i][0], col + delta[i][1], skill, depth + 1 };
							q.add(temp);
						}
					}
				}
			}

		} // while end
		System.out.println(answer);

	}

	private static boolean rangeCheck(int row, int col, int i) {
		if (0 <= row + delta[i][0] && row + delta[i][0] < N && 0 <= col + delta[i][1] && col + delta[i][1] < M) {
			return true;
		}
		return false;
	}
}