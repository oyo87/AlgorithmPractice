import java.util.Scanner;

//설계
//10개의 0~10000 정수 입력받아 최대수 구하기
// 그냥 입력받고 하나씩 직접 탐색하기. 정렬필요X
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] arr = new int[10]; // 10개의 수가 주어짐

		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < arr.length; i++)
				arr[i] = sc.nextInt();
			int max = 0;
			for (int i = 0; i < arr.length; i++) {
				if (max < arr[i])
					max = arr[i];
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
