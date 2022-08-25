import java.util.Scanner;

//카드 개수 세는 배열 만들어서 경우의수를 모두 계산해서 어느게 가장 많이 나왔는지 알아본다.
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 1부터 N번카드
			int M = sc.nextInt();// 1부터 M번카드

			int[] count = new int[N + M];
			int max = 0;
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < M; j++) {
					count[i + j]++;
					max = Math.max(max, count[i + j]);
				}
			}
			int[] result = new int[N + M];
			int j = 0;
			for (int i = 0; i < count.length; i++) {//나중에 생각해보니 굳이 안만들고 한번에 출력할 수도 있다!
				if (count[i] == max) {
					result[j++] = i + 1;// 인덱스가 0부터시작하는데 실제 값은 1부터 시작을하니까 +1을 해준다.
				}
			}

			System.out.print("#" + tc);
			for (int i = 0; i < result.length; i++) {
				if (result[i] != 0) {
					System.out.print(" " + result[i]);
				}
			}
			System.out.println();
		}
	}
}
