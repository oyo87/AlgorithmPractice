import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 배열의 크기 N : 1~50
		 * 
		 * 교환 개수 S : 0~1,000,000
		 * 
		 * 원소값은 모두 다름 1~1,000,000
		 * 
		 * 문제가 해석이 애매한데
		 * 
		 * S만큼 옮겨서 사전식 뒤(내림차순)으로 만드는것
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		int S = Integer.parseInt(br.readLine());

		int exchangeCount = 0;// 교환
		for (int i = 0; i < N && exchangeCount < S; i++) {
			int max = -1;
			int index = -1;

			// 최대값,위치 찾기
			for (int j = i; j < N && j <= i + S; j++) {
				if (max < list.get(j)) {
					max = list.get(j);
					index = j;
				}
			}

			list.remove(index);
			list.add(i, max);
			
			S-= index-i;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.print(sb);

	}
}