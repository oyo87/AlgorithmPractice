import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 단어의 줄 수
		String[] arr = new String[N]; // 단어 라인을 담음
		int[] alpha = new int[26]; // A~Z알파뱃별로 값 담을 공간.

		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		for (int i = 0; i < N; i++) {
			int digit = (int) Math.pow(10, arr[i].length() - 1); // 가장큰 자릿수를 pow(10,len-1) 이용 계산
			for (int j = 0; j < arr[i].length(); j++) {
				alpha[(int) arr[i].charAt(j) - 'A'] += digit; // 특정알파뱃에 해당하는 자릿수를 더해줌
				digit /= 10;
			}
		}
		// alpha배열에 알파뱃별로 자릿수의 합이 들어가있다.
		Arrays.sort(alpha);// 맨뒤에 가장 큰 합의 순서대로 오게된다. 무슨 알파뱃인지는이제 의미 X
		int index = 9; // 큰값을 먼저부여해야하니 9부터 부여해준다.
		int sum = 0;

		for (int i = alpha.length - 1; 0 <= i; i--) { // 뒤에서부터 탐색 뒤가 가장 크므로 큰값부여 9,8,7,6 ...
			if (alpha[i] == 0) {// 모든 알파뱃 사용완료하면 반복문 끝
				break;
			}
			sum += alpha[i] * index;
			index--;
		}
		System.out.println(sum);
	}
}