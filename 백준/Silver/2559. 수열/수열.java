import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int max = 0;
		int sum = 0;
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		max = sum;
		int j = 0;
		for (int i = K; i < N; i++) {
			sum = sum - arr[j++] + arr[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);

	}
}
