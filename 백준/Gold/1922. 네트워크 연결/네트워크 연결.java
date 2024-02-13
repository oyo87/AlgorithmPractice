import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		/*
		 * 컴퓨터의 수 N : 1~1,000
		 * 
		 * 연결할 수 있는 선의 수 M : 1~100,000
		 * 
		 * 연결 비용 : 1~10,000
		 * 
		 * 연결시 같은 컴퓨터도 주어진다는데 패스하면 될듯하다. 모든 컴퓨터 연결하는 최소비용
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[2] - o2[2];
		});

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (a == b)
				continue;

			pq.add(new Integer[] { a, b, cost });
		}

		parent = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}

		int answer = 0;
		while (!pq.isEmpty()) {
			Integer[] poll = pq.poll();

			int a = poll[0];
			int b = poll[1];
			int cost = poll[2];

			int fa = find(a);
			int fb = find(b);
			if (fa == fb)
				continue;

			// union
			if (fb < fa) {
				int temp = fa;
				fa = fb;
				fb = temp;
			}

			for (int i = 1; i <= N; i++) {
				if (parent[i] == fb) {
					parent[i] = fa;
				}
			}
			answer += cost;

		}
		System.out.print(answer);

	}

	static int find(int num) {
		if (parent[num] == num)
			return num;
		return parent[num] = find(parent[num]);
	}
}