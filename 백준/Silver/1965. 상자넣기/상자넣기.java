import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            상자의 개수 n : 1~1,000
            상자의 크기 : 1~1,000

            넣을 수 있는 최대의 상자 개수출력
            dp이용해서 현재 상자에 넣을수있는 최대개수저장
            n개수 1000개이므로 2중for문으로 탐색진행


         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] boxSize = new int[N];
        for (int i = 0; i < N; i++) {
            boxSize[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (boxSize[j] < boxSize[i]) {//뒷상자가 더 크면 갱신
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);

    }
}