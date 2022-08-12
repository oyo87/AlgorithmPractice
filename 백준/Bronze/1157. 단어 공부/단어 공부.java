import java.util.Scanner;

//입력은 알파뱃 대소문자로만 들어온다.
public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] alpha = new int[26];
		String str = sc.next();
		char[] ch = str.toCharArray();
		int max = 0;
		int maxIdx = 0;
		int count = 0;
		for (int i = 0; i < ch.length; i++) {
			if ('a' <= ch[i] && ch[i] <= 'z')
				alpha[ch[i] - 'a']++;
			else
				alpha[ch[i] - 'A']++;
		}

		for (int i = 0; i < alpha.length; i++) {
			if (max < alpha[i]) {
				max = alpha[i];
				maxIdx = i;
			}
		}
		for (int i = 0; i < alpha.length; i++) {
			if (max == alpha[i])
				count++;
		}
		if (1 < count) {
			System.out.println("?");
			return;
		}
		System.out.printf("%c", maxIdx + 'A');

	}
}
