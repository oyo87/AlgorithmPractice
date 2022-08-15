import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//Stack을 활용한다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();

		String str = br.readLine();
		int i = 0;
		while (i < str.length()) {// <를 만나면 >까지 그대로 출력
			if (str.charAt(i) == '<') {
				while (str.charAt(i) != '>') {// >만나면멈춤
					bw.write(str.charAt(i));
					i++;
				}
				bw.write(str.charAt(i));// >까지 출력후 i++
				i++;
			}

			else if (str.charAt(i) == ' ') {// 공백일경우 공백출력후 증가
				bw.write(" ");
				i++;
			}

			else if (str.charAt(i) != '<' && str.charAt(i) != ' ') {// 일반문자일경우
				for (int j = i; j < str.length() && str.charAt(j) != '<' && str.charAt(j) != ' '; j++)// str이 끝나거나, <나
																										// 공백 만날때까지
																										// 스택에저장후 pop
					stack.push(str.charAt(j));
				while (!stack.isEmpty()) {
					bw.write(stack.pop());
					i++;
				}
			}
		}
		bw.flush();
		bw.close();
	}// main
}
