import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); // 문자열
        int q = Integer.parseInt(br.readLine()); //질문의 수
        int[][] sum = new int[str.length()][26];//누적합 배열, [인덱스][알파벳]
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int answer = 0;
        int alphabet;

        sum[0][str.charAt(0) - 'a']++; // 첫번째글자 초기값
        for (int i = 1; i < sum.length; i++) { // 누적합 넣어주기
            alphabet = str.charAt(i) - 'a'; // 찾을 알파벳

            for (int j = 0; j < 26; j++) {
                sum[i][j] = sum[i - 1][j];
            }
            sum[i][alphabet]++;

        }

        for (int tc = 0; tc < q; tc++) {
            st = new StringTokenizer(br.readLine());

            int target = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == 0) {
                answer = (sum[end][target]);
            } else {
                answer = sum[end][target] - sum[start - 1][target];
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);

    }
}