import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//알파벳 대문자, +-*/() 로만 입력값이 들어온다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {// (면 무조건 푸쉬
				stack.push(str.charAt(i));
			} else if (str.charAt(i) == '+' || str.charAt(i) == '-') {// +-일경우 (일때만 푸쉬
				if (stack.empty() || stack.peek() == '(')
					stack.push(str.charAt(i));
				else {
					while (!stack.empty() && stack.peek() != '(')
						bw.write(stack.pop());
					stack.push(str.charAt(i));
				}

			} else if (str.charAt(i) == '*' || str.charAt(i) == '/') {// */ 일경우 top이 *이나 /가 아닐때 푸쉬
				if (stack.empty() || (stack.peek() != '*' && stack.peek() != '/'))
					stack.push(str.charAt(i));
				else {
					while (!stack.empty() && stack.peek() != '(' && stack.peek() != '+' && stack.peek() != '-')
						bw.write(stack.pop());
					stack.push(str.charAt(i));
				}

			} else if (str.charAt(i) == ')') {
				while (!stack.empty() && stack.peek() != '(')
					bw.write(stack.pop());
				if (stack.peek() == '(')
					stack.pop();
			} else// 알파벳일경우 바로 출력
				bw.write(str.charAt(i));

		} // 중위연산자를 후위연산자로
		while (!stack.isEmpty())
			bw.write(stack.pop());
		bw.flush();
		bw.close();
	}
}
