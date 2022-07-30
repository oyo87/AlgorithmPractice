import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 9;
		int[] num = new int[count];
		for (int i = 0; i < count; i++)
			num[i] = sc.nextInt();

		int max = num[0];
		int index = 1;
		for (int i = 1; i <= count; i++) {
			if (max < num[i -1]) {
				max = num[i -1];
				index = i;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}
