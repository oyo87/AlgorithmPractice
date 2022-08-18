import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//() {} [] <> 괄호가 주어진다. 짝이 맞는지확인 1이면 유효함 0이면 유효하지않음
//Stack을 이용해보자
//각 모양에 맞는 스택 4개를 활용한다?
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = 10; // 테케 10개 고정
		for (int tc = 1; tc <= T; tc++) {
			Stack<Character> stack1 = new Stack<>();// ()
			Stack<Character> stack2 = new Stack<>();// {}
			Stack<Character> stack3 = new Stack<>();// []
			Stack<Character> stack4 = new Stack<>();// <>
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			bw.write("#");
			bw.write(String.valueOf(tc));
			bw.write(" ");
			boolean flag = false;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(')
					stack1.push(str.charAt(i));
				else if (str.charAt(i) == '{')
					stack2.push(str.charAt(i));
				else if (str.charAt(i) == '[')
					stack3.push(str.charAt(i));
				else if (str.charAt(i) == '<')
					stack4.push(str.charAt(i));
				//이 위까지 여는 괄호가 나오면 push
				//이 아래 닫는 괄호가 나오면 해당하는 괄호의 스택영역에 열린게 있으면 pop 없으면 오류이므로 오류flag를 true로 만들어주고 break
				else if (str.charAt(i) == ')') {
					if (stack1.isEmpty()) {
						flag = true;
						break;
					}
					stack1.pop();
				}

				else if (str.charAt(i) == '}') {
					if (stack2.isEmpty()) {
						flag = true;
						break;
					}
					stack2.pop();
				}

				else if (str.charAt(i) == ']') {
					if (stack3.isEmpty()) {
						flag = true;
						break;
					}
					stack3.pop();
				}

				else if (str.charAt(i) == '>') {
					if (stack4.isEmpty()) {
						flag = true;
						break;
					}
					stack4.pop();
				}

			}
			if (flag == false)
				bw.write(String.valueOf(1));
			else
				bw.write(String.valueOf(0));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}