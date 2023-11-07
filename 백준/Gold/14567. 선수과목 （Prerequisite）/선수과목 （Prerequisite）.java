import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        과목의 수 N : 1~1,000
        선수 조건의 수 M : 0~500,000

        greedy, dp
        dp fill 1

        선수과목 정렬
        선수과목 조건이 주어지면 선수과목에필요한 학기 + 1 한것이 다음 전공과목필요 학기수
        max값적용
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);

        int[][] prerequisite = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            prerequisite[i][0] = Integer.parseInt(st.nextToken());
            prerequisite[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(prerequisite, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        for (int i = 0; i < prerequisite.length; i++) {
            int first = prerequisite[i][0];
            int second = prerequisite[i][1];

            dp[second] = Math.max(dp[second], dp[first] + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dp.length; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.print(sb);

    }
}