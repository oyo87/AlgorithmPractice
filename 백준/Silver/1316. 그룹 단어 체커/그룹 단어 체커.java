import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = N;

		for (int i = 0; i < N; i++) {

			String str = sc.next();
			boolean[] alpha = new boolean[26];
			for (int j = 0; j < str.length(); j++) {
				if (0 < j && str.charAt(j) == str.charAt(j - 1)) {
					continue;
				}
				if (alpha[str.charAt(j) - 'a'] == false) {
					alpha[str.charAt(j) - 'a'] = true;
				} else {
					count--;
					break;
				}

			}

		}
		System.out.println(count);
	}
}
