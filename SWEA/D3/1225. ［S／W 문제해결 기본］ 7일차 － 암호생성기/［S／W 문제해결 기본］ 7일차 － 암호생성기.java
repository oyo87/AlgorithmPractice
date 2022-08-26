import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();// 테케번호입력크게의미X
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}
			int del = 1;// 지우는숫자 1부터시작
			int temp = 0;
			while (true) {
				temp = q.peek();
				temp -= del++;
				if (temp <= 0) {// 0보다작아지면 0으로만들고 종료
					q.remove();
					q.add(0);
					break;
				} else {
					q.remove();
					q.add(temp);
				}
				if(del==6)
					del=1;
			}
			System.out.print("#"+tc);
			while(!q.isEmpty()) {
				System.out.print(" "+q.remove());
			}
			System.out.println();

		}
	}
}
