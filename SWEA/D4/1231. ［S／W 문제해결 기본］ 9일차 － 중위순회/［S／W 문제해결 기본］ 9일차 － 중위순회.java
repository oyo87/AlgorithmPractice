import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//입력값으로 노드의 수 입력 받고
//해당 노드, 해당노드의데이터(알파뱃), 왼쪽자식 번호, 오른쪽자식 번호 (자식이 있어야 입력받음)
//트리를 만들고 중위순회를 돌면서 출력을해본다.
public class Solution {
	static boolean[] Inorder(char[] arr, boolean[] visit, int n, StringBuilder sb) {
		if (visit[n] == false) {//왼,중,오 순으로 방문. 만약 현재 위치(중)방문을 안했으면 
			if (n * 2 < arr.length)//왼쪽 자식이 있다면 먼저 들어감
				Inorder(arr, visit, n * 2, sb);
			visit[n] = true;//현재위치 (중) 방문 완료체크
			sb.append(arr[n]);
			if (n * 2 + 1 < arr.length)//오른쪽 방문
				Inorder(arr, visit, n * 2 + 1, sb);
		}
		return visit;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			int N = Integer.parseInt(br.readLine());
			char[] arr = new char[N + 1];
			boolean[] visit = new boolean[N + 1];// 중위순회할때 방문했는지 확인하기 위함
			for (int i = 1; i <= N; i++) {// 노드에 값 채워주기
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				arr[i] = st.nextToken().charAt(0);
			}//노드 값 채워주기
			Inorder(arr, visit, 1, sb);//재귀를 통해 중위순회
			System.out.println(sb);
		}
	}
}
