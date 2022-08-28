import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] swap(int[] switchArr, int index) {
		if (switchArr[index] == 1)
			switchArr[index] = 0;
		else
			switchArr[index] = 1;

		return switchArr;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()) + 1;// 스위치개수. 0번인덱스는 안씀
		st = new StringTokenizer(br.readLine());
		int[] switchArr = new int[N]; // 스위치배열 0번은 안씀
		for (int i = 1; i < N; i++) {
			switchArr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());// 학생수
		for (int i = 0; i < M; i++) {
			int gender = 0;
			int number = 0;
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());
			if (gender == 1) {// 남자
				for (int j = 1; j < N; j++) {
					if (j % number == 0)
						switchArr = swap(switchArr, j);
				}
			} else {// 여자
				switchArr = swap(switchArr, number);
				for (int j = 1; 1 <= number - j && j + number < N; j++) {
					if (switchArr[j + number] == switchArr[number - j]) {
						switchArr = swap(switchArr, j + number);
						switchArr = swap(switchArr, number - j);
					} else
						break;
				}
			}
		}
		for (int i = 1; i < N; i++) {
			if ((i - 1) % 20 == 0) {
				if (i != 1)
					bw.write("\n");
				bw.write(String.valueOf(switchArr[i]));
			} else
				bw.write(" " + switchArr[i]);
		}
		bw.flush();
		bw.close();

	}
}
