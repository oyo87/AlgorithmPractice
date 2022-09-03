import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> deque = new LinkedList<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int target = 0;// 제거할숫자
		int count = 0;// 이동횟수

		for (int i = 1; i <= N; i++)
			deque.addLast(i);// 1부터 N까지의 자연수

		for (int i = 0; i < M; i++) {
			target = sc.nextInt();
			int targetIndex = deque.indexOf(target);
			if (targetIndex <= deque.size() / 2)// 중간기준왼쪽에 더가까우면 2번연산
				while (deque.peek() != target) {
					deque.addLast(deque.pollFirst());
					count++;
				}
			else
				while (deque.peek() != target) {// 중간기준오른쪽에 더 가까우면 3번연산
					deque.addFirst(deque.pollLast());
					count++;
				}
			deque.pop();// target값 제거

		}
		System.out.println(count);

	}
}
