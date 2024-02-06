import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;
	static int answer = 0;
	static Queue<Integer[]> q = new LinkedList<>();
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		/*
		 * SAFE ZONE의 최소 개수 출력
		 * 
		 * 지도의 크기 : 1~1,000
		 * 
		 * BFS를 탐색하면서 !visited면 answer++, 내가갈방향인데 !visited거나 나한테 오는방향인데 !visited면 bfs에
		 * 추가
		 *
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					answer++;
				}
			}
		}

		System.out.print(answer);

	}

	static void bfs(int pr, int pc) {// parameter row, parameter col

		visited[pr][pc] = true;
		q.add(new Integer[] { pr, pc });
		while (!q.isEmpty()) {
			Integer[] poll = q.poll();
			int r = poll[0];
			int c = poll[1];

			int nr = r;// next row
			int nc = c;

			if (map[r][c] == 'U') {
				nr -= 1;
			} else if (map[r][c] == 'R') {
				nc += 1;
			} else if (map[r][c] == 'D') {
				nr += 1;
			} else {// 'L'
				nc -= 1;
			}
			if (0 <= nr && 0 <= nc && nr < N && nc < M && !visited[nr][nc]) {
				visited[nr][nc] = true;
				q.add(new Integer[] { nr, nc });
			}

			// 4방중 !visited이면서 나를 향하고있으면 추가
			for (int i = 0; i < 4; i++) {
				nr = r + delta[i][0];
				nc = c + delta[i][1];
				if (0 <= nr && 0 <= nc && nr < N && nc < M && !visited[nr][nc]) {
					boolean flag = false;

					if (i == 0 && map[nr][nc] == 'D') {// 상
						flag = true;
					} else if (i == 1 && map[nr][nc] == 'L') {// 우
						flag = true;
					} else if (i == 2 && map[nr][nc] == 'U') {// 하
						flag = true;
					} else if (i == 3 && map[nr][nc] == 'R') {// 좌
						flag = true;
					}

					if (flag) {
						visited[nr][nc] = true;
						q.add(new Integer[] { nr, nc });
					}

				}
			}

		} // while end

	}

}