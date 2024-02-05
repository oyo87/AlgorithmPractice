import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 보석의 개수 N : 1~300,000 가방의 개수 K : 1~300,000 보석의 무게 M : 0~1,000,000 보석의 가격 V :
		 * 0~1,000,000 가방에 담을 수 있는 최대 무게 C : 1~100,000,000
		 * 
		 * 가방에는 최대 한개의 보석만 넣을 수 있다.
		 * 
		 * 가치 정렬 후 이분탐색으로 찾아보려했으나 시간내 불가능.
		 * 
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] jewel = new int[N][2];// 무게, 가치
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewel[i][0] = Integer.parseInt(st.nextToken());
			jewel[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(jewel, (o1, o2) -> {// 무게 오름차순, 무게 같으면 가치 내림차순
			if (o1[0] == o2[0])
				return o2[1] - o1[1];
			return o1[0] - o2[0];
		});

		int[] bag = new int[K];
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			return o2 - o1;
		});

		long answer = 0;
		int index = 0;
		for (int i = 0; i < K; i++) {
			while (index < N && jewel[index][0] <= bag[i]) {
				pq.add(jewel[index++][1]);
			}

			if (!pq.isEmpty())
				answer += pq.poll();
		}

		System.out.print(answer);

	}
}