import java.util.Arrays;
import java.util.Scanner;

//문제를 제대로 읽지 않아서 오래걸렸다.
//최소비용이 아니라 절약하는 비용, 테스트케이스는 여러개 올수있다.
//문제를 잘 읽어보자
//최소스패닝트리, 유니온파인드
public class Main {
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문제입력에서 m ,n으로 주어진다. nm이아니라..
		while (true) {
			int m = sc.nextInt();// 집의수
			int n = sc.nextInt();// 길의수
			if (m == 0 && n == 0)
				break;

			int[][] info = new int[n][3];// 거리, x,y를 넣어준다.
			int totalCost = 0;
			for (int i = 0; i < n; i++) {
				info[i][0] = sc.nextInt();// x
				info[i][1] = sc.nextInt();// y
				info[i][2] = sc.nextInt();// meter
				totalCost += info[i][2];// 비용총합
			}

			Arrays.sort(info, (a, b) -> a[2] - b[2]);// 아래식보다 편리하다
//		Arrays.sort(info,new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[2]-o2[2];
//			}});// 거리 짧은것부터 우선

			parent = new int[m];
			for (int i = 0; i < m; i++) {
				parent[i] = i;
			}

			int minCost = 0;
			for (int i = 0; i < n; i++) {
				int x = info[i][0];
				int y = info[i][1];
				int meter = info[i][2];
				if (find(x) != find(y)) {
					parent[find(y)] = find(x);
					minCost += meter;
				}
			}
			System.out.println(totalCost - minCost);// 최소비용이아니라 절약할수있는 값을 출력하는것이었다..!
		}
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}
}
