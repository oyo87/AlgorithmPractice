import java.util.Scanner;

// 5*3 크기라면3*3, 없으면 2*2를 찾으면 된다.
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] square = new int[N][M];

		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < M; j++) {
				square[i][j] = temp.charAt(j) - '0';
			}
		} // 배열 채우기

		int max = 1;// 꼭짓점 최대값 기본값은1로 저장해둔다.(아무것도 못찾을시 1)
		int SearchSize = Math.min(N, M);// N,M중 작은값의 정사각형부터 탐색가능
		start: for (int i = SearchSize; 1 < SearchSize; i--) {
			for (int j = 0; j <= N - i; j++) {
				for (int k = 0; k <= M - i; k++) {
					int num = square[j][k];// 좌상단 꼭짓점
					if (num == square[j][k + i - 1] && num == square[j + i - 1][k]
							&& num == square[j + i - 1][k + i - 1]) {//좌상단 꼭짓점과 나머지 세 곳의 꼭짓점이 같으면 break
						max = i;
						break start;
					}

				}
			}
		}
		System.out.println(max * max);
	}
}
