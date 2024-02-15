import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * H,W : 1~99
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(st.nextToken());// row
			int W = Integer.parseInt(st.nextToken());// col
			int N = Integer.parseInt(st.nextToken());

			int[][] hotel = new int[H][W];

			if (N % H == 0)
				sb.append((H * 100) + (N / H));
			else
				sb.append((N % H * 100) + ((N / H) + 1));

			sb.append("\n");
		}

		System.out.print(sb);
	}
}