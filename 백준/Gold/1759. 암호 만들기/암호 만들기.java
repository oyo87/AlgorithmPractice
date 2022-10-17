import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L;
	static int C;
	static char[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());// 서로다른 L개의 알파벳 소문자
		C = Integer.parseInt(st.nextToken());// 문자의 종류
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		visited = new boolean[C];
		Arrays.sort(arr);
		combination(0, 0);
	}

	static void combination(int sidx, int depth) {
		if (depth == L) {
			int vowel = 0;// 모음체크
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < C; i++) {
				if (visited[i]) {
					sb.append(arr[i]);
					if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
						vowel++;
				}
			}
			// 1이상의 모음, 2이상의 자음
			if (1 <= vowel && 2 <= L - vowel)
				System.out.println(sb);
		}

		for (int i = sidx; i < C; i++) {
			visited[i] = true;
			combination(i + 1, depth + 1);
			visited[i] = false;
		}
	}
}