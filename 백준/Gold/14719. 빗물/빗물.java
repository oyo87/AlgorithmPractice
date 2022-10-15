import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 처음엔 1차원 배열만이용하며 접근했다가 번거로워져서
//2차원으로 해결하니 더욱 편했다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				arr[H - 1 - j][i] = true;
			}
		} // 블록이 있는곳을 true로 입력을 받는다.

		// 한줄씩 탐색을 하면서 가장 왼쪽부터 블록이 있는첫번째위치, 오른쪽부터 블록이 있는 첫번째위치
		// 를 파악한 후 그사이에있는 false는 모두 빗물이 고이는곳이므로 answer++하는식으로 진행
		int answer = 0;
		for (int i = 0; i < H; i++) {
			int start = -1;
			int end = -1;
			for (int j = 0; j < W; j++) {// start찾기
				if (arr[i][j] == true) {
					start = j;
					break;
				}
			}
			for (int j = W - 1; 0 <= j; j--) {// end찾기
				if (arr[i][j] == true) {
					end = j;
					break;
				}
			}

			if (start != -1 && end != -1) {// start도있고 end도있으면
				for (int j = start + 1; j < end; j++) {
					if (arr[i][j] == false)
						answer++;
				}
			}
		}

		System.out.println(answer);

	}
}
