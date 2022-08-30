import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//버리고 맨밑으로 넣기
//큐를 이용해보자
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();

		if (N == 1) {//1일때 예외처리
			System.out.println(1);
			return;
		}
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		while (true) {
			q.remove();
			if (q.size() == 1)
				break;
			int temp = q.remove();
			q.add(temp);
		}
		System.out.println(q.peek());
	}
}
