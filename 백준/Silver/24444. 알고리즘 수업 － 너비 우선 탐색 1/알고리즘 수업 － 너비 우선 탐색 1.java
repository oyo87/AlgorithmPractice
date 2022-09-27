import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] visit;
	static ArrayList<Integer>[] al;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt(); //정점 수
		int M = sc.nextInt(); // 간선 수
		int R = sc.nextInt(); // 시작 정점
		visit = new int[N + 1];  //1부터시작해서 N+1

		al = new ArrayList[N + 1]; // 1부터시작
		for (int i = 1; i <= N; i++) { //0번은 안쓰고 1~N까지사용
			al[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt(); //u와 v는 연결됨
			int v = sc.nextInt();

			al[u].add(v);
			al[v].add(u);
		}
		for (int i = 1; i <= N; i++) { // 인접 정점은 오름차순 정렬하라고 한다.
			Collections.sort(al[i]);
		}

		bfs(R);
		for (int i = 1; i <= N; i++)
			sb.append(visit[i]).append("\n"); //1부터 N까지 visit[i]값 출력
		System.out.print(sb);
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int count = 1; //start정점은 첫번째니까 1
		q.add(start);
		visit[start] = count++; //start정점은 첫번째니까 1

		while (!q.isEmpty()) {
			int temp = q.poll();

			for (int i = 0; i < al[temp].size(); i++) {

				if (visit[al[temp].get(i)] == 0) {// 방문안했으면
					visit[al[temp].get(i)] = count++;// visit에 count추가
					q.add(al[temp].get(i));// 큐에 넣어줌
				}
			}
		}

	}

}
