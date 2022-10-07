import java.util.Scanner;

//해설자료를 참고했다..!
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K;// 1<=K<=10^9
		K = sc.nextInt();
		int i = 2;
		int j = 2;
		int k = 1;
		int l = 1;
		int digit = 1;
		
		while (i < K) {
			i += j * 2;
			j *= 2;
			digit++;
		} // 자릿 수를 파악한다.

		k = i - j;
		l = K - k - 1; 
		int[] arr = new int[digit];
		for (i = digit - 1; i >= 0; i--) {
			if (l == 0 || l % 2 == 0) { 
				arr[i] = 4;
			} else { 
				arr[i] = 7;
			}
			l = l / 2;
		}

		for (i = 0; i < digit; i++) 
			System.out.print(arr[i]);
	}

}