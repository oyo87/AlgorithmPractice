import java.util.Scanner;

//설계
//100X100짜리 사다리를 타고 도착점2로 시작하는 출발점 X를반환하라
//도착점부터 출발을 해서 올라온다.
//arr[0][c]의 여러군데에 출발점이 있다.
//arr[99][c]의어딘가에 2가 존재한다
//아래에있는 목표값부터 위로 찾아나선다.
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		int size = 100;

		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();// tc번호입력
			int[][] arr = new int[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++)
					arr[i][j] = sc.nextInt();
			} // 배열 값채우기

			int target = 0;// 사다리의 맨 아래 목표
			int start = 0;// 사다리의 첫 시작지점인 맨위
			for (int i = 0; i < size; i++)
				if (arr[size - 1][i] == 2) {// 2라는 요소를 가지고 있는 맨 아래 목표지점 탐색
					target = i;
					break;
				}

			for (int i = size - 2; 0 <= i; i--) {// 99는 이미 target의 자리인 target위치인 한칸 위인 98(size-2)부터 시작
				if (target != 0 && arr[i][target - 1] == 1) {// 왼쪽으로 길이 있다면 왼쪽으로 쭉 이동
					while (target != 0 && arr[i][target - 1] == 1)
						target--;// 인덱스 좌측 이동
				} else if (target != size - 1 && arr[i][target + 1] == 1) {// else if 오른쪽으로 길이 있다면 오른쪽 쭉 이동
					while (target != size - 1 && arr[i][target + 1] == 1)
						target++;// 인덱스 우측 이동
				}
				if (i == 0) {// i가 0이라면 시작지점인 위치이므로 값 저장후 종료
					start = target;
					break;
				}
				// i가 0일때까지 반복 i--(행을 한칸씩위로 이동)
			}
			System.out.printf("#%d %d\n", tc, start);

		}
	}
}
