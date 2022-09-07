import java.util.Scanner;
import java.util.Stack;

//기초 스택 문제.
//최근에 쓴걸 지우니 스택구조로 pop해준다.
//0을 외치면 pop해준다. 자료가 없을때 0을 하지 않는다는 조건이 있다. 비어있는경우 에러 고려안해도됨
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();

		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int num = sc.nextInt();
			if (num != 0)
				stack.push(num);
			else
				stack.pop();
		}
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);

	}
}
