import java.util.Arrays;
import java.util.Scanner;

//이분탐색
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean succes;
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		int[] num = new int[M];// 찾을 숫자
		for (int i = 0; i < M; i++) {
			num[i] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			int start = 0;
			int end = N - 1;
			succes = false;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (num[i] < arr[mid]) {
					end = mid - 1;
				} else if (arr[mid] < num[i])
					start = mid + 1;
				else {// 찾은경우
					succes = true;
					break;
				}

			}
			if (succes)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		System.out.println(sb);
	}
}
