import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static StringBuilder sb;
	static int[][] maze;
	static boolean[][] visit;
	static int[] start;
	static int[] goal;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };//상하좌우 탐색

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = 10;
		maze = new int[16][16];
		start = new int[2];
		goal = new int[2];
		
		for (int tc = 1; tc <= T; tc++) {// 0길 1벽 2출발 3도착 가능 1출력 불가능 0출력
			int tctc = Integer.parseInt(br.readLine());//tc 실질적 무의미
			visit = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				String temp = br.readLine();
				for (int j = 0; j < 16; j++) {
					maze[i][j] = temp.charAt(j) - '0';
					if (maze[i][j] == 2) {
						start[0] = i;//시작지점 x,y
						start[1] = j;
					} else if (maze[i][j] == 3) {
						goal[0] = i;//출발지점 x,y
						goal[1] = j;
					}
				}
			}
			Recursion(start[0], start[1]);
			sb.append("#").append(tc).append(" ");
			if (visit[goal[0]][goal[1]] == true)
				sb.append(1);
			else
				sb.append(0);
			sb.append("\n");
		} // tc for문
		System.out.println(sb);
	}

	static void Recursion(int x, int y) {
		if (maze[x][y] == 1 || visit[x][y])//벽이거나 방문한곳이면 return
			return;
		for (int i = 0; i < 4; i++) {
			visit[x][y] = true;
			Recursion(x + delta[i][0], y + delta[i][1]);
		}
	}
}
