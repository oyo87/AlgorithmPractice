import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        계단수 : 인접한 모든 자리의 차이가 1인 수 ex)45656
        길이가 N인 계단 수 구하기
        N : 1 ~ 100

        길이가 1 : 1 2 3 4 5 6 7 8 9
        마지막수가 0일경우 당므자리는 1만 가능, 9일경우 8만가능
        나머지 수는 -1, +1 두개씩 올수 있음
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        long MOD = 1000000000;

        long[][] dp = new long[N+1][10];
        //init
        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }

        long temp = 0;
        for(int i=2; i<N+1; i++){
            for(int j=0; j<10; j++){
                if(j==0){//0은 1에서만 만들수있음
                    temp = dp[i-1][j+1];
                }
                else if(j==9){//9는 8에서만 만들수있음
                    temp = dp[i-1][j-1];
                }
                else{//이외에는 -1, +1 두군데에서 만들수있음
                    temp = dp[i-1][j-1] + dp[i-1][j+1];
                }
                dp[i][j] = temp % MOD;
            }
        }
        
        long answer = 0;
        for(int i=0; i<10; i++){
            answer += dp[N][i];
        }


        System.out.print(answer % MOD);
    }
}