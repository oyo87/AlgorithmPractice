import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//내장 우선순위큐 사용
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());// 내림차순으로변경
		for (int tc = 0; tc < N; tc++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.add(num);
			}

		}
		System.out.println(sb);
	}
}
