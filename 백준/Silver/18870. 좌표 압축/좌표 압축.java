import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//map 활용
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] origin = new int[N];
		int[] arr = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			origin[i] = sc.nextInt();
			arr[i] = origin[i];
		}
		Arrays.sort(arr);

		int index = 0;
		for (int i : arr) {
			if (!map.containsKey(i)) {
				map.put(i, index++);
			}
		}

		for (int key : origin) {
			int result = map.get(key);
			sb.append(result).append(" ");
		}

		System.out.println(sb);

	}
}
