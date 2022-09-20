import java.util.Scanner;

//1~20까지의 집합. 경우의수는 2^20
//비트마스킹

public class Main {

	static int S = 0;

	static boolean isEmpty(int n) {
		if (0 < (S & (1 << n - 1)))
			return false;
		else
			return true;
	}

	static void add(int n) {
		S += 1 << (n - 1);
	}

	static void remove(int n) {
		S -= 1 << (n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		int n = 0;

		for (int tc = 0; tc < T; tc++) {
			String cmd = sc.next();
			if (!cmd.equals("all") && !cmd.equals("empty")) // all이랑 empty는 숫자입력받지 않음
				n = sc.nextInt();

			if (cmd.equals("add")) {// n이 없으면 n추가 n있으면 그대로
				if (isEmpty(n))
					add(n);
			} else if (cmd.equals("remove")) {// n이 있으면 n제거 n이 없으면 그대로
				if (!isEmpty(n))
					remove(n);
			} else if (cmd.equals("check")) {// n이 있으면 1출력 n이없으면 0출력
				if (isEmpty(n))
					sb.append("0");
				else
					sb.append("1");
				sb.append("\n");
			} else if (cmd.equals("toggle")) {// n이 없으면 add 있으면 remove. 메소드를 만들어두면 편하겠다 n이 있는지 없는지 파악, add, remove
				if (isEmpty(n)) {
					add(n);
				} else {
					remove(n);
				}

			} else if (cmd.equals("all")) {// s를 최대값으로
				S = (1 << 20) - 1;
			} else if (cmd.equals("empty")) {// s를 0으로
				S = 0;
			}
		}
		System.out.println(sb);
	}// main 끝
}
