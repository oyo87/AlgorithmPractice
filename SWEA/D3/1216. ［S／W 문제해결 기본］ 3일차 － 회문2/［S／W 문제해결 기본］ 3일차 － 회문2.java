import java.util.Scanner;

// 회문 palindrome
// 100x100 사이즈로 들어온다. 가장 긴 회문을 구한다.
// 회문의 길이를 최대길이부터 --하면서 탐색을 해서 회문이 하나라도나오는순간 출력하고 끝낸다.
// 기존에짰던 회문1의 코드를 활용해서 해보자

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		int size = 100;// 100 * 100 배열을 만들어야 함
		String str = new String();// str을 받아서 char[][]에 넣어준다
		char[][] arr = new char[size][size];

		for (int tc = 1; tc <= T; tc++) {

			sc.nextInt();// 테스트케이스번호입력
			for (int i = 0; i < size; i++) {
				str = sc.next();
				for (int j = 0; j < size; j++) {
					arr[i][j] = str.charAt(j);
				}
			} // char[][]채워주는 작업

			int len = 100;// len을 100부터 시작해서 줄여준다.
			int maxLen = 0;// 최대 회문 길이

			whileLoop: while (0 < len--) {// while로 len을 계속 줄여줌 라벨링해서 탈출가능하게해둠
				int flag = 0;// 회문판별할때 사용할 flag

				for (int i = 0; i < size; i++) { // 행탐색 가로 회문탐색
					for (int j = 0; j < size - len + 1; j++) {// 모든것을 탐색하지않고 배열길이 - 회문길이 인덱스까지만 검색
						for (int k = 0; k < len / 2; k++) {// 회문은 1/2까지만 검사해보면된다.
							if (arr[i][j + k] != arr[i][j + len - 1 - k])// 앞과 뒤가 다를경우
								break;
							else
								flag++;// 앞과 뒤가 같으면 flag++
						}
						if (flag == len / 2) {// 회문 판별 조건문. flag가 회문길이 / 2와 같다면 회문이라는것.
							maxLen = len;// 회문이 존재하기에 최대회문 길이를 현재 길이로
							break whileLoop; // len반복문 탈출
						}
						flag = 0;// 회문 탐색을 한번 마쳤으나 회문이 아닐테니 다시 0으로 초기화
					}
				}
				for (int i = 0; i < size; i++) { // 열탐색 내부 내용은 위와 동일하고 [i][j] 인덱스 위치만 변경하여 세로 회문을 탐색한다.
					for (int j = 0; j < size - len + 1; j++) {
						for (int k = 0; k < len / 2; k++) {
							if (arr[j + k][i] != arr[j + len - 1 - k][i])
								break;
							else
								flag++;
						}
						if (flag == len / 2) {
							maxLen = len;
							break whileLoop;
						}
						flag = 0;
					}
				} // 행탐색과 동일한 로직
			}

			if (0 < maxLen) {// maxlen 값이 있다면 그것을 출력하면된다.
				System.out.printf("#%d %d\n", tc, maxLen);
				continue;
			}
		}
	}
}
