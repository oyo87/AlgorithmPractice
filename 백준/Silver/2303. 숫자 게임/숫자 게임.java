import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] num;

	static int[] answer;

	static int max = 0;

	public static void main(String[] args) throws IOException {
		/*
		 * 사람 수 N : 2~1,000
		 * 
		 * 정수 5개중 3개 고르기 5C3 5*4*3 / 3*2 = 10
		 * 
		 * 조합을 사용한 완전탐색 진행하면 될듯하다.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		num = new int[N][5];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = new int[N];

		for (int i = 0; i < N; i++) {
			comb(i, 0, 0, 0);
		}

		for (int i = N - 1; 0 <= i; i--) {
			if (max == answer[i]) {
				System.out.print(i + 1);
				return;
			}
		}

	}

	static void comb(int index, int sum, int select, int depth) {
		if (depth == 3) {
			answer[index] = Math.max(answer[index], sum % 10);
			max = Math.max(max, answer[index]);
			return;
		}

		for (int i = select; i < 5; i++) {
			comb(index, sum + num[index][i], i + 1, depth + 1);
		}
	}
}