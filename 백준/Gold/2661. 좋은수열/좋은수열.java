import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백트래킹으로 접근하는 문제였다.
public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 1이상80이하.

		bt("");// 백트래킹

	}

	private static void bt(String str) {
		if (str.length() == N) {
			System.out.println(str);
			System.exit(0);// 처음찾은 수열이 제일 작은 좋은 수열이된다
		}

		for (int i = 1; i <= 3; i++) {// 1,2,3만으로 이루어진 수열이고 작은것먼저완성해나가ㅣ 1,2,3순서대로 넣기
			if (goodChcek(str + i)) {// 좋은수열 이면
				bt(str + i);
			}
		}

	}

	private static boolean goodChcek(String str) {

		for (int i = 1; i <= str.length() / 2; i++) {// 나쁜수열탐색
			if (str.substring(str.length() - i).equals(str.substring(str.length() - 2 * i, str.length() - i))) {
				return false;
			}
		}
		return true;
	}
}
