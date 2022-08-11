import java.util.Arrays;
import java.util.Scanner;

//설계
//배열에 달팽이에맞는 값을 해당하는 값을 채워주고 배열을 반복문을 통해서 출력하자
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];
			int num = 1;
			int row = 0;
			int col = 0;
			int count = 0;// -> 아래, <-, 위 한바퀴 돌고난후 카운트++ index0,0부터 1,1 2,2 이런식으로 이동하여 한칸씩 증가시킴과 동시에 이전에 사용했던
							// 테두리부분을 하나씩 빼는데에도 사용
			a: for (int i = 0; i < N / 2 + N % 2; i++) {// -> 아래, <-, 위를 한 사이클로잡고 N/2를 반올림한 횟수만큼 돌아야한다

				for (col = count; col < N - count; col++) {
					arr[count][col] = num++;
					if (N * N < num)// num이 N * N보다 커지면 모든 칸을 사용한것이므로 종료
						break a;// 라벨링해둔 외부for반복문 a로 탈출
				} // ->방향으로 채우기

				for (row = count + 1; row < N - count; row++) {
					arr[row][N - count - 1] = num++;
					if (N * N < num)
						break a;
				} // 아래방향으로 채우기

				for (col = count + 1; col < N - count; col++) {
					arr[N - count - 1][N - col - 1] = num++;
					if (N * N < num)
						break a;
				} // <-방향으로 채우기

				for (row = count + 1; row < N - count - 1; row++) {
					arr[N - row - 1][count] = num++;
					if (N * N < num)
						break a;
				} // 위쪽방향으로 채우기
				count++;
			}
			System.out.printf("#%d\n", tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

	}
}
