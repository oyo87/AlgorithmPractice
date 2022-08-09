import java.util.Scanner;

//설계
//인풋 받고 최빈수 구하기 최빈수가 동일할경우 더 큰값을 출력
//비어있는 최빈수 배열을 만들고 값 나올때마다 증가
//최빈수 배열을 정렬후 최대값 인덱스 반환
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] arr = new int[1000];
		for (int tc = 1; tc <= T; tc++) {
			int[] fre = new int[101];// 0부터 100점
			sc.nextInt();// 몇번째인지 수동으로 입력해주어야함(문제가 특이하다)
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();// 값 넣어주기
			}
			for (int i = 0; i < arr.length; i++)
				fre[arr[i]] += 1;// arr안에있는 값(0부터 100점)의 fre인덱스 상승(빈도 체크)
			int max = 0;
			for (int i = 0; i < fre.length; i++) {// 빈도 처음부터 돌면서 가장 큰것을 max에 담아줌(겹치면 뒤의것으로)
				if (fre[max] <= fre[i])
					max = i;
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
