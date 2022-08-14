import java.util.Scanner;
import java.util.Stack;

//첫줄 1<=n<=100000 수, 그후 랜범위만큼랜덤입력
//반복문 1부터 돌면서 push, pop
public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();

		int start = 0;

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();

			if (start < num) {

				for (int j = start + 1; j <= num; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				start = num;
			}

			else if (stack.peek() != num) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb);

	}
}
