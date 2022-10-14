import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int fiveKg = N / 5;
		boolean flag = false;
		for (int i = fiveKg; 0 <= i; i--) {
			int temp = N - (5 * i);
			if (temp == 0) {
				System.out.println(fiveKg);
				flag = true;
				break;
			}
			if (temp % 3 == 0) {
				System.out.println(i + temp / 3);
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println(-1);
		}
	}
}
