import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

//문자열안에 있는지 비교하기 contains사용해보자
//문자열에 담아두고 이중 for로 하나씩 탐색하니 시간초과발생
//HashMap을 이용해서 풀이 시도.
//문자열을 key값으로 전해주고 get을 시도한다
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int count = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> hm = new HashMap<>();

		for (int i = 0; i < N; i++)
			hm.put(br.readLine(), 1);
		for (int i = 0; i < M; i++)
			if (hm.get(br.readLine()) == null) {
				continue;
			} else
				count++;

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();

	}
}
