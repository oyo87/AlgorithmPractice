import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//절대값으로 차이를 구한뒤 최대 공약수를 구한다.

public class Main {
	static int gcd(int num1, int num2) {
		if (num2 == 0)
			return num1;
		return gcd(num2, num1 % num2);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Math.abs(S - Integer.parseInt(st.nextToken()));// 나의 위치와 동생 위치 절대값을 당마둠
		}
		int result = arr[0];
		for (int i = 1; i < N; i++) {
			result = gcd(result, arr[i]);
		}

		System.out.println(result);
	}
}
