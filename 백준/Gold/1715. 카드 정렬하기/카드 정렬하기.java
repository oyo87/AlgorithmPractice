import java.util.PriorityQueue;
import java.util.Scanner;

//기본 큐를 사용하려고 했는데 그러면 더한 값이 더 작은데도 불구하고 뒤로 밀리게된다.
//우선순위 큐를 사용헤서 매번 가장 작은값을 더해준다.
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++)
			pq.add(sc.nextInt());

		int answer = 0;
		while (!pq.isEmpty()) {
			int card1 = pq.remove();
			if (pq.isEmpty())// 합치기 끝!
				break;
			answer += card1;
			int card2 = pq.remove();
			answer += card2;
			pq.add(card1 + card2);
		}
		System.out.println(answer);
	}
}
