import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dp이용
//기준점을 기준으로 왼쪽부터 상승한구간, 오른쪽부터 기준점으로 상향하는구간
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int[] dp1 = new int[N];// 왼쪽부터기준점
		int[] dp2 = new int[N];// 오른쪽부터기준점

		for (int i = 0; i < N; i++) {
			dp1[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
				}
			}
		}

		for (int i = N - 1; 0 <= i; i--) {
			dp2[i] = 1;
			for (int j = N - 1; i < j; j--) {
				if (arr[j] < arr[i]) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp1[i] + dp2[i]);
		}
		System.out.println(answer - 1);// 겹치는거 하나 제거

	}
}
