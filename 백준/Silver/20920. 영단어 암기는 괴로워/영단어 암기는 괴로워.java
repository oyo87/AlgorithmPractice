import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 자주나온 단어
		 * 
		 * 2. 긴 단어
		 * 
		 * 3. 알파벳 사전순
		 * 
		 * 영어 단어의 개수 N : 1~100,000
		 * 
		 * 단어외울 최소 길이 M : 1~10
		 * 
		 * 단어는 10자 이내이다.
		 * 
		 * 입력값을 조회하면서 단어길이가 M길이 이상일경우 map에 저장, 횟수 기록
		 * 
		 * 특정 클래스를 사용하는 pq를 만들어서 조건에 맞게 정렬후 출력
		 */

		class Word {
			String str;
			int len;
			int count;

			Word(String str, int count) {
				this.str = str;
				this.len = str.length();
				this.count = count;
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (M <= str.length())
				map.put(str, map.getOrDefault(str, 0) + 1);
		}

		PriorityQueue<Word> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.count != o2.count) {// 조건1
				return o2.count - o1.count;
			}

			if (o1.len != o2.len) {// 조건2
				return o2.len - o1.len;
			}

			for (int i = 0; i < o1.len; i++) {// 조건3
				if (o1.str.charAt(i) != o2.str.charAt(i)) {
					return o1.str.charAt(i) - o2.str.charAt(i);
				}
			}
			return 0;
		});

		for (String s : map.keySet()) {
			pq.add(new Word(s, map.get(s)));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll().str).append("\n");
		}

		System.out.print(sb);

	}
}