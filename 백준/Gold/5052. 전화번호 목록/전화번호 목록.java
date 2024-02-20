import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 테스트케이스 t : 1~50
		 * 
		 * 전화번호의 수 n : 1~10,000
		 * 
		 * 전화번호의 길이 : 1~10
		 * 
		 * map으로 저장해가며 진행하면
		 * 
		 * 케이스당 10*10000 저장
		 * 
		 * Map 저장하려는데 중복생기면 NO
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		loop: for (int tc = 0; tc < T; tc++) {
			Map<String, Boolean> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			String[] number = new String[N];
			for (int i = 0; i < N; i++) {
				number[i] = br.readLine();
				map.put(number[i], true);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < number[i].length() - 1; j++) {
					if (map.containsKey(number[i].substring(0, j + 1))) {
						sb.append("NO").append("\n");
						continue loop;
					}
				}
			}

			sb.append("YES").append("\n");
		}

		System.out.print(sb);

	}
}