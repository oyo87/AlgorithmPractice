import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//()이어서 올때가 레이저. 이때 현존막대기의수만큼 갈라진막대기가 더해진다
//반복문을 써서도 가능하고 Stack을 사용해서도 가능할것같다.
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			bw.write("#");
			bw.write(String.valueOf(tc));
			bw.write(" ");

			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			int sum_Stick = 0;// 갈라진 막대기의 수(마지막 출력값)
			int exist_Stick = 0;// 현재 길이에 존재하는 막대기의 수
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {// 열린 괄호가 올경우 막대기개수 일단 하나 증가(닫힐경우 감소 예정)
					exist_Stick++;
				} else {// 닫힌 괄호가 왔을경우
					exist_Stick--;// 일단 막대 감소
					if (stack.peek() == '(') {// 레이저인경우
						sum_Stick += exist_Stick;// 현재 존재하는 막대기 수 만큼 sum에 합산, 레이저는 막대기는아니기에 위에서 미리 줄임
					} else {// 쇠막대기 길이 종료를 나타냄.
						sum_Stick++;// 레이저에 잘릴수있는 막대 개수는 위에서 줄였고, 갈라진 막대기수 하나 추가
					}

				}
				stack.push(str.charAt(i));// 레이저 판별을 위한 push
			}
			bw.write(String.valueOf(sum_Stick));
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
}
