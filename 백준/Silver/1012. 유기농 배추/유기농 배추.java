import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//BFS로 해결해보자
public class Main {
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N;
	static int M;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();// 가로길이
			N = sc.nextInt();// 세로길이
			int K = sc.nextInt();// 배추 개수
			arr = new int[N][M];
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[y][x] = 1;
			}

			int answer = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {
					if (arr[row][col] == 1) {
						Queue<int[]> q = new LinkedList<>();
						int[] temp = { row, col };
						arr[row][col] = 0;
						q.add(temp);
						answer++;
						while (!q.isEmpty()) {
							int[] pollTemp = q.poll();
							for (int i = 0; i < 4; i++) {
								int tempRow = pollTemp[0] + delta[i][0];
								int tempCol = pollTemp[1] + delta[i][1];
								if (bfsCheck(tempRow, tempCol)) {// 배열범위안이고 값이1이라면
									arr[tempRow][tempCol] = 0;
									int[] addTemp = { tempRow, tempCol };
									q.add(addTemp);
								}
							}
						}

					}
				}
			}
			System.out.println(answer);
		} // tc end
	}

	private static boolean bfsCheck(int tempRow, int tempCol) {
		if (0 <= tempRow && tempRow < N && 0 <= tempCol && tempCol < M && arr[tempRow][tempCol] == 1)
			return true;
		return false;
	}// main end
}
