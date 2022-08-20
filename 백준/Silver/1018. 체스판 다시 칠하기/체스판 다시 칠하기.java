import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2차원배열로 입력을 받는다. 
//행의 합 열의합을 구해서 8행,8열의 구성만큼 B,W개수를 파악하여 B-32 W-32 가 0보다 작으면 0 0에 가장 가까운것으로.
//-1을 곱하거나 절대값으로 출력
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];
		String temp;
		for (int i = 0; i < N; i++) {
			temp = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp.charAt(j);
			}
		} // 인풋값 배열에 넣기
		
		int minCount = 64;// 최대횟수
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {

				int count = 0;
				char color = arr[i][j];
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if (arr[i + k][j + l] != color)
							count++;
						if (color == 'W')// 색은 번갈아 필요하니 다음색을 매번 바꿔줘야함
							color = 'B';
						else
							color = 'W';
					} // 마지막값과 다음행의 첫값은 같아야하므로 다시바꿔서 원래대로 돌림
					if (color == 'W')
						color = 'B';
					else
						color = 'W';
				}

				count = Math.min(count, 64 - count);// 한 색 변경 횟수와 다른 색 변경횟수
				minCount = Math.min(count, minCount);// 기존과 비교해서 작은지
			}
		}
		bw.write(String.valueOf(minCount));
		bw.flush();
		bw.close();
	}
}
