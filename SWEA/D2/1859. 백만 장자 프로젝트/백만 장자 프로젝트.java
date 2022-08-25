import java.util.Scanner;

//최대값을 구한다
//현재인덱스보다 최대값이 뒤에있으면 최대값에 도달할때까지 계속해서 구매
//최대값에서 모두 판매후 다음인덱스있으면 이동
//다시 현재인덱스보다 최댁밧이 뒤에 있으면 최대값에 도달할때까지 구매-> 판매 반복
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			long benefit = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] < max) {
					benefit += max - arr[i];
				} else if (arr[i] == max) {// 맥스값 다시 탐색
					max = 0;// 최대값 다시 초기화
					if (i != N - 1) {// 마지막 인덱스가 아니라면
						for (int j = i + 1; j < N; j++) {
							if (max < arr[j]) {
								max = arr[j];
							}
						}
					}
				}

			}
			System.out.println("#" + tc + " " + benefit);

		}
	}
}
