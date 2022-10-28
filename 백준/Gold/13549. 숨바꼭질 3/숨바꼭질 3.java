import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1초후 X-1, X+1이동, 0초후 2배이동가능
//아래에서 조건 걸면 visited 200001-> 100001 줄여서 사용 가능
//BFS로
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int me = sc.nextInt();// 내위치
		int target = sc.nextInt();// 도달해야할위치
		boolean[] visited = new boolean[100001];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { me, 0 });// 현재위치, 이동한 시간
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int loc = poll[0];// 위치
			int time = poll[1];// 소모시간
			visited[loc] = true;

			if (loc == target)// 목적지 도달
				answer = Math.min(answer, time);

			if (loc * 2 <= 100000 && !visited[loc * 2])// 현재위치 2배이동 시간 그대로
				q.add(new int[] { loc * 2, time });
			if (loc + 1 <= 100000 && !visited[loc + 1])// 한칸+이동 시간+1
				q.add(new int[] { loc + 1, time + 1 });
			if (0 <= loc - 1 && !visited[loc - 1]) // 한칸 -이동 시간 +1
				q.add(new int[] { loc - 1, time + 1 });
		}

		System.out.println(answer);
	}
}