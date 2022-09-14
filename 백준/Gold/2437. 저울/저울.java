import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 입력받은 무게를 정렬하고
// 누적합을 계산해 나가며 다음 나오는 숫자가 누적합 +1보다 크다면 누적합+1이 측정할수없는 최소 수가 된다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 1이상 1000이하
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] numArr = new int[N];

		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);

		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (sum + 1 < numArr[i])
				break;
			sum += numArr[i];
		}

		System.out.println(sum + 1);
	}
}
