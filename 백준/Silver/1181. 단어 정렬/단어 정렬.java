import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int maxLength = 0;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			set.add(temp);
			maxLength = Math.max(maxLength, temp.length());
		}
		String[] arr = set.toArray(new String[0]);// set으로 중복제거후 배열로

		Arrays.sort(arr);

		for (int i = 1; i <= maxLength; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].length() == i)
					System.out.println(arr[j]);
			}
		}
	}
}
