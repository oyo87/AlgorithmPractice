import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			String str = sc.next();

			int count1 = 0;
			int count2 = 0;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(')
					count1++;
				if (str.charAt(i) == ')')
					count2++;
			}
			if (count1 != count2 || (str.charAt(0) == ')' || str.charAt(str.length() - 1) == '(')) {
				System.out.println("NO");
				continue;
			}
			int i = 0;
			int j = 1;
			while (0 < count2 && j < str.length()) {
				if (str.charAt(i) == '(') {
					while (j < str.length() && str.charAt(j) != ')') {
						j++;
					}
					if (str.charAt(j) == ')') {
						count2--;
						j++;
					}
				}
				i++;
				if (j < i)
					j = i + 1;
			}
			if (count2 == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
