import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			String temp = Integer.toString(i);
			int count = 0;
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
					count++;
				}
			}
			if (count == 0)
				System.out.print(i);
			else {
				for (int j = 0; j < count; j++)
					System.out.print("-");
			}
			if(i!=N)
				System.out.print(" ");
		}
	}
}
