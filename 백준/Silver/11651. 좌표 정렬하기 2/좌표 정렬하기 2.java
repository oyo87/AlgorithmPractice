import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o2[1] < o1[1])
					return 1;
				else if (o1[1] < o2[1])
					return -1;
				else
					return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]);
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
