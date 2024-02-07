import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 숫자 A<B의 크기 : 1~ 1,000,000,000
		 * 
		 * 2를 곱하거나, 우측끝에 1을 추가하거나 해서 A를 B로 바꾸는데 필요한 연산 +1출력 불가능하면 -1
		 * 
		 * Queue 완탐으로 진행
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		Queue<Long[]> q = new LinkedList<>();
		long answer = -1;
		q.add(new Long[] { A, 1L });

		while (!q.isEmpty()) {
			Long[] poll = q.poll();
			long num = poll[0];
			long depth = poll[1];

			if (num == B) {
				answer = depth;
				break;
			}

			if (B < num)
				continue;

			q.add(new Long[] { num * 2, depth + 1 });
			q.add(new Long[] { num * 10 + 1, depth + 1 });
		}

		System.out.print(answer);

	}
}