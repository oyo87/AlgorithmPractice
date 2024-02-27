import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 노드의 개수 N : 2~1,000
		 * 
		 * 거리를 알고싶은 노드쌍 M : 1~1,000
		 * 
		 * 두 점과의 거리는 1~10,000
		 * 
		 * N+1개의 ArrayList생성해서 노드 연결후
		 * 
		 * bfs탐색하며 거리 계산하기
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer[]>[] list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			list[a].add(new Integer[] { b, dist });
			list[b].add(new Integer[] { a, dist });
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[N + 1];

			Queue<Integer[]> q = new LinkedList<>();
			visited[start] = true;
			q.add(new Integer[] { start, 0 });
			// bfs
			while (!q.isEmpty()) {
				Integer[] poll = q.poll();

				int now = poll[0];
				int dist = poll[1];

				if (now == end) {
					sb.append(dist).append("\n");
				}

				for (int j = 0; j < list[now].size(); j++) {
					int next = list[now].get(j)[0];
					if (!visited[next]) {
						q.add(new Integer[] { next, dist + list[now].get(j)[1] });
						visited[next] = true;
					}
				}

			}
		}

		System.out.println(sb);

	}
}