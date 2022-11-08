import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//맵, 셋을 활용해서 진행하다가 자꾸 틀렸다.
//투포인터
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());// 1~2000
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int findNum = arr[i];

			int start = 0;
			int end = N - 1;
			int sum = 0;

			while (start < end) {
				sum = arr[start] + arr[end];
				if (sum == findNum) {
					if (i == start) {
						start++;
					} else if (i == end) {
						end--;
					} else {
						answer++;
						break;
					}
				}
				if (findNum < arr[start] + arr[end])//기준값보다 크면 줄이며찾기
					end--;
				else if (arr[start] + arr[end] < findNum)//기준값보다 작으면 크게하며 찾기
					start++;
			}//while end
		}//for end
		System.out.println(answer);

	}
}
