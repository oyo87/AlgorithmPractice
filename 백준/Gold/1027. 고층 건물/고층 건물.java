import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 빌딩의 개수 N : 1~50 빌딩의 높이 : 1~10억
		 * 
		 * 건물 A,B를 이은 선분의 기울기 : (A높이 - B높이) / A 와 B의거리 좌->우 탐색하면서 우측이 보이면 내가 볼수있는 건물에서도
		 * 날 볼수 있다.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] height = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int[] visible = new int[N];
		for (int i = 0; i < N - 1; i++) {
			// 현재건물과 바로 우측에있는 건물 둘다 서로 무조건 보임
			visible[i]++;
			visible[i + 1]++;

			double slope = height[i + 1] - height[i];// 거리는 1

			for (int j = i + 2; j < N; j++) {
				double maxSlope = (double) (height[j] - height[i]) / (double) (j - i);
				if (slope < maxSlope) {
					slope = maxSlope;
					// i,j는 서로 보임
					visible[i]++;
					visible[j]++;
				}
			}

		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, visible[i]);
		}
		System.out.print(answer);

	}
}