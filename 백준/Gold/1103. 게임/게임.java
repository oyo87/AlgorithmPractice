import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		/*
		 * 보드의 크기 N, M : 1~5
		 * 
		 * 보드의 상태 : 1~9 || 'H'
		 * 
		 * 무한 움직일수있다면 -1
		 *
		 * H는 0으로 치환
		 * 
		 * bfs+dp
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				if (temp.charAt(j) != 'H')
					board[i][j] = temp.charAt(j) - '0';
			}
		}

		int[][] dp = new int[N][M];

		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] { 0, 0 });

		int answer = 0;
		boolean graph = false;// 무한으로 가능
		int[][] delta = new int[4][2];

		while (!q.isEmpty()) {
			answer++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer[] poll = q.poll();
				int r = poll[0];
				int c = poll[1];
				int num = board[r][c];

				// 상우하좌
				delta[0][0] = -num;
				delta[1][1] = num;
				delta[2][0] = num;
				delta[3][1] = -num;

				for (int j = 0; j < 4; j++) {
					int nr = r + delta[j][0];
					int nc = c + delta[j][1];

					if (0 <= nr && 0 <= nc && nr < N && nc < M && board[nr][nc] != 0 && dp[nr][nc] < answer) {

						q.add(new Integer[] { nr, nc });
						dp[nr][nc] = answer;
					}
				}

			}

			if (N * M < answer) {// 최대이동횟수를 초과해서 이동하면 무한이동가능
				graph = true;
				break;
			}
		}

		if (graph)
			System.out.print(-1);
		else
			System.out.print(answer);
	}
}