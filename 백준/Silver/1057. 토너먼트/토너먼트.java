import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int kim = sc.nextInt();
		int lim = sc.nextInt();
		int count = 0;

		while (kim != lim) { // 토너먼트 올라가는 숫자 규칙
			kim = kim / 2 + kim % 2;
			lim = lim / 2 + lim % 2;
			count++;
		}
		System.out.println(count);

	}
}
