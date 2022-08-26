import java.util.Scanner;

//범위는 안벗어나게 주어질것같다.
public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[100][100];

		for (int i = 0; i < N; i++) {
			int w = sc.nextInt();
			int h = sc.nextInt();

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					arr[j + w][k + h] = 1;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1)
					sum++;
			}
		}
		System.out.println(sum);
	}
}
