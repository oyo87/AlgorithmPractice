import java.util.Scanner;

//버블정렬, 선택정렬 두개 사용해보기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();// 테스트케이스 개수
		int temp;// swap 용
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// N개의 숫자 주어짐
			int[] arr = new int[N];

			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			// ----------------------- 버블정렬
			for (int i = arr.length - 1; 0 < i; i--) {
				for (int j = 0; j < i; j++) {//처음부터 두개씩 비교해가며 가장큰값들을 마지막에 넣어주며 채워준다.
					if(arr[j+1]<arr[j]) {
						temp = arr[j+1];
						arr[j+1]=arr[j];
						arr[j]=temp;
					}
				}
			}
			// ----------------------- 버블 끝

			// ----------------------- 선택정렬
//			for (int i = 0; i < arr.length - 1; i++) {// 마지막에위치한건 어차피 자동정렬되어있는상태기에 length -1
//				int min = arr[i];
//				int minIndex = 0;
//				for (int j = i + 1; j < arr.length; j++) {// 최소값을 찾아서 앞에서부터 한번씩 채워넣어준다.
//					if (arr[j] < min) {
//						min = arr[j];
//						minIndex = j;
//					}
//				}
//				if (min < arr[i]) {
//					temp = arr[minIndex];
//					arr[minIndex] = arr[i];
//					arr[i] = temp;
//				}
//			}
			// ----------------------- 선택정렬 끝

			System.out.print("#" + tc);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();
		}
	}
}
