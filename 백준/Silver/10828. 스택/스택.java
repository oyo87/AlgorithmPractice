import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		Stack<Integer> arr = new Stack<>();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			if (str.equals("push")) {
				arr.push(sc.nextInt());
			} else if (str.equals("pop")) {
				if (arr.size() != 0)
					sb.append(arr.pop()).append("\n");
				else
					sb.append("-1\n");
			} else if (str.equals("size")) {
				sb.append(arr.size()).append("\n");
			} else if (str.equals("empty")) {
				if (arr.empty())
					sb.append("1\n");
				else
					sb.append("0\n");

			} else if (str.equals("top")) {
				if (arr.size() != 0)
					sb.append(arr.lastElement()).append("\n");
				else
					sb.append("-1\n");
			}

		}
		System.out.println(sb);
	}
}
