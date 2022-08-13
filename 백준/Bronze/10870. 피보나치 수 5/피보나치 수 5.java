import java.util.Scanner;

//0<=n<=20
//n값 입력받고 n번째 피보나치수 구하기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(fibo(n));
	}

	static int fibo(int n) {

		int sum = 0;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		sum = fibo(n - 1) + fibo(n - 2);

		return sum;
	}
}
