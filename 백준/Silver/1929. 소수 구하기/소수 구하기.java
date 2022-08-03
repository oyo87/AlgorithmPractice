import java.util.Scanner;

public class Main {
	public static boolean Primenumber(int num) {

		if (num < 2)
			return false;
		int i = 2;
		while (i * i <= num)
		{
			if (num % i == 0)
				return false;
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		for (int i = M; i <= N; i++) {
			if (Primenumber(i) == true) {
				System.out.println(i);
			}
		}

	}
}
