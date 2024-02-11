import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 시간 H : 0~23 
		 * 분 M : 0~59 45분 
		 * 일찍 알람 설정하기 불필요한 0은 사용하지 않기
		 * 
		 * %,/연산 활용
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = 24;
		int M = 15;// 60-45
		H += Integer.parseInt(st.nextToken());
		M += Integer.parseInt(st.nextToken());

		if (M < 60)
			H--;
		H %= 24;
		M %= 60;

		System.out.print(H + " " + M);

	}
}