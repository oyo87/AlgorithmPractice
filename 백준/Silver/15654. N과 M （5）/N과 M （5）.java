import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[] num;
	static int[] answer;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];//입력값 담아둘 배열
		answer = new int[N];//출력할 값을 담아둘 배열
		visited = new boolean[N];
		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();
		Arrays.sort(num);
		Recursion(0);
		System.out.println(sb);
	}

	static void Recursion(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++)
				sb.append(answer[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				answer[depth] = num[i];
				Recursion(depth + 1);
				visited[i] = false;
			}
		}
	}
}
