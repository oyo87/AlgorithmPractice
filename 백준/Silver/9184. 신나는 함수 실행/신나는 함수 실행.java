import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
	    -50 <= a,b,c <= 50
	    이므로 dp[101][101][101]만들어서 dp적용
	    모두 50이하는 1, 모두 70초과는 dp[70][70][70] ... 문제예시대로 구현후 출력
	    */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][][] dp = new int[101][101][101];

        init(dp);

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && a==b && a==c)
                break;

            if(a <= 0 || b <= 0 || c <= 0)
                sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(1).append("\n");
            else if(20 < a || 20 < b || 20 < c)
                sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(dp[70][70][70]).append("\n");
            else
                sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(dp[a+50][b+50][c+50]).append("\n");
        }
        System.out.print(sb);
        return ;
    }

    static void init(int[][][] dp){
        for(int i=0; i< 101; i++){
            for(int j=0; j< 101; j++){
                for(int k=0; k < 101; k++){
                    dp[i][j][k] = 1;
                }
            }
        }
        for(int i=51; i<=70; i++){
            for(int j=51; j<=70; j++){
                for(int k=51; k<=70; k++){
                    if(i<j && j<k){
                        dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
                    }
                    else{
                        dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
                    }
                }
            }
        }
        for(int i=71; i<=100; i++){
            for(int j=71; j<=100; j++){
                for(int k=71; k<=100; k++){
                    dp[i][j][k] = dp[70][70][70];
                }
            }
        }
    }
}