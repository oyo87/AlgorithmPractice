import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int doc = Integer.parseInt(st.nextToken());// 문서의 개수
			int target = Integer.parseInt(st.nextToken());// 몇번째 인쇄될지 찾아야할것

			int[][] arr = new int[doc][2];// 중요도 담아두기, [doc][0]이 중요도 [doc][1]이 target인지확인
			st = new StringTokenizer(br.readLine());
			Queue<int[]> queue = new LinkedList<>();
			int[] importance = new int[doc];// 중요도
			for (int i = 0; i < doc; i++) {
				int temp = Integer.parseInt(st.nextToken());
				importance[i] = temp;
				arr[i][0] = temp;
				if (i == target)
					arr[i][1] = 1;
				queue.add(arr[i]);
			}
			Arrays.sort(importance);// 오름차순으로되어있음

			int index = doc - 1;
			int count = 0;
			while (!queue.isEmpty()) {
				int[] temp = queue.peek();
				if (temp[0] == importance[index]) {// 큐의 가장 첫번째가 가장 높은 중요도인경우(출력할 상황)
					count++;
					index--;
					if (temp[1] == 1)// 해당하는 타겟이다.
						break;
					queue.poll();
				} else {
					queue.offer(queue.poll());
				}
			}
			sb.append(count).append("\n");
		} // tc for문 끝
		System.out.println(sb);
	}
}
