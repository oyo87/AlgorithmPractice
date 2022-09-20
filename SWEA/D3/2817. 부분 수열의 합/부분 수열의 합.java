import java.util.Scanner;

//부분수열의 합이 K와 같은지. 재귀 비트마스킹 등등
public class Solution {

	static int N;
	static int K;
	static int[] arr;
	static boolean[] visit;
	static int count;

	static void Recursion(int n) {
		if (n == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (visit[i]) {// 방문처리한곳들의 합을 구하고
					sum += arr[i];
				}
			}
			if (sum == K) {// 그 합이 K와 같다면 count++
				count++;
			}
		} else {
			visit[n] = true;
			Recursion(n + 1);// 지금있는곳을 방문처리하고 다음탐색
			visit[n] = false;
			Recursion(n + 1);// 지금있는곳 방문처리 안하고 다음탐색
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 1~20 주어질 원소 개수
			K = sc.nextInt(); // 1~1000 만들 합
			count = 0; // K와 같은 부분수열 개수

			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			visit = new boolean[N];
			Recursion(0);

			System.out.println("#" + tc + " " + count);
		}
	}
}
