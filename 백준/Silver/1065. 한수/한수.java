import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int hundred = 0;
		int ten = 0;
		int one = 0;
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (i < 100) {
				count++;
			} else {
				int temp = i;
				hundred = temp / 100;
				temp %= 100;
				ten = temp / 10;
				temp %= 10;
				one = temp;

				if (hundred - ten == ten - one)
					count++;
			}

		}
		System.out.println(count);
	}
}
