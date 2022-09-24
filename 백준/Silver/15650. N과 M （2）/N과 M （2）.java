import java.util.Scanner;

//1부터 N까지의 중복없는 M개수열
public class Main {
	static int N;
	static int M;
	static boolean[] visit;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N];
		Recursion(0, 0);
		System.out.println(sb);
	}

	static void Recursion(int idx, int sidx) {
		if (sidx == M) {
			for (int i = 0; i < N; i++) {
				if (visit[i])
					sb.append(i + 1).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < N; i++) {
			if(!visit[i]) {
				visit[i]=true;
				Recursion(i, sidx+1);
				visit[i]=false;
			}
		}
	}
}
