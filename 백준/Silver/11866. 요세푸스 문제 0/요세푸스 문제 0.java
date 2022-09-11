import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//큐 사용
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		sb.append("<");
		int count = 1;
		while (queue.size() != 1) {
			if (count != K) {
				queue.add(queue.poll());
				count++;
			} else {
				sb.append(queue.poll() + ", ");
				count = 1;
			}
		}
		sb.append(queue.poll() + ">");
		System.out.println(sb);
	}
}
