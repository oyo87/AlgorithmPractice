import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] num = new int[10];
		for (int i = 0; i < 10; i++)
			num[i] = sc.nextInt();

		for (int i = 0; i < 10; i++)
			num[i] = num[i] % 42;

		Arrays.sort(num);
		int count = 1;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] != num[i + 1]) {
				count++;
			}
		}
		System.out.println(count);
	}
}
