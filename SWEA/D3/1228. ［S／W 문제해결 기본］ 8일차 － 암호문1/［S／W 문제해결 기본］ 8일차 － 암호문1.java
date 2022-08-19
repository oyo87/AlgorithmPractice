import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

//LinkedList활용하여 풀어본다.
//처음부터 x인덱스의위치에 y개만큼 삽입을 한다.
//다음 암호문은 Buffered 쓰지말고 풀어보자...
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = 10;// 총 10개의 테스트 케이스가 주어진다.
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st;
			LinkedList<Integer> list = new LinkedList<>();
			bw.write("#");
			bw.write(String.valueOf(tc));

			int originLen = Integer.parseInt(br.readLine());// 원본 암호문 길이
			st = new StringTokenizer(br.readLine(), " ");// 원본 암호문 받아서 공백기준으로 나눠둠
			for (int i = 0; i < originLen; i++) // 원본 암호문 리스트 생성 list
				list.add(Integer.parseInt(st.nextToken()));

			int cmdCount = Integer.parseInt(br.readLine());// 명렁어 개수 cmdCount

			String cmdLine = br.readLine();// 한줄로된 명령어를 입력받고
			String[] cmd = cmdLine.split("I");// I를 기준으로 cmd배열에 담음 //1 5 400905 139831 966064 336948 119288 이런식으로 배열에
												// 담긴다.

			for (int i = 1; i <= cmdCount; i++) {// cmd의 0번인덱스에는 " "값이 들어오고 그 뒤에부터 값이 차있어서 1부터 cmdCount까지 반복
				st = new StringTokenizer(cmd[i], " ");
				int position = Integer.parseInt(st.nextToken());// 새로 삽입할 위치 x
				int insertCount = Integer.parseInt(st.nextToken());// 몇개를 새로 넣을지 y
				for (int j = 0; j < insertCount; j++) { // y개수만큼 add해준다.
					list.add(position + j, Integer.parseInt(st.nextToken()));
				}
			}
			for (int i = 0; i < 10; i++) {// 수정된 암호문의 처음 10개 항을 출력한다.
				bw.write(" ");
				bw.write(String.valueOf(list.pop()));// 리스트를 빼면서 출력
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
}
