import java.util.Scanner;

//설계
//100X100 이차원배열의 행의합, 열의합, 대각선의 합중 최대값 구하기
//행, 열, 대각선 3가지 케이스로 나눠서 반복문으로 최대값 구한다.
public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int size = 100;
		int[][] arr = new int[size][size];

		for (int tc = 1; tc <= 10; tc++) {
			int max = 0;
			sc.nextInt();// 몇번째 tc인지 입력
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++)
					arr[i][j] = sc.nextInt();
			} // 100X100생성

			for (int i = 0; i < size; i++) {
				int rsum = 0;
				int csum = 0;
				for (int j = 0; j < size; j++) {
					rsum += arr[i][j];
					csum += arr[j][i];
				}
				if (max < rsum || max < csum)
					max = Math.max(rsum, csum);
			} // 행열 합을 rsum, csum에 담고 큰값을 max로

			int rdsum = 0;// right down
			int j = 0;
			for (int i = 0; i < size; i++)
				rdsum += arr[i][j++];

			j--;// 100->99
			int ldsum = 0; // left down
			for (int i = size - 1; 0 <= i; i--)
				ldsum += arr[i][j--];
			
			max = Math.max(max, Math.max(rdsum, ldsum));

			System.out.printf("#%d %d\n", tc, max);
		} // tc for문 끝
	}
}
