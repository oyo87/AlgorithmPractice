import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 수의 개수 N : 1~1,000,000
		 * 
		 * 나누어 떨어져야 하는 값 M : 2~1,000
		 * 
		 * 수의 값 : 0~1,000,000,000
		 * 
		 * long
		 * 
		 * M으로 나눈 나머지 누적합 활용한 수학적 접근방법을 참고했다.
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long[] sum = new long[N + 1];// M으로 나눈 나머지 누적합
		long[] mod = new long[M];// 남은 나머지 개수
		long answer = 0;

		for (int i = 1; i < N + 1; i++) {
			sum[i] += arr[i - 1] + sum[i - 1];
			sum[i] %= M;

			if (sum[i] == 0)
				answer++;

			mod[(int) sum[i]]++;
		}

		for (int i = 0; i < M; i++) {
			if (1 < mod[i]) {
				answer += (mod[i] * (mod[i] - 1) / 2);
			}
		}

		System.out.print(answer);

	}
}