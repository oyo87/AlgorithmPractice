import java.util.Scanner;

//1000이하의 자연수가 N개 들어오고 그중 소수가 몇개인지
//개수가 적으니 시간 크게생각안하고 하나하나 비교해보기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int count = 0;
		a: for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 1)
				continue a;// 1은 예외처리
			for (int j = 2; j < num; j++) {
				for (int k = 2; k < num; k++) {
					if (j * k == num)// 모든 케이스
						continue a;
				}
			}
			count++;
		}
		System.out.println(count);
	}
}
