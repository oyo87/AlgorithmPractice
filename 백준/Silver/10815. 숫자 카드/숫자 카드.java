import java.util.Arrays;
import java.util.Scanner;

// 이분탐색
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();

			int start = 0;
			int mid = 0;
			int end = N - 1;
			boolean flag = false;
			while (start <= end) {
				mid = (start + end) / 2;
				if (num < arr[mid])
					end = mid - 1;
				else if (arr[mid] < num)
					start = mid + 1;
				else {
					sb.append("1");
					flag = true;
					break;
				}
			}

			if (flag == false)
				sb.append("0");

			if (i != M - 1)
				sb.append(" ");
		}
		System.out.println(sb);
	}
}
