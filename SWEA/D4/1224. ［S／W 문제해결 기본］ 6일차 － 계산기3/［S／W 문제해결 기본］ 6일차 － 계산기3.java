import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//후위표기식으로 바꾸고 계산까지 한다.
public class Solution {

	static boolean Comparision(char stackTop, char str) {// in-coming priority, in-stack priority 비교
		int stackPoint = 0;// (이면 0 isp
		int strPoint = 3;// (이면 3 icp

		if (stackTop == '*' || stackTop == '/')// stackTop 연산자 점수
			stackPoint = 2;
		else if (stackTop == '+' || stackTop == '-')
			stackPoint = 1;

		if (str == '*' || str == '/')// str 연산자 점수
			strPoint = 2;
		else if (str == '+' || str == '-')
			strPoint = 1;

		if (stackPoint < strPoint)
			return true;// 푸쉬가능
		else
			return false;// 팝해야함
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			bw.write("#");
			bw.write(String.valueOf(tc));
			bw.write(" ");

			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < N; i++) {
				if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {// 숫자인경우 바로 출력
					sb.append(str.charAt(i));
				} else// 숫자가 아니고 연산자인경우
				{

					if (str.charAt(i) == ')') {// )일경우 (나올때까지
						while (stack.peek() != '(')
							sb.append(stack.pop());
						stack.pop();// (제거
					} else if (!stack.isEmpty() && Comparision(stack.peek(), str.charAt(i))) {// isp < icp 푸쉬가능
						stack.push(str.charAt(i));
					} else {// icp <= isp 팝해야함
						while (!stack.isEmpty() && Comparision(stack.peek(), str.charAt(i)) == false) {
							sb.append(stack.pop());
						}
						stack.push(str.charAt(i));
					}
				}
			}
			if (!stack.isEmpty())// 연산 하나가 마지막 스택에 남아있다.
				sb.append(stack.pop());
			String str2 = sb.toString();

			Stack<Integer> stack2 = new Stack<>();
			for (int i = 0; i < str2.length(); i++) {
				if ('0' <= str2.charAt(i) && str2.charAt(i) <= '9') {// 숫자인경우
					stack2.push(str2.charAt(i) - '0');
				} else {// 연산자인경우
					int temp2 = stack2.pop();
					int temp1 = stack2.pop();

					switch (str2.charAt(i)) {//해당 연산자에 맞춰서 계산
					case '+':
						stack2.push(temp1 + temp2);
						break;
					case '-':
						stack2.push(temp1 - temp2);
						break;
					case '*':
						stack2.push(temp1 * temp2);
						break;
					case '/':
						stack2.push(temp1 / temp2);
					}

				}
			}
			bw.write(String.valueOf(stack2.pop()));
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
}
