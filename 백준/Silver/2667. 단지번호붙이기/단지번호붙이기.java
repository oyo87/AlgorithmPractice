import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//BFS
//좀 복잡하고 이상하게 짠 느낌
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		for (int i = 0; i < N; i++) {
			String tempStr = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = tempStr.charAt(j) - '0';
			}
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					int tempAnswer = 1;
					Queue<int[]> q = new LinkedList<>();
					int[] init = { i, j };
					q.add(init);
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int[] poll = q.poll();
						int r = poll[0];
						int c = poll[1];

						for (int k = 0; k < 4; k++) {
							int newr = r + delta[k][0];
							int newc = c + delta[k][1];
							if (0 <= newr && newr < N && 0 <= newc && newc < N && arr[newr][newc] == 1
									&& !visited[newr][newc]) {
								int[] temp2 = { newr, newc };
								q.add(temp2);
								visited[newr][newc] = true;
								tempAnswer++;
							}
						}

					}
					answer.add(tempAnswer);
				}
			}
		}
		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size()).append("\n");
		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i)).append("\n");
		}
		System.out.println(sb);

	}
}
