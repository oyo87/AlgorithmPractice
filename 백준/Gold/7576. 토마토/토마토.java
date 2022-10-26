import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//상하좌우 -1이면 -1출력
//모두 0이면 -1
//모두 1이면 0출력
public class Main {
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 상우하좌
	static int M;
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());// 가로
		N = Integer.parseInt(st.nextToken());// 세로
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean possibleCheck = false;
		for (int i = 0; i < N; i++) {// 1이 하나라도 있는지 확인
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					possibleCheck = true;
					break;
				}
			}
		}

		// 0이 하나도 없으면 0출력
		boolean noZero = true;
		start: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					noZero = false;
					break start;
				}
			}
		}
		if (noZero) {
			System.out.println(0);
			return;
		}

		start: for (int i = 0; i < N; i++) {// 0인데 -1로 둘러쌓여있는 공간이 있는지 확인
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					int count = 0;
					int minusCount = 0;
					for (int k = 0; k < 4; k++) {
						if (RangeCheck(i, j, k)) {
							count++;
							if (arr[i + delta[k][0]][j + delta[k][1]] == -1) {
								minusCount++;
							}
						}
					}
					if (count == minusCount) {
						possibleCheck = false;
						break start;
					}
				}
			}
		}

		if (!possibleCheck) {
			System.out.println(-1);
			return;
		}

		// ----------------------------------BFS
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					int[] temp = { i, j, 0 };
					q.add(temp);
				}
			}
		}

		int answer = 0;
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int r = poll[0];
			int c = poll[1];
			int day = poll[2];
			answer = Math.max(answer, day);
			for (int i = 0; i < 4; i++) {
				if (RangeCheck(r, c, i) && arr[r + delta[i][0]][c + delta[i][1]] == 0) {
					arr[r + delta[i][0]][c + delta[i][1]] = 1;
					int[] temp = { r + delta[i][0], c + delta[i][1], day + 1 };
					q.add(temp);
				}
			}
		}

		for (int i = 0; i < N; i++) {// 토마토증식이 끝났는데 익지않은게 있다면 -1 출력
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean RangeCheck(int r, int c, int i) {
		if (0 <= r + delta[i][0] && r + delta[i][0] < N && 0 <= c + delta[i][1] && c + delta[i][1] < M)// 배열 범위 내라면
			return true;
		return false;
	}
}
