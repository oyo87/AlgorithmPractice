import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            Longest Common Subsequence 최장 공통 부분 수열 구하기
            알파벳 대문자 1~1000자 두개가 주어짐 0.1초제한
            
            dp배열 만든후 이중for문 탐색하며
            같은 글자 나온다면 [i-1][j-1] + 1
            같지 않으면 max([i-1][j], [i][j-1])
            
            마지막 배열값이 최장 공통 수열
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int[][] dp = new int[A.length() + 1][B.length() + 1];
        char a;
        char b;
        for(int i=1; i<A.length()+1; i++){
               a = A.charAt(i-1);
            for(int j=1; j < B.length()+1; j++){
                b = B.charAt(j-1);
                if(a==b){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.print(dp[A.length()][B.length()]);
    }
}