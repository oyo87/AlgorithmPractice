import java.util.Scanner;

//주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.
// 모든 국가를 여행하기 위해 타야 하는 비행기 종류의 최소 개수를 출력한다.
//그럼 결국 국가의수-1만큼 타면 되지 않을까
//문제만 보고 일단 이렇게 해도 될것같아서 제출
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트케이스 수
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();// 국가의 수
			int M = sc.nextInt();// 비행기종류
			for (int i = 0; i < M; i++) {
				sc.next();// a
				sc.next();// b
			}
			System.out.println(N - 1);
		}
	}
}
