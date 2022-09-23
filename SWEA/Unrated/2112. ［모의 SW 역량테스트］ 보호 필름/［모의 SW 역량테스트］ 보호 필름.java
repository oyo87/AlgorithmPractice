import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int D;
	static int W;
	static int K;
	static int medicineCount;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(sc.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(sc.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[D][W];
			medicineCount = K;
			visit = new boolean[D];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(sc.readLine(), " ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (possibleLine(arr) == W)
				sb.append("#").append(tc).append(" ").append(0).append("\n");
			else {
				Recursion(0, 0, arr);
				sb.append("#").append(tc).append(" ").append(medicineCount).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void Recursion(int idx, int sidx, int[][] arr) {

		if (idx == D) {
			if (possibleLine(arr) == W) {
				medicineCount = Math.min(medicineCount, sidx);
			}
			return;
		}

		if (medicineCount <= sidx)// 지금까지의 최소카운트보다 고른게 많다면 더볼필요없이 종료
			return;

		int[] temp = new int[W];

		for (int j = 0; j < W; j++)
			temp[j] = arr[idx][j];
		Recursion(idx + 1, sidx, arr);

		Arrays.fill(arr[idx], 0);
		Recursion(idx + 1, sidx + 1, arr);
		Arrays.fill(arr[idx], 1);
		Recursion(idx + 1, sidx + 1, arr);

		for (int j = 0; j < W; j++) {
			arr[idx][j] = temp[j];
		}

	}

//	static int[][] medicineA(int[][] arr, int index) {
//		for (int i = 0; i < W; i++) {
//			arr[index][i] = 0;
//		}
//		return arr;
//	}
//
//	static int[][] medicineB(int[][] arr, int index) {
//		for (int i = 0; i < W; i++) {
//			arr[index][i] = 1;
//		}
//		return arr;
//	}

	static int possibleLine(int[][] arr) {
		int possible = 0;
		loop:
		for (int i = 0; i < W; i++) {
			int same = 0;
			for (int j = 0; j < D - 1; j++) {
				if (arr[j][i] == arr[j + 1][i])
					same++;
				else
					same = 0;
				
				if (same == K - 1) {
					possible++;
					break;
				}
//				if(j == D-2) {
//					break loop;
//				}
			}
			if(possible != i+1)
				return possible;
		}
		return possible;
	}
}
