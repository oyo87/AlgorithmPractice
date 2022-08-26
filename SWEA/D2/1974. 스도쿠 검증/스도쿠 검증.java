import java.util.Scanner;

//스도쿠 만족하면 1출력하고 만족하지않으면 0출력
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[][] arr = new int[9][9];
			boolean flag = true;// 스도쿠가 아니라면 false로 바꿔줌
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			a: for (int i = 0; i < 9; i++) {// 가로 세로 한번에 탐색
				boolean[] check = new boolean[10];// 0번인덱스 사용 안함 가로탐색
				boolean[] check2 = new boolean[10];// 0번인덱스 사용 안함 세로탐색
				for (int j = 0; j < 9; j++) {
					if (check[arr[i][j]] == false)
						check[arr[i][j]] = true;
					else {
						flag = false;
						break a;
					}
					if (check2[arr[j][i]] == false)
						check2[arr[j][i]] = true;
					else {
						flag = false;
						break a;
					}
				}
			}
			a: for (int k = 0; k < 9; k += 3) {
				for (int l = 0; l < 9; l += 3) {
					boolean[] check3 = new boolean[10];// 작은 네모안 탐색
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (check3[arr[k + i][l + j]] == false) {
								check3[arr[k + i][l + j]] = true;
							} else {
								flag = false;
								break a;
							}
						}
					}
				}
			}
			System.out.print("#" + tc + " ");
			if (flag)
				System.out.println(1);
			else
				System.out.println(0);

		} // tc 끝
	}
}
