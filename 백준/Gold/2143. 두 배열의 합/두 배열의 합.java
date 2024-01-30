import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 구해야 하는 수 T : -10억~10억 A배열크기 n : 1~1000 B배열크기 m : 1~1000 각 배열원소는 100만 이하 정수
		 * 
		 * A부배열 + B부배열 합쳐서 T만들기 1001*500 = 약 500,000만 경우의수 두 부배열 100만
		 * 
		 * 두배열의 부배열 만들어두고 부배열 정렬 투포인터로 탐색
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int[] aArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			aArr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] bArr = new int[m];
		for (int i = 0; i < m; i++) {
			bArr[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> aList = new ArrayList<>();
		List<Integer> bList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += aArr[j];
				aList.add(sum);
			}
		}

		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = i; j < m; j++) {
				sum += bArr[j];
				bList.add(sum);
			}
		}

		Collections.sort(aList);
		Collections.sort(bList);

		long answer = 0;
		int left = 0;
		int right = bList.size() - 1;
		while (left < aList.size() && 0 <= right) {
			int sum = aList.get(left) + bList.get(right);

			if (sum == T) {
				int aValue = aList.get(left);
				int bValue = bList.get(right);
				long leftCount = 0;
				long rightCount = 0;

				// 같은값
				while (left < aList.size() && aValue == aList.get(left)) {
					leftCount++;
					left++;
				}
				while (0 <= right && bValue == bList.get(right)) {
					rightCount++;
					right--;
				}
				answer += leftCount * rightCount;
			} else if (sum < T) {
				left++;
			} else {// T < sum
				right--;
			}
		}

		System.out.print(answer);

	}
}