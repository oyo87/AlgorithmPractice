import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//row마다 가장 작은값을 넣으면서 백트래킹을 확인해본다.
public class Main {
	static int[][] answer = new int[9][9];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}

		Recursion(0, 0, arr);//row, col, arr
		return;

	}

	private static void Recursion(int row, int col, int[][] arr) {
		if (col == 9) {//col탐색 끝났으면 0으로 초기화, row한칸증가
			row += 1;
			col = 0;
		}
		if (row == 9) {//row가 9라면 탐색끝났으니(9X9이므로 row,col은 0~8) 출력
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);// 바로 종료
		}

		if (arr[row][col] == 0) {//0이라면 값을 찾아야함
			for (int i = 1; i < 10; i++) {//1부터9까지 작은값부터 넣어가며 진행
				if (sdoku(arr, row, col, i)) {
					arr[row][col] = i;
					Recursion(row, col + 1, arr);
					arr[row][col] = 0;
				}
			}
		} else {
			Recursion(row, col + 1, arr);// 0이아니라면 다음칸으로이동
		}

	}

	private static boolean sdoku(int[][] arr, int row, int col, int data) {// data ==넣을 값
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == data)// 가로탐색
				return false;
			if (arr[i][col] == data)// 세로탐색
				return false;
		}

		// 3X3 박스 탐색
		for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
			for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
				if (arr[i][j] == data)
					return false;
			}
		}
		return true;
	}
}
