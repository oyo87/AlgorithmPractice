
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < N*2; i++) {
			sum += Math.abs(sc.nextInt());
		}
		System.out.println(sum);
		
	}
}
