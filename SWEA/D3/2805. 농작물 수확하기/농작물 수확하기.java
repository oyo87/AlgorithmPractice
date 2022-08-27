import java.util.Scanner;

//입력을 받을때 총합을 구해두고 포함되지 않는 범위를 총합에서 뺀다.
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int sum = 0;// 총합
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String temp = sc.next();// 12345 이런식으로 한번에 입력이 들어옴
				for (int j = 0; j < N; j++) {
					arr[i][j] = temp.charAt(j) - '0';
					sum += arr[i][j];
				}
			}

			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2 - i; j++) {
					sum -= arr[i][j];// 좌상단
					sum -= arr[N - 1 - i][j];// 좌하단
					sum -= arr[i][N - 1 - j];// 우상단
					sum -= arr[N - 1 - i][N - 1 - j];// 우하단
				}
			}

			System.out.println("#" + tc + " " + sum);
		} // tc반복문
	}
}
