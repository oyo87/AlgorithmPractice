import java.util.Scanner;

public class Solution {
	static int N;
	static int[] company;
	static int[] home;
	static int[][] client;
	static int min;
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 고객의수
			company = new int[2];
			home = new int[2];
			client = new int[N][2];
			int distance = 0;
			min = Integer.MAX_VALUE;
			visit = new boolean[N];

			company[0] = sc.nextInt();
			company[1] = sc.nextInt();
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();
			for (int i = 0; i < N; i++) {
				client[i][0] = sc.nextInt();
				client[i][1] = sc.nextInt();
			}
			Recursion(0, company[0], company[1], distance);
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.println(sb);
	}

	static void Recursion(int depth, int x, int y, int distance) {// x, y는 현재 나의 위치
		if (min < distance) // 볼필요도 없다.
			return;
		if (depth == N) {
			distance += Math.abs(x - home[0]) + Math.abs(y - home[1]);
			min = Math.min(min, distance);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				int temp = distance + Math.abs(x - client[i][0]) + Math.abs(y - client[i][1]);
				Recursion(depth + 1, client[i][0], client[i][1], temp);
				visit[i] = false;
			}
		}

	}
}
