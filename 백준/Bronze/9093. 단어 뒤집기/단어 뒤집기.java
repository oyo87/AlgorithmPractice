import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			String a = sc.nextLine();
			Stack<Character> ch = new Stack<>();
			for (int i = 0; i <= a.length(); i++) {
				if (i != a.length() && a.charAt(i) != ' ')
					ch.push(a.charAt(i));
				else {
					while (!ch.isEmpty()) {
						sb.append(ch.pop());
					}
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
