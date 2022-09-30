import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//시간초과라..
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer[] cranePower = new Integer[N];

		for (int i = 0; i < N; i++)
			cranePower[i] = sc.nextInt();
		Arrays.sort(cranePower, Collections.reverseOrder());// 강한순으로 정렬

		int M = sc.nextInt();
		Integer[] boxWeight = new Integer[M];
		for (int i = 0; i < M; i++)
			boxWeight[i] = sc.nextInt();

		Arrays.sort(boxWeight, Collections.reverseOrder());// 무거운순으로 정렬

		boolean[] impossible = new boolean[N];// 크레인이 박스처리 불가능인가
		boolean[] visited = new boolean[M]; // 처리한 박스

		int count = 0;
		if (cranePower[0] < boxWeight[0]) {// 가장무거운박스를 크레인이 들 수 없을경우
			System.out.println(-1);
			return;
		}

		int answer = 0;
		int[] start = new int[N];// 각 크레인별 탐색 시작 지점
		while (count < M) {
			for (int i = 0; i < N; i++) {
				if (!impossible[i]) {
					boolean work = false;
					for (int j = start[i]; j < M; j++) {
						if (!visited[j] && boxWeight[j] <= cranePower[i]) {
							visited[j] = true;
							count++;
							work = true;
							start[i] = j + 1;// 다음작업탐색 시작시점
							break;
						}
					}
					if (!work)// 끝까지탐색했는데 일을 못했다면 이제사용불가능한 크레인임
						impossible[i] = true;
				}
			}
			answer++;
		}
		System.out.println(answer);

	}
}
