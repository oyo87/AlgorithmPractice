import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 시간만큼의 배열 만들어서 다 계산하려하니 메모리 초과 발생
// 우선순위 큐를 사용
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Integer[][] info = new Integer[N][3];// 강의번호, 시작시간, 종료시간
		ArrayList<Integer[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			info[i][0] = sc.nextInt();
			info[i][1] = sc.nextInt();
			info[i][2] = sc.nextInt();
			list.add(info[i]);
		}
		Collections.sort(list, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if (o1[1] == o2[1]) // 시작시간이 같으면 종료시작을 빠르게
					return o1[2] - o2[2];
				return o1[1] - o2[1];// 시작시간순 정렬
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int answer = 1;
		for (int i = 0; i < N; i++) {
			while (!pq.isEmpty() && pq.peek() <= list.get(i)[1])
				pq.poll();
			
			pq.add(list.get(i)[2]);
			answer = Math.max(answer, pq.size());
		}
		System.out.println(answer);
	}
}