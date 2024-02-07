import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int answer = 0;
	static int G;
	static int P;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		/*
		 * 게이트의 개수 G : 1~100,000 비행기의 수 P : 1~100,000
		 * 
		 * 주어진 g이하의 게이트에 도킹하기 주어진 게이트번호에서 시작해서 점점 낮춰가며 도킹할곳을 찾아야한다. 완탐시 50억정도.
		 * 
		 * 유니온 파인드 이용 해서 부모에넣고 부모--
		 * 
		 * 도착지가 0인경우 end
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		parent = new int[G + 1];
		for (int i = 1; i < G + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < P; i++) {
			int num = Integer.parseInt(br.readLine());
			int gate = find(num);
			if (gate == 0)
				break;

			answer++;
			// union
			int a = find(gate);
			int b = find(gate - 1);

			if (a != b)
				parent[a] = b;

		}

		System.out.print(answer);
	}

	static int find(int num) {
		if (parent[num] == num) {
			return num;
		}
		return parent[num] = find(parent[num]);
	}
}