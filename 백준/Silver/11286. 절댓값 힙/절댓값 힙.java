import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//priorityQueue 사용
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o2) < Math.abs(o1)) {// 절대값 앞에있는게 더 크면 자리바꿔야함
					return Math.abs(o1) - Math.abs(o2);
				} else if (Math.abs(o1) == Math.abs(o2)) { // 절대값 같으면 음수가 앞
					return o1 - o2;
				} else {
					return -1;
				}
			}
		});
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) { // 0이면 빼주고출력 아무것도없으면 0
				if (pq.isEmpty())
					System.out.println("0");
				else
					System.out.println(pq.poll());
			} else {// 0아니면 넣어주기
				pq.offer(num);
			}
		}
	}
}
