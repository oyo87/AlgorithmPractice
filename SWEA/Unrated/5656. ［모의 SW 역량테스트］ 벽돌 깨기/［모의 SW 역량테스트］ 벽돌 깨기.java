import java.util.Scanner;

public class Solution {
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 상우하좌
	static int N;
	static int W;
	static int H;
	static int answer;
	static int[][] newArr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			answer = Integer.MAX_VALUE;
			int[][] arr = new int[H][W];
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					arr[i][j] = sc.nextInt();

			Recursion(0, arr);
			if(answer == Integer.MAX_VALUE)
				answer=0;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		} // tc end
		System.out.println(sb);
	}

	static void Recursion(int depth, int[][] arr) {
		if (depth == N) {
			int temp = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] != 0)
						temp++;
				}
			}
			answer = Math.min(answer, temp);
			return;
		}
		newArr = new int[H][W];

		for (int i = 0; i < W; i++) {
			for (int k = 0; k < arr.length; k++)
				System.arraycopy(arr[k], 0, newArr[k], 0, arr[k].length);
			for (int j = 0; j < H; j++) {
				if (newArr[j][i] != 0) {
					brickBreak(j, i, newArr[j][i]);// row,col,range(폭파범위)
					comfact();
					Recursion(depth + 1, newArr);
					break;
				}
			}
		}

	}

	static void comfact() {// 아래에서부터 0을 찾아서 그기준으로 위에 0이아닌것이있으면 찾았던 0의 위치로 내려준다.

		for (int i = 0; i < W; i++) {
			for (int j = H - 1; 1 <= j; j--) {
				if (newArr[j][i] == 0) {
					for (int k = j - 1; 0 <= k; k--) {
						if (newArr[k][i] != 0) {
							newArr[j][i] = newArr[k][i];
							newArr[k][i] = 0;
							break;
						}
					}
				}
			}
		}
	}

	static void brickBreak(int row, int col, int range) {
		newArr[row][col] = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < range; j++) {
				if (rangeCheck(row, col, i, j) && newArr[row + delta[i][0] * j][col + delta[i][1] * j] != 0) {// 배열범위안이고
																												// 값이
																												// 0이아닌곳은
					brickBreak(row + delta[i][0] * j, col + delta[i][1] * j,
							newArr[row + delta[i][0] * j][col + delta[i][1] * j]);
				}
			}
		}
	}

	static boolean rangeCheck(int row, int col, int i, int range) {
		if (0 <= row + delta[i][0] * range && row + delta[i][0] * range < H && 0 <= col + delta[i][1] * range
				&& col + delta[i][1] * range < W)
			return true;
		return false;
	}
}
