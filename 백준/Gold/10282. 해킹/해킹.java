import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 테스트케이스 T : 100
		 * 
		 * 컴퓨터개수 n : 1~10,000
		 * 
		 * 의존성개수 d : 1~100,000
		 * 
		 * 감염에걸리는 시간 s : 0~1,000
		 * 
		 * 감연되는 컴퓨터 수 체크, pq로 시간기준으로 정렬 visited 방문처리사용 bfs
		 * 
		 * pq에 넣을때, 뽑았을때 두번다 visited 처리필요
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			List<Integer[]>[] list = new ArrayList[n + 1];
			for (int i = 1; i < n + 1; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				list[b].add(new Integer[] { a, s });
			}

			PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {// 시간 오름차순
				return o1[1] - o2[1];
			});

			boolean[] visited = new boolean[n + 1];
			pq.add(new Integer[] { c, 0 });

			int count = 0;
			int answerTime = 0;
			while (!pq.isEmpty()) {
				Integer[] poll = pq.poll();

				int now = poll[0];
				int second = poll[1];

				if (visited[now])
					continue;

				answerTime = second;

				visited[now] = true;
				count++;

				for (int i = 0; i < list[now].size(); i++) {
					int next = list[now].get(i)[0];
					int nextSecond = list[now].get(i)[1];
					if (!visited[next]) {
						pq.add(new Integer[] { next, second + nextSecond });
					}
				}

			}

			sb.append(count).append(" ").append(answerTime).append("\n");

		}
		System.out.print(sb);

	}
}