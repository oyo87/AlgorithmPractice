import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int A, B, C;
	static boolean[][] visited;
	static Queue<Integer[]> q;

	public static void main(String[] args) throws IOException {
		/*
		 * 각 그룹에있는 돌의 개수 A,B,C : 1~500
		 * 
		 * 모든그룹의 돌의 개수를 같게 만들기
		 *
		 * AB연산 AC연산 BC연산
		 * 
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visited = new boolean[1501][1501];

		q = new LinkedList<>();
		q.add(new Integer[] { A, B, C });
		int sum = A + B + C;

		if (sum % 3 != 0) {
			System.out.print(0);
			return;
		}

		boolean success = false;
		while (!q.isEmpty()) {
			Integer[] poll = q.poll();
			int a = poll[0];
			int b = poll[1];
			int c = poll[2];

			if (a == b && b == c) {
				success = true;
				break;
			}

			if (a != b) {
				process(a, b, c);
			}
			if (a != c) {
				process(a, c, b);
			}
			if (b != c) {
				process(b, c, a);
			}

		}

		if (success)
			System.out.print(1);
		else
			System.out.print(0);

	}

	static void process(int a, int b, int num) {// 비교할 두개 a,b, 비교하지않는 숫자 num

		int small = Math.min(a, b);
		int big = Math.max(a, b);

		big -= small;
		small += small;

		if (!visited[small][big]) {
			q.add(new Integer[] { small, big, num });
			visited[small][big] = true;
		}

	}
}