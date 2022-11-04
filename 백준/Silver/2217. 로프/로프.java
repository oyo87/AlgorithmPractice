import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//들어올릴수있는 물체의 최대중량구하기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];// 버틸수있는 로프 무게
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, arr[i] * (N - i));
		}
		System.out.println(answer);

	}
}
