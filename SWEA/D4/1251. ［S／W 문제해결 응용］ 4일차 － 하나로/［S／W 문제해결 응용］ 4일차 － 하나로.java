import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//크루스칼, 프림등 사용가능 크루스칼 알고리즘으로 풀어보자
public class Solution {
	static int[] p;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] island = new int[N][2];// x,y좌표
			double result = 0;

			for (int i = 0; i < N; i++)
				island[i][0] = sc.nextInt(); // x값
			for (int i = 0; i < N; i++)
				island[i][1] = sc.nextInt(); // y값입력
			double E = sc.nextDouble();// 세율

			double[][] edges = new double[(N * (N - 1)) / 2][3]; // MST개수는 N-1 출발점, 도착점, 길이
			int edgesIdx = 0;
			for (int i = 0; i < N - 1; i++) {// 증복없이 조합
				int x1 = island[i][0];
				int y1 = island[i][1];
				for (int j = i + 1; j < N; j++) {
					int x2 = island[j][0];
					int y2 = island[j][1];
					edges[edgesIdx][0] = i;
					edges[edgesIdx][1] = j;
					edges[edgesIdx++][2] = (double) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // 어차피
																									// 제곱해줄테니 루트 필요X
				}
			}
			Arrays.sort(edges, new Comparator<double[]>() { // 섬 거리를 우선순으로 정렬
				@Override
				public int compare(double[] o1, double[] o2) {
					return (int) (o1[2] - o2[2]);
				}

			});
			p = new int[N];
			for (int i = 0; i < N; i++)
				p[i] = i;// make-set과정

			int pick = 0;
			for (int i = 0; i < N * (N - 1) / 2; i++) {
				if (pick == N - 1)
					break;
				int Va = findSet((int) edges[i][0]);// a대표
				int Vb = findSet((int) edges[i][1]);// b대표

				if (Va != Vb) {
					union(Va, Vb);
					result += edges[i][2];
					pick++;
				}
			}

			result *= E;
			long longResult = (long) Math.round(result);
			sb.append("#").append(tc).append(" ").append(longResult).append("\n");
		} // tc end
		System.out.println(sb);
	}// main end

	static void union(int x, int y) {
		p[y] = x;
	}

	static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
}
