import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//입력값 인원수, 건너뛸 수
//큐 두개 만들어서 보내면서 해결 해보기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		Queue<Integer> q3 = new LinkedList<>();// 죽은 인원 들어온 순으로 담아두기

		int N = sc.nextInt();
		int K = sc.nextInt();
		int count = 1;
		
		for (int i = 1; i <= N; i++)//우선 q1에 1부터N까지 담음
			q1.add(i);

		while (q3.size() != N) {//q3에 N만큼 들어올때까지 반복 q1 혹은 q2는 언제나 비어있는상태(다넘겨주기때문)
			if (q2.isEmpty()) {
				while (!q1.isEmpty()) {// q1에 값이 하나라도 있으면
					if (K - count < q1.size()) {
						for (int i = count; i < K; i++) {
							q2.add(q1.poll());
							count++;
						}
						q3.add(q1.poll());
						count = 1;
					} else {
						while (!q1.isEmpty()) {
							q2.add(q1.poll());
							count++;
						}

					}

				}
			} else {
				while (!q2.isEmpty()) {// q2에 값이 하나라도 있으면
					if (K - count < q2.size()) {
						for (int i = count; i < K; i++) {
							q1.add(q2.poll());
							count++;
						}
						q3.add(q2.poll());
						count = 1;
					} else {
						while (!q2.isEmpty()) {
							q1.add(q2.poll());
							count++;
						}

					}

				}

			}
		}
		System.out.print("<");
		while (!q3.isEmpty()) {
			System.out.print(q3.poll());
			if (!q3.isEmpty())
				System.out.print(", ");
		}
		System.out.print(">");
	}
}
