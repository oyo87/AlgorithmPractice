import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 참가하는 학생수
		int K = sc.nextInt();// 한반 배정가능한 최대 인원수
		int[][] arr = new int[N][2];// 앞에 성별, 뒤에 학년
		
		for (int i = 0; i < N; i++) {
//			int S = sc.nextInt();//0여 1남
//			int Y = sc.nextInt();//1~6 학년
			arr[i][0] = sc.nextInt();// 성별
			arr[i][1] = sc.nextInt();// 학년
		}
		
		int[][] arr2 = new int[2][7];// 성별과 학년이 같으면 count++ 0이아닌 1학년부터시작하니 7로줌
		for (int i = 0; i < N; i++) {
			arr2[arr[i][0]][arr[i][1]]++;
		}
		
		int room = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				if (0 < arr2[i][j] % K)// 방으로 나누어떨어지지않고 나머지가있으면 방 추가
					room++;
				room += arr2[i][j] / K;
			}
		}
		System.out.println(room);

	}
}
