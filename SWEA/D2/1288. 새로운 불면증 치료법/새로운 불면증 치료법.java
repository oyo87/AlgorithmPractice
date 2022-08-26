import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int originN= N;
			boolean[] bool = new boolean[10];
			int boolcount = 0;
			int count = 1;
			
			a: while (true) {
				int temp = N;
				while (temp != 0) {
					if (bool[temp%10] == false) {
						bool[temp%10] = true;
						boolcount++;
						if(boolcount == 10)
							break a;
					}
					temp/=10;
				}
				N +=originN;
				count++;
			}
			System.out.println("#"+tc+" "+count*originN);
		}
	}
}
