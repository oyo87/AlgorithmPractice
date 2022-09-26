import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];

		Recursion(0, 1);
		System.out.println(sb);
	}

	static void Recursion(int depth, int idx) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i <= N; i++) {
			arr[depth] = i;
			Recursion(depth + 1, i);
		}

	}
}
