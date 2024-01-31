import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 플레이어의 수 N : 2~100,000 카드에 적힌 정수 : 1~1,000,000 수는 중복되지 않는다.
		 * 
		 * 완탐은 불가능한 케이스
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];// 원본 배열

		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		int[] position = new int[max + 1];
		for (int i = 0; i < N; i++) {
			position[arr[i]] = i + 1;
		}

		int[] answer = new int[N + 1];
		for (int i = 0; i < N; i++) {
			int num = arr[i];
			for (int j = num * 2; j <= max; j += num) {
				if (position[j] != 0) {
					answer[position[j]]--;
					answer[position[num]]++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(answer[i]).append(" ");
		}

		System.out.print(sb);

	}
}