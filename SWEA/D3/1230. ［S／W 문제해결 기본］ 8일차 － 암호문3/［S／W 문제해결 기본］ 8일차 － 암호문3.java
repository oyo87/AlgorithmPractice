import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

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
			char[] cmdSequence = new char[cmdCount]; // I || D || A값이 나온다면 나온 순서대로 배열에 저장해둠
			int cmdSequenceIndex = 0;
			for (int i = 0; i < cmdLine.length(); i++) {
				if (cmdLine.charAt(i) == 'I' || cmdLine.charAt(i) == 'D' || cmdLine.charAt(i) == 'A')
					cmdSequence[cmdSequenceIndex++] = cmdLine.charAt(i);
			}
			String[] cmd = cmdLine.split("I|D|A");// I/D/A를 기준으로 자르고 cmd배열에 담음 //1 5 400905 139831 966064 336948 119288
													// 이런식으로 배열에
													// 담긴다.

			cmdSequenceIndex = 0;// while문을 위한 재 초기화
			int cmdIndex = 1;
			while (cmdSequenceIndex < cmdCount) {
				st = new StringTokenizer(cmd[cmdIndex++]);
				if (cmdSequence[cmdSequenceIndex] == 'I') {// Insert인경우
					int position = Integer.parseInt(st.nextToken());// 새로 삽입할 위치 x
					int insertCount = Integer.parseInt(st.nextToken());// 몇개를 새로 넣을지 y
					for (int j = 0; j < insertCount; j++) { // y개수만큼 add해준다.
						list.add(position + j, Integer.parseInt(st.nextToken()));
					}
				} else if (cmdSequence[cmdSequenceIndex] == 'D') {// Delete인경우
					int position = Integer.parseInt(st.nextToken());// 제거 시작할위치 x
					int deleteCount = Integer.parseInt(st.nextToken());// 몇개를 제거할지 y
					for (int j = 0; j < deleteCount; j++) { // y개수만큼 제거 해준다.
						list.remove(position);
					}
				} else if (cmdSequence[cmdSequenceIndex] == 'A') {// Add인경우 else로만 해도 가능은하다
					int addCount = Integer.parseInt(st.nextToken());// 추가할 개수
					for (int j = 0; j < addCount; j++) { // y개수만큼 제거 해준다.
						list.addLast(Integer.parseInt(st.nextToken()));// 덧붙일 숫자들 받아서 추가
					}
				}

				cmdSequenceIndex++;
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