import java.util.Scanner;

//N * N 행렬 90,180,270도 회전하고 출력
//3차원 배열로 해보자
public class Solution {
	static int N;

	static int[][][] Rotation(int[][][] arr) {//90도씩 회전을 해서 담아준다.
		for (int t = 1; t <= 3; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[t][i][j] = arr[t - 1][N - j - 1][i];
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc);
			N = sc.nextInt();

			int[][][] arr = new int[4][N][N];//처음칸0이 원본 1이 90도 2가 180도 3이 270도를 담아둔다.

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[0][i][j] = sc.nextInt();
				}
			}//원본0에 입력받음

			for (int i = 1; i <= N; i++) {
				arr = Rotation(arr);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= 3; j++) {
					for (int k = 0; k < N; k++) {
						System.out.print(arr[j][i][k]);
					}
					if(j!=3)// 마지막에는 공백 구분을 할 필요가 없다.
						System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
}
