import java.util.Scanner;

//가로탐색 세로탐색 우하향탐색 좌하향탐색
public class Solution {
	static boolean flag;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			flag = false;
			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			} // 입력값 받기끝

			exit: for (int exit = 0; exit < 1; exit++) {// 딱한번만 돌린다.라벨링 탈출을 위한 반복문. true가되면 즉시 탈출한다. 아무것도없으면 한번 돌고 끝

				for (int i = 0; i < N; i++) {// 가로탐색
					for (int j = 0; j <= N - 5; j++) {
						count = 0;
						for (int k = 0; k < 5; k++) {
							if (arr[i][j + k] == 'o') {
								count++;
								if (count == 5) {
									flag = true;
									break exit;
								}
							} else// 이어진 돌이 안나오면 다시 카운트 0
								count = 0;
						}
					}
				} // 가로탐색 끝

				for (int i = 0; i <= N - 5; i++) {// 세로탐색시작
					for (int j = 0; j < N; j++) {
						count = 0;
						for (int k = 0; k < 5; k++) {
							if (arr[i + k][j] == 'o') {
								count++;
								if (count == 5) {
									flag = true;
									break exit;
								}
							} else
								count = 0;
						}
					}
				}

				// 우하향 탐색 시작
				for (int i = 0; i <= N - 5; i++) {
					for (int j = 0; j <= N - 5; j++) {
						count = 0;
						for (int k = 0; k < 5; k++) {
							if (arr[i + k][j + k] == 'o') {
								count++;
								if (count == 5) {// 대각선은 else count=0없어도 된다.
									flag = true;
									break exit;
								}
							}
						}
					}
				}

				// 좌하향 탐색 시작
				for (int i = 0; i <= N - 5; i++) {
					for (int j = N - 1; 4 <= j; j--) {
						count = 0;
						for (int k = 0; k < 5; k++) {// 좌하향 x는 +1 y는 -1
							if (arr[i + k][j - k] == 'o') {
								count++;
								if (count == 5) {// 대각선은 else count=0없어도 된다.
									flag = true;
									break exit;
								}
							}
						}
					}
				}
			} // exit for문
			System.out.print("#" + tc + " ");
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
