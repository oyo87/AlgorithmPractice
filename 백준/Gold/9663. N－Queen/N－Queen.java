import java.util.Scanner;

public class Main {

	static int N;
	static boolean[][] chessBoard;
	static int possible;

	public static boolean putPossible(int row, int col) {//좌상,우상,위 쪽에 퀸이 이미 존재하면 불가능
		int dia = 1;// diagonal 대각선

		for (int i = row - 1; 0 <= i; i--) {
			if (0 <= col - dia && chessBoard[i][col - dia]) {// 좌상향
				return false;
			}
			if (col + dia < N && chessBoard[i][col + dia]) {// 우상향
				return false;
			}
			if (chessBoard[i][col]) {
				return false;
			}
			dia++;
		}
		return true;
	}

	public static void putQueen(int row) {
		if (row == N) {
			possible++;
			return;
		}
		for (int col = 0; col < N; col++) {
			if (putPossible(row, col)) {
				chessBoard[row][col] = true;
				putQueen(row + 1);
				chessBoard[row][col] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		chessBoard = new boolean[N][N];
		putQueen(0);
		System.out.println(possible);

	}

}
