import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//위상정렬 문제
public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 학생수
		int M = sc.nextInt();// 비교회수
		int[] indegree = new int[N + 1];// 진입차수 A보다 작은 학생 수
		ArrayList<Integer>[] list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			indegree[b]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			System.out.print(queue.peek() + " ");
			int tempPoll = queue.poll();
			for (int i = 0; i < list[tempPoll].size(); i++) {
				int next = list[tempPoll].get(i);
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}

	}

}
