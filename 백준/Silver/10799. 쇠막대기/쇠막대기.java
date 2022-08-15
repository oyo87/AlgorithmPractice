import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int piece = 0;// 잘린 조각
		int stick = 0;// 쇠막대기

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {// ( 가 나올경우 쇠막대기를 하나 증가시켜준다.
				stick++;
			} else {// ) 가 나올경우 쇠막대기를 하나 줄여주고
				stick--;
				if (str.charAt(i - 1) == ')') {// )) 쇠막대기 길이 종료를 나타내므로 조각개수증가
					piece++;
				} else // ()가 연달아 온것이라면 레이저이므로 현재 막대기의 개수만큼을 조각에 추가시킨다
					piece += stick;
			}
		}
		bw.write(String.valueOf(piece));
		bw.flush();
		bw.close();

	}
}
