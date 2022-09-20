import java.util.Scanner;

public class Solution {

	static int[] myCard;
	static int[] enemyCard; // 상대 카드 오름차순
	static int win;
	static int lose;

	static void Recursion(int n, int myScore, int enemyScore, boolean[] visit) {
		if (n == 9) {// 누적된 스코어 비교하여 승패 계산
			if (enemyScore < myScore)
				win++;
			else if (myScore < enemyScore)
				lose++;
		} else { // 접근 인덱스가 상당히 헷갈림.
			for (int i = 0; i < 9; i++) {
				if (visit[i] == false) {
					visit[i] = true;
					if (enemyCard[i] < myCard[n])
						Recursion(n + 1, myScore + myCard[n] + enemyCard[i], enemyScore, visit);
					else if (myCard[n] < enemyCard[i])
						Recursion(n + 1, myScore, enemyScore + myCard[n] + enemyCard[i], visit);
					visit[i] = false;
				}

			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			myCard = new int[9];
			enemyCard = new int[9];
			win = 0;
			lose = 0;

			for (int i = 0; i < 9; i++) {
				myCard[i] = sc.nextInt();
			}
			int enemyIndex = 0;
			for (int i = 1; i <= 18; i++) {
				boolean have = false;
				for (int j = 0; j < 9; j++) {
					if (i == myCard[j]) {
						have = true;
						break;
					}
				}
				if (have == false)
					enemyCard[enemyIndex++] = i;
			}
			// 내카드(순서까지), 상대카드(일단 오름차순) 입력 완료
			boolean[] visit = new boolean[9];

			Recursion(0, 0, 0, visit);// 재귀, 내점수, 상대점수, 방문처리
			System.out.println("#" + tc + " " + win + " " + lose);

		} // tc 끝
	}// main 끝
}
