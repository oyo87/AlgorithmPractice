import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		if (N < 100) {
			System.out.println(N);
			return;
		}
		int hundred = 0;
		int ten = 0;
		int one = 0;
		int count = 99;
		for (int i = 100; i <= N; i++) {
			int temp = i;
			hundred = temp / 100;
			temp %= 100;
			ten = temp / 10;
			one = temp % 10;

			if (hundred - ten == ten - one)
				count++;
		}

		System.out.println(count);
	}

}
