import java.util.Scanner;

//설계
//1차원 배열 돌면서 중복 생각없이 가장큰값 -1 가장작은값 +1을 주어진 덤프횟수만큼 수행
//가장큰값과 가작 작은값의 차이를 구함

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		int arr[] = new int[100];

		for (int tc = 1; tc <= T; tc++) {
			int dump = sc.nextInt();

			for (int i = 0; i < 100; i++)// 길이 받기
				arr[i] = sc.nextInt();

			for (int i = 0; i < dump; i++) {// dump횟수만큼 작업
				int maxIdx = 0;
				int minIdx = 0;
				for (int j = 0; j < arr.length - 1; j++) {// max값 min값 구해서 -1 +1
					if (arr[maxIdx] < arr[j + 1])
						maxIdx = j + 1;
					if (arr[j + 1] < arr[minIdx])
						minIdx = j + 1;
				}
				arr[maxIdx]--;
				arr[minIdx]++;
			}
			int maxIdx = 0;
			int minIdx = 0;
			for (int i = 0; i < arr.length - 1; i++) {// dump가 이루어진 후최종 max값과 min값 구하기
				if (arr[maxIdx] < arr[i + 1])
					maxIdx = i + 1;
				if (arr[i + 1] < arr[minIdx])
					minIdx = i + 1;
			}
			System.out.printf("#%d %d\n", tc, arr[maxIdx] - arr[minIdx]);// max -min
		}
	}
}
