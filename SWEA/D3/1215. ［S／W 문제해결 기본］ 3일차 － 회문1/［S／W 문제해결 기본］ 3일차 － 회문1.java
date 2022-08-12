import java.util.Scanner;

// 회문 palindrome
// 8X8크기배열에 ABC가 담긴다.
// 8 - 주어진 회문의 길이 인덱스 까지만 확인을 하면 된다.

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		int size = 8;// 8 * 8 배열을 만들어야 함
		String[] arr = new String[size];

		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();// 구할 회문의 길이
			int count = 0;// 회문개수를 셈
			int flag = 0;// 회문판별할때 사용할 flag

			for (int i = 0; i < size; i++) {
				arr[i] = sc.next();
			} // 배열안에 값 입력

			for (int i = 0; i < size; i++) { // 행탐색 가로 회문탐색
				for (int j = 0; j < size - len + 1; j++) {// 모든것을 탐색하지않고 배열길이 - 회문길이 인덱스까지만 검색
					for (int k = 0; k < len / 2; k++) {// 회문은 1/2까지만 검사해보면된다.
						if (arr[i].charAt(j + k) != arr[i].charAt(j + len - 1 - k))// 앞과 뒤가 다를경우
							break;
						else
							flag++;// 앞과 뒤가 같으면 flag++
					}
					if (flag == len / 2)// flag가 회문길이 / 2와 같다면 회문이 맞으므로 count++
						count++;
					flag = 0;// 회문 탐색을 한번 마쳤으니 다시 0으로 초기화
				}
			}
			for (int i = 0; i < size; i++) { // 열탐색 내부 내용은 위와 동일하고 [i][j] 인덱스 위치만 변경하여 세로 회문을 탐색한다.
				for (int j = 0; j < size - len + 1; j++) {
					for (int k = 0; k < len / 2; k++) {
						if (arr[j + k].charAt(i) != arr[j + len - 1 - k].charAt(i))
							break;
						else
							flag++;
					}
					if (flag == len / 2) {
						count++;
					}
					flag = 0;
				}
			} // 행탐색과 동일한 로직

			System.out.printf("#%d %d\n", tc, count);

		}
	}
}
