import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int num = 666;
		while (count < N) {
			int tempNum = num;
			while (0 < tempNum) {
				if (tempNum % 1000 == 666) {
					count++;
					break;
				} else
					tempNum /= 10;
			}
			num++;
		}
		num--;
		System.out.println(num);
	}
}
