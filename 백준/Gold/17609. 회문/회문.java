import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//반복으로 짜려다가 복잡해져서
//재귀가 나아보였다
//회문이 아닌데, 왼쪽을 제거해도 회문이되고 오른쪽을 제거해도 회문이 되는 케이스를 고려하는게 핵심같다.
public class Main {
	static String str;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			System.out.println(Recursion(str, 0, str.length() - 1, 0));
		}
	}

	static int Recursion(String str, int left, int right, int count) {
		if (count == 2)
			return 2;

		int result = count;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				int leftDel = Recursion(str, left + 1, right, count + 1);
				int rightDel = Recursion(str, left, right - 1, count + 1);
				result = Math.min(leftDel, rightDel);
				break;
			}
			left++;
			right--;
		}
		return result;
	}
}
