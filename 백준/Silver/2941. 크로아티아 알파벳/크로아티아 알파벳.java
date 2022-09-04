import java.util.Scanner;

// 직접 다 탐색해보기
public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int len = str.length();
		String[] arr = { "c=", "c-", "d-", "lj", "nj", "s=", "z=" };

		for (int i = 0; i < str.length() - 2; i++) {
			if ('d' == str.charAt(i) && 'z' == str.charAt(i + 1) && '=' == str.charAt(i + 2)) {
				len -= 2;
				i += 2;
			}
		}

		for (String x : arr) {
			for (int i = 0; i < str.length() - 1; i++) {
				if (x.charAt(0) == str.charAt(i) && x.charAt(1) == str.charAt(i + 1)) {
					if (str.charAt(i) == 'z' && str.charAt(i + 1) == '=') {
						if (0 <= i - 1 && str.charAt(i - 1) == 'd')// dz= 면 z=체크 X
							continue;
					}
					len--;
					i++;
				}
			}
		}

		System.out.println(len);
	}
}
