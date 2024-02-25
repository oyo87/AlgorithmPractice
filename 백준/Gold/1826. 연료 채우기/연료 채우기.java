import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 주유소에서 멈추는 횟수 최소화
		 * 
		 * 주유소 개수 N : 1~10,000
		 * 
		 * 주유소 좌표 : 1~1,000,000
		 * 
		 * 해당주유소에서 채울 수 있는 연료 : 1~100
		 * 
		 * 마을위치 : 1~1,000,000
		 * 
		 * 기존 보유 연료 : 1~1,000,000
		 * 
		 * 주유소 거리 가까운순으로 pq
		 * 
		 * 연료pq는 큰순으로 정렬
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer[]> stationPq = new PriorityQueue<>((o1, o2) -> {
			return o1[0] - o2[0];
		});
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			stationPq.add(new Integer[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		PriorityQueue<Integer> fuelPq = new PriorityQueue<>(Collections.reverseOrder());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int town = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());

		int answer = 0;

		boolean success = true;

		while (fuel < town) {
			while (!stationPq.isEmpty() && stationPq.peek()[0] <= fuel) {// 도착가능한경우 
				fuelPq.add(stationPq.poll()[1]);
			}

			if (fuelPq.isEmpty()) {
				success = false;
				break;
			}

			answer++;
			fuel += fuelPq.poll();
		}

		if (success)
			System.out.print(answer);
		else
			System.out.print(-1);

	}
}