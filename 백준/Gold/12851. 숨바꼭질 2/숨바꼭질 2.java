import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 수빈이의 위치 N : 0~100,000
		 * 
		 * 동생의 위치 K : 0~100,000
		 * 
		 * 1초후 -1, +1 중 이동, 순간이동은 현재위치의 2배로 이동
		 * 
		 * 동생을 찾을 수 있는 가장 빠른 시간은 몇초이지, 몇가지인지 구하기
		 * 
		 * bfs활용, visited로 방문했던 저장
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer[]> q = new LinkedList<>();

		int answerTime = Math.abs(N - K);
		int answerCount = 0;
		q.add(new Integer[] { N, 0 });

		boolean[] visited = new boolean[200001];
		visited[N] = true;
		while (!q.isEmpty()) {
			Integer[] poll = q.poll();
			int pos = poll[0];
			int time = poll[1];

			if (answerTime < time)
				continue;

			if (pos == K) {
				answerTime = time;
				answerCount++;
				continue;
			}

			visited[pos] = true;

			if (0 < pos - 1 && !visited[pos - 1]) {
				q.add(new Integer[] { pos - 1, time + 1 });
			}

			if (pos + 1 < 200001 && !visited[pos + 1]) {
				q.add(new Integer[] { pos + 1, time + 1 });
			}
			if (pos * 2 < 200001 && !visited[pos * 2]) {
				q.add(new Integer[] { pos * 2, time + 1 });
			}
		}

		System.out.println(answerTime);

		if (answerCount == 0)
			answerCount++;
		System.out.print(answerCount);

	}
}