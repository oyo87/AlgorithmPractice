import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//스택활용
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			if (str.length() == 1 && str.charAt(0) == '.')// .나오면 종료
				break;
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[')
					stack.push(str.charAt(i));
				else if (str.charAt(i) == ')') {
					if (!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else {
						sb.append("no").append("\n");
						break;
					}
				} else if (str.charAt(i) == ']') {
					if (!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					else {
						sb.append("no").append("\n");
						break;
					}

				}
				if (i == str.length() - 1)
					if (stack.isEmpty())
						sb.append("yes").append("\n");// 인덱스 마지막이고 스택 비어있으면 괄호 모두 소모한것
					else
						sb.append("no").append("\n");
			}
		} // true 반복
		System.out.println(sb);
	}
}
