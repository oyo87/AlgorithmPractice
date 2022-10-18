import java.util.Scanner;

//입력때부터 바로 누적합을 만들어준다

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();// 수의개수
		int M = sc.nextInt();// 합을 구해야하는횟수

		int[] sum = new int[N + 1];// 누적합
		sum[0] = 0;
		for (int i = 1; i < N + 1; i++) {
			sum[i] = sum[i - 1] + sc.nextInt();
		}
		for (int i = 0; i < M; i++) {// start부터 end까지의 구간하븐 end까지의 구간합 - start-1까지의 구간합
			int start = sc.nextInt();
			int end = sc.nextInt();

			sb.append(sum[end] - sum[start - 1]).append("\n");
		}
		System.out.println(sb);

	}
}
