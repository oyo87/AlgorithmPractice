import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static int[] num;
	static int[] answer;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N];
		num = new int[N];
		answer = new int[M];
		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();
		Arrays.sort(num);
		Recursion(0, 0);
		System.out.println(sb);
	}

	static void Recursion(int depth, int start) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				answer[depth] = num[i];
				Recursion(depth + 1, i);
				visited[i] = false;
			}
		}

	}
}
