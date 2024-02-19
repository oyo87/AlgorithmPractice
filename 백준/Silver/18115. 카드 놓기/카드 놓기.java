import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 처음 들고있는 카드의 수 N : 1~1,000,000
		 * 
		 * 맨위카드,위에서두번째카드, 맨아래카드 내리기 가능
		 * 
		 * 카드를 큰수부터 내린것임.
		 * 
		 * 주어진 인풋을 뒤에서부터 진행
		 * 
		 * 1부터 점점 키워가며 값 넣기
		 * 
		 * Deque 좌(first) 우(end)기준이라면
		 * 
		 * Deque로 1이면 왼쪽으로 밀어넣기
		 * 
		 * 2이면 하나꺼내고 왼쪽으로 밀어넣고 꺼냈던것 왼쪽으로 밀어넣기
		 * 
		 * 3이면 우측으로 밀어넣기
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> dq = new LinkedList<>();
		int num = 1;
		for (int i = N - 1; 0 <= i; i--) {
			if (arr[i] == 1) {
				dq.addFirst(num++);
			} else if (arr[i] == 2) {
				int temp = dq.pollFirst();
				dq.addFirst(num++);
				dq.addFirst(temp);
			} else {// 3
				dq.addLast(num++);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!dq.isEmpty()) {
			sb.append(dq.pollFirst()).append(" ");
		}

		System.out.print(sb);

	}
}