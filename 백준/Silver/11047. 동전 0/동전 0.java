import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int lastIndex = A.length - 1;
		int count = 0;

		for (int i = lastIndex; 0 <= i; i--) {
			while (A[i] <= K) {
				K -= A[i];
				count++;
			}
		}

		System.out.println(count);
		sc.close();

	}

}
