import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        포도주 잔 개수 1~10,000
        포도주의 양 0~1,000
        연속한 3개 마시기는 불가능.

        3개는 직접 구해주고
        이후는 이전이전,이전,현재 중
        XOO, OXO, OOX 3가지 케이스중 가장 큰것으로 선택하는 dp만들기

        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] dp = new int[n];
        int[] wine = new int[n];
        for(int i=0; i<n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        //적은수 예외처리
        if(n<=3){
            if(n==1){
                answer = wine[0];
            }
            else if(n==2){
                answer = wine[0] + wine[1];

            }else if(n==3){
                answer = Math.max(wine[0] + wine[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));
            }
            System.out.print(answer);
            return ;
        }

        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));

        for(int i=3; i<n; i++){
            //XOO, OXO, OOX 비교
            dp[i] = Math.max(dp[i-3] + wine[i-1] + wine[i], Math.max(dp[i-2] + wine[i], dp[i-1]));
        }

        answer = dp[n-1];
        System.out.print(answer);
    }
}