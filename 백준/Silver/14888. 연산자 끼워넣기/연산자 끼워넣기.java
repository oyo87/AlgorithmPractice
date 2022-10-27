import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//재귀 돌려서 주어진 숫자의 앞에서부터 연산자를 집어넣는다.
public class Main {
	static int N;
	static int[] arr;
	static int max;//max answer
	static int min;//min answer

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 총 N-1개의 기호가 들어온다.
		st = new StringTokenizer(br.readLine());

		int[] cal = new int[4];
		cal[0] = Integer.parseInt(st.nextToken());// '+'
		cal[1] = Integer.parseInt(st.nextToken());// '-'
		cal[2] = Integer.parseInt(st.nextToken());// '*'
		cal[3] = Integer.parseInt(st.nextToken());// '/'

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		Recursion(cal, arr[0], 0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void Recursion(int[] cal, int sum, int depth) {
		if (depth == N - 1) { //종료조건 기호를 모두 다 사용
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (0 < cal[i]) {
				if (i == 0) {
					cal[i]--;
					Recursion(cal, sum + arr[depth + 1], depth + 1);
					cal[i]++;
				} else if (i == 1) {
					cal[i]--;
					Recursion(cal, sum - arr[depth + 1], depth + 1);
					cal[i]++;

				} else if (i == 2) {
					cal[i]--;
					Recursion(cal, sum * arr[depth + 1], depth + 1);
					cal[i]++;
				} else {
					cal[i]--;
					Recursion(cal, sum / arr[depth + 1], depth + 1);
					cal[i]++;
				}
			}
		}
	}
}
