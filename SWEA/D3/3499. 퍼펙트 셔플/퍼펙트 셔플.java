import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//큐 두개사용을 하거나 반복문을 사용하거나
//q1 절반만큼 add
//q2 나머지 절반 add
//q1,q2 번갈아가며 remove
//Buffered,StringTokenizer 연습
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Queue<String> q1 = new LinkedList<>();
		Queue<String> q2 = new LinkedList<>();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			bw.write("#"+tc+" ");
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				if (i < (double) N / 2)// N이 홀수일경우 한번 더 돌아야해서 소수점까지 계산
					q1.add(st.nextToken());// 절반까지 q1에 담고
				else
					q2.add(st.nextToken());// 절반이후부터 q2에 담게됨
			}

			for (int i = 0; i < N; i++) {// q1,q2번갈아가며 하나씩 출력
				if (i % 2 == 0)
					bw.write(q1.remove());
				else
					bw.write(q2.remove());
				if (i != N - 1)//마지막이 아니라면 공백 추가
					bw.write(" ");
			}
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
	}
}
