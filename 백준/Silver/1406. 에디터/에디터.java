import java.util.Scanner;
import java.util.Stack;

//ArrayList를이용하여 구현했는데 시간초과 발생
//LinkedList가 더 적합한것같아 변경후 재시도 여전히 시간초과
//Listiterator를 사용해본다. 값은 잘 나오지만 Scanner를 써서인지 또 시간초과 해결됐다고 가정하고 Stack으로연습
//Stack으로 구현해본다. Stack 2개를 만들어 활용한다.
//또 시간초과 Stringbuilder활용해본다.
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		String str = sc.next();
		int N = sc.nextInt();

		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			stack1.add(str.charAt(i));
		}

		for (int i = 0; i < N; i++) {
			String cmd = sc.next();
			if (cmd.charAt(0) == 'L' && !stack1.empty()) {//커서를 왼쪽으로 한칸 옮기려면 1스택에있는걸 2스택으로 옮김
				stack2.push(stack1.pop());
			}

			else if (cmd.charAt(0) == 'D' && !stack2.empty()) {//커서를 오른쪽으로 한칸 옮기는걸 2스택에있는걸 1스택으로 옮기는걸로
				stack1.push(stack2.pop());
			}

			else if (cmd.charAt(0) == 'B' && !stack1.empty()) {
				stack1.pop();
			}

			else if (cmd.charAt(0) == 'P') {
				char c = sc.next().charAt(0);
				stack1.push(c);
			}

		}
		while (!stack1.empty())//1스택에 있는걸 모두 2스택으로 옮겨준후에 출력한다.
			stack2.push(stack1.pop());
		while (!stack2.empty()) 
			sb.append(stack2.pop());
		System.out.println(sb);

	}
}
