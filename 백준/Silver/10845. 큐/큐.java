import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//큐를 이용하여 구현해보자
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();

		int N = sc.nextInt();
		int last = 0;// back에 사용할 last

		for (int i = 0; i < N; i++) {
			String cmd = sc.next();
			if (cmd.equals("push")) {
				que.add(last = sc.nextInt());// 마지막에 들어간 값을 last에 담아두고 back 명령어를 쓸때 사용

			} else if (cmd.equals("pop")) {
				if (que.isEmpty())
					sb.append("-1\n");
				else
					sb.append(que.remove() + "\n");

			} else if (cmd.equals("size")) {
				sb.append(que.size() + "\n");

			} else if (cmd.equals("empty")) {
				if (que.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (cmd.equals("front")) {
				if (que.isEmpty())
					sb.append("-1\n");
				else
					sb.append(que.peek() + "\n");
			} else if (cmd.equals("back")) {
				if (que.isEmpty())
					sb.append("-1\n");
				else
					sb.append(last + "\n");
			}

		}
		System.out.println(sb);
	}
}
