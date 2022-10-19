import java.util.Scanner;

//UnionFind
public class Main {
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();// 1부터 n개까지의수가있다.
		int m = sc.nextInt();// m개의 줄이 주어진다.
		StringBuilder sb = new StringBuilder();
		parent = new int[n + 1];

		for (int i = 0; i < n + 1; i++)
			parent[i] = i;

		for (int i = 0; i < m; i++) {
			int cmd = sc.nextInt();// 0은 합치기 1은 합쳐진집합인지확인
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (cmd == 0) {// 합치기
				union(a, b);
			} else if (cmd == 1) {// 합쳐진 집합인지 확인하기
				if (find(a) == find(b))// 부모가 같으면 합쳐진것
					sb.append("YES");
				else
					sb.append("NO");
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

	private static void union(int x, int y) {// x,y의 부모를 찾아서 상대부모 넣어주면 합쳐짐
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y)
				parent[y] = x;
			else
				parent[x] = y;
		}

	}

	private static int find(int x) {
		if (x == parent[x])// 자기자신이 부모
			return x;
		// 자기자신이 부모가 아니라면 재귀로 들어간다.
		return parent[x] = find(parent[x]);

	}
}
