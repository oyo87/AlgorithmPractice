import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] A = new String[N];
		for (int i = 0; i < N; i++)
			A[i] = sc.next();

		for (int i = 0; i < N; i++) {
			int sum = 0;
			int score = 1;
			for (int j = 0; j < A[i].length(); j++) {
				if (A[i].charAt(j) == 'O') {
					sum += score;
					score++;
				} else
					score = 1;
			}
			System.out.println(sum);
		}
	}

}
