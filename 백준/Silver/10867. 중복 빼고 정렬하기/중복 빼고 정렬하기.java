import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 주어지는 수의 개수 N : 1~100,000
		 * 
		 * 수의 값 : -1,000 ~ 1,000
		 * 
		 * 오름차순 정렬, 같은 정수는 한번만 출력하기
		 * 
		 * Set에 넣어서 중복을 제거해주고
		 * 
		 * sort하고 출력
		 * 
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		int[] arr = new int[set.size()];

		int index = 0;
		for (int i : set) {
			arr[index++] = i;
		}

		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.print(sb);

	}
}