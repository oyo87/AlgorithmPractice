import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //인접행렬 플로이드워셜
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());//도시의수
        int m = Integer.parseInt(br.readLine());//버스의수
        int[][] answer = new int[n + 1][n + 1];
        int INF = 1000000000;
        for (int i = 0; i < answer.length; i++) { //결과배열 초기화
            for (int j = 0; j < answer.length; j++) {
                if (i == j)
                    answer[i][j] = 0;
                else
                    answer[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            answer[start][end] = Math.min(answer[start][end], cost);
        }

        //플로이드워셜
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    answer[i][j] = Math.min(answer[i][j], answer[i][k] + answer[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(answer[i][j] == INF)//갈수없는경우
                    sb.append(0).append(" ");
                else
                    sb.append(answer[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1); //개행전 공백제거
            sb.append("\n");
        }
        System.out.print(sb);

    }
}