import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();

		char[] AA = new char[3];
		char[] BB = new char[3];
		int j = 2;
		for (int i = 0; i < 3; i++) {
			AA[i] = A.charAt(j);
			BB[i] = B.charAt(j);
			j--;
		}

		for (int i = 0; i < 3; i++) {
			if (BB[i] < AA[i]) {
				System.out.println(AA);
				break;
			} else if (AA[i] < BB[i]) {
				System.out.println(BB);
				break;
			}
		}

	}
}
