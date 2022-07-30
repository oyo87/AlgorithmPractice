import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int NUM = 8;
		int[] scale = new int[NUM];

		for (int i = 0; i < NUM; i++) {
			scale[i] = sc.nextInt();
		}
		int ascending = 0;
		int descending = 0;
		for (int i = 0; i < NUM; i++) {
			if (scale[i] == i + 1)
				ascending++;
			else if (scale[i] == NUM - i)
				descending++;
		}
		if (ascending == NUM) {
			System.out.print("ascending");
		} else if (descending == NUM)
			System.out.print("descending");
		else
			System.out.println("mixed");

	}
}
