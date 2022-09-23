import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N,M주어짐
//1부터 N까지의 자연수중에 중복없이 M개를 고른 수열 출력
//재귀로 풀어보자 N,M 1~8
public class Main {
	static int N;
	static int M;
	static boolean[] visit;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		arr = new int[M];
		Recursion(0);
		System.out.println(sb);
	}

	static void Recursion(int depth) {
		if (depth == M) {
			for (int x : arr) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				Recursion(depth + 1);
				visit[i] = false;
			}

		}

	}
}
