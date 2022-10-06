import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] map = new int[10][10];
	static boolean[][][] bcPossible;
	static int[][] bcInfo;
	static int[][] delta = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 상우하좌

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();// 이동시간 minute
			int A = sc.nextInt();// BC의 개수
			bcPossible = new boolean[A][10][10];// 특정BC가 x,y좌표에서 충전가능하면 true
			int[] aMove = new int[M];// a의 이동경로
			int[] bMove = new int[M];// b의 이동경로
			bcInfo = new int[A][4];// AP의 x,y좌표, 사정거리, 파워
			int answer = 0;

			for (int i = 0; i < M; i++)
				aMove[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				bMove[i] = sc.nextInt();

			//// AP의 x,y좌표, 사정거리, 파워담기
			for (int i = 0; i < A; i++) {
				for (int j = 0; j < 4; j++) {
					if (j == 0 || j == 1) {
						int temp;
						if (j == 0)// x,y좌표가 주어지니 행렬에선 바꿔준다. row,col
							temp = 1;
						else
							temp = 0;

						bcInfo[i][temp] = sc.nextInt() - 1; // x,y좌표는 문제에서 1,1부터시작하는데 배열은 0,0이니까 1빼준다.
					} else
						bcInfo[i][j] = sc.nextInt();
				}
			}

			// x,y좌표마다 충전이 가능한곳이 있으면 bcPossible true로 만들어준다. BFS
			for (int i = 0; i < A; i++) {
				Queue<int[]> q = new LinkedList<>();

				bcPossible[i][bcInfo[i][0]][bcInfo[i][1]] = true;
				int[] init = { bcInfo[i][0], bcInfo[i][1], 0 };// [2]는 depth
				q.add(init);
				while (!q.isEmpty()) {
					int[] temp = q.poll();
					if (temp[2] == bcInfo[i][2])
						continue;
					for (int j = 1; j < 5; j++) {
						if (RangePossible(temp[0], temp[1], j)) {// 배열 범위 내라면
							if (!bcPossible[i][temp[0] + delta[j][0]][temp[1] + delta[j][1]]) {// 상우하좌중 방문안한거있으면
								int[] temp2 = { temp[0] + delta[j][0], temp[1] + delta[j][1], temp[2] + 1 }; // 상우하좌이동한것
								q.add(temp2); // 새로 큐에 넣어주고
								bcPossible[i][temp[0] + delta[j][0]][temp[1] + delta[j][1]] = true;// 방문처리
							}

						}
					}

				} // bfs end
			}

			int[] aPos = { 0, 0 };// 시작위치
			int[] bPos = { 9, 9 };// 시작위치

			int initA = 0;
			int initB = 0;
			for (int i = 0; i < A; i++) {
				if (bcPossible[i][aPos[0]][aPos[1]] == true) {
					initA = Math.max(initA, bcInfo[i][3]);
				}
				if (bcPossible[i][bPos[0]][bPos[1]] == true) {
					initB = Math.max(initB, bcInfo[i][3]);
				}
			}
			answer += initA + initB;// 시작위치 더하고 시작
			for (int i = 0; i < M; i++) {// 움직임 시작
				boolean[] useA = new boolean[A];// A가사용가능한 충전소
				boolean[] useB = new boolean[A];// B가사용가능한 충전소
				boolean[] flag = new boolean[2];// 사용가능한충전소가있는지 [0]=A사용가능여부[1]=B사용가능여부

				aPos[0] += delta[aMove[i]][0];// i==움직임인덱스
				aPos[1] += delta[aMove[i]][1];
				bPos[0] += delta[bMove[i]][0];
				bPos[1] += delta[bMove[i]][1];

				for (int j = 0; j < A; j++) {
					if (bcPossible[j][aPos[0]][aPos[1]] == true) {
						useA[j] = true;
						flag[0] = true;
					}
					if (bcPossible[j][bPos[0]][bPos[1]] == true) {// 실수로 bPos가 아니라 aPos였다..@_@
						useB[j] = true;
						flag[1] = true;
					}
				}
				if (flag[0] == true && flag[1] == true) {// 둘다 사용가능한게있다면
					int maxA = 0;
					int maxB = 0;
					int maxIdxA = -1;// A최대인덱스
					int maxIdxB = -1;// B최대인덱스
					for (int j = 0; j < A; j++) {
						if (useA[j] == true) {
							if (maxA < bcInfo[j][3]) {
								maxA = bcInfo[j][3];
								maxIdxA = j;
							}
						}
						if (useB[j] == true) {// 실수로 부등호가 하나였었다...@_@
							if (maxB < bcInfo[j][3]) {
								maxB = bcInfo[j][3];
								maxIdxB = j;
							}

						}
					}
					if (maxIdxA == maxIdxB) {// 둘다 최대 사용할수있는게 겹치면 다른걸고르거나 같은걸 겹쳐고르거나
						int secondA = 0;
						int secondB = 0;
						for (int j = 0; j < A; j++) {
							if (j == maxIdxA)// 최대값이었던 위치면 패스
								continue;
							if (useA[j] == true) {
								secondA = Math.max(secondA, bcInfo[j][3]);
							}
							if (useB[j] == true) {
								secondB = Math.max(secondB, bcInfo[j][3]);
							}
						}
						int secondMax = Math.max(secondA, secondB);
						answer += (maxA + secondMax);

					} else// 둘다 사용할수있는데 다른 BC를 사용하면 바로 더함
						answer += maxA + maxB;

				}

				else if (flag[0] == true) {// A만 사용가능
					int temp = 0;
					for (int j = 0; j < A; j++) {
						if (useA[j] == true) {
							temp = Math.max(temp, bcInfo[j][3]);
						}
					}
					answer += temp;

				}

				else if (flag[1] == true) {// B만 사용가능
					int temp = 0;
					for (int j = 0; j < A; j++) {
						if (useB[j] == true) {
							temp = Math.max(temp, bcInfo[j][3]);
						}
					}
					answer += temp;
				}

			} // 움직임 end
			System.out.println("#" + tc + " " + answer);

		} // tc end
	}// main end

	private static boolean RangePossible(int x, int y, int idx) {
		if (0 <= x + delta[idx][0] && x + delta[idx][0] < 10 && 0 <= y + delta[idx][1] && y + delta[idx][1] < 10)
			return true;
		return false;
	}
}
