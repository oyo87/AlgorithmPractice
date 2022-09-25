import java.util.Scanner;

//1부터 N까지 자연수중 M개 고르기
//같은수 여러번 골라도 된다.
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
		arr = new int[N];
		Recursion(0);
		System.out.println(sb);

	}

	static void Recursion(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			Recursion(depth + 1);
		}
	}
}
