import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int sum(int[] A, Integer[] B) {
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i] * B[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] A = new int[N];
		Integer[] B = new Integer[N];

		for (int i = 0; i < N * 2; i++) {
			if (i < N)
				A[i] = sc.nextInt();
			else
				B[i - N] = sc.nextInt();
		}
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());

		System.out.println(sum(A, B));
	}
}
