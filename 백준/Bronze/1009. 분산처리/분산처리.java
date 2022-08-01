import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] A = new int[T];
		int[] B = new int[T];
		for (int i = 0; i < T; i++) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		int[] temp = new int[T];
		for (int i = 0; i < T; i++) {
			temp[i] = A[i];
			for (int j = 0; j < B[i] - 1; j++) {
				temp[i] = temp[i] * A[i] % 10;
			}
		}

		for (int i = 0; i < T; i++) {
			if (10 < temp[i])
				temp[i] %= 10;
			if (temp[i] == 0)
				temp[i] = 10;
			System.out.println(temp[i]);
		}
	}
}
