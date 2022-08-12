
import java.util.Scanner;

//영어 문자열 입력 받고 그안에 특정 문자열이 몇개 있는지 세고 출력하기
//메소드 활용하지말고 브루트포스 형식으로 풀어보기
//반복문을 이용해서 비교해나가기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();// 테케입력
			String target = sc.next();// 검색할 문자열 target <= 10
			String str = sc.next();// 문장 str <= 1000

			int len = target.length();// 검색할 문자열의 길이
			int count = 0;// 동일한게 발견되면 count++하며 체크

			for (int i = 0; i < str.length() - len + 1; i++) {
				if (target.charAt(0) == str.charAt(i)) {// 검색중인 문장과 target의 첫글자가 같으면
					for (int j = 0; j <= len; j++) {// 뒤에도 같은지 확인
						if (j == len) {// 단어 길이만큼 j가 상승됐으면 같은것이므로
							count++;// 같은것을 나타내는 count++
							break;
						}
						if (target.charAt(j) != str.charAt(i + j))// 탐색중 다른값이 나온다면 탐색중지
							break;
					}
				}

			}
			System.out.printf("#%d %d\n", tc, count);
		}

	}
}
