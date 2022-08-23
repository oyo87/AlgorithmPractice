import java.util.Scanner;

//최대공약수를 활용한다.
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int temp = 0;// 최대공약수
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i < N; i++) {
			int min = Math.min(arr[0], arr[i]);
			for (int j = 1; j <= min; j++) {
				if (arr[0] % j == 0 && arr[i] % j == 0)
					temp = j;// 최대공약수
			}

			System.out.println(arr[0] / temp + "/" + arr[i] / temp);
		}
	}
}
