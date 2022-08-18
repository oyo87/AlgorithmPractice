import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//다른 연산자는 없고 +만 들어온다.
//피연산자의 숫자는 0~9까지의 숫자이다.
//그러므로 스택에 토큰을 하나씩 가져오면서 숫자면 출력, +가오면 스택에 push해두고 다음 +가오면 빌때까지 pop을 하고 다시+를 넣어준다.
//이렇게 후위표기를 한 후
//숫자를 만나면 스택에 push, 연산자를 만나면 pop2,pop1을한 후에 pop2+pop1을 한다.
public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10; // 10개를 테스트한다
		for (int tc = 1; tc <= T; tc++) {
			bw.write("#");
			bw.write(String.valueOf(tc));
			bw.write(" ");
			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			int N = Integer.parseInt(br.readLine());// 들어올 문자 개수
			String str = br.readLine();// str의 길이 = N 중위표기식으로 받은 식
			for (int i = 0; i < N; i++) {// 숫자가 들어왔을때
				if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
					sb.append(str.charAt(i));
				} else {// +가올경우
					if (!stack.empty() && stack.peek() == '+') {
						sb.append(stack.pop());
						stack.push(str.charAt(i));
					} else
						stack.push(str.charAt(i));
				}
			}
			if (!stack.empty())// 마지막에 +가 하나 스택에 남아있음
				sb.append(stack.pop());
			String str2 = sb.toString();// 후위표기식이 적용된 str2
			Stack<Integer> stack2 = new Stack<>();
			for (int i = 0; i < str2.length(); i++) {
				if (str2.charAt(i) == '+') {
					int temp2 = stack2.pop();
					int temp1 = stack2.pop();
					stack2.push(temp1 + temp2);
				} else {// 숫자인경우
					int temp = str2.charAt(i) - '0';
					stack2.push(temp);
				}

			}
			bw.write(String.valueOf(stack2.pop()));
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
}
