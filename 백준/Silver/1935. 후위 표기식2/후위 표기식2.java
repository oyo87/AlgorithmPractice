import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//첫째줄에 알파뱃 몇개의 형태가 들어올지 입력받고 대문자알파뱃과 연산자가포함된 문자열이 주어진다.
//그 아래는 알파뱃과 매칭되는 숫자들이 들어온다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		double[] arr = new double[N];// A,B,C... 에 대한 숫자를 담아둘공간
		Stack<Double> stack = new Stack<>();
		double temp1;// 연산자 만났을때 계산에 쓸 temp
		double temp2;

		for (int i = 0; i < N; i++) {// A,B,C... 순서대로 해당되는 숫자값
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < str.length(); i++) {
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {// 알파뱃은 arr에 담아둔대로 매칭하여 숫자화하여 스택에 push
				stack.push(arr[(str.charAt(i) - 'A')]);
			} else if (str.charAt(i) == '+') {
				temp2 = stack.pop();
				temp1 = stack.pop();
				stack.push(temp1 + temp2);
			} else if (str.charAt(i) == '-') {
				temp2 = stack.pop();
				temp1 = stack.pop();
				stack.push(temp1 - temp2);

			} else if (str.charAt(i) == '*') {
				temp2 = stack.pop();
				temp1 = stack.pop();
				stack.push(temp1 * temp2);

			} else if (str.charAt(i) == '/') {
				temp2 = stack.pop();
				temp1 = stack.pop();
				stack.push(temp1 / temp2);
			}

		}
		bw.write(String.format("%.2f", stack.pop()));
		bw.flush();
		bw.close();

	}
}
