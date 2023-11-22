import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        구슬의 개수 정수 N 홀수 : 1~99
        저울에 올려 본 쌍의 개수 M : 1~N(N-1)/2

        무게의 중간이 절대로 될수 없는것 찾기

        [큰][작] = 1
        [작][큰] = -1

        큰구슬 || 작은구슬 개수가 n/2+1(중간)이상인경우 중간 될수없음

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            arr[heavy][light] = 1;
            arr[light][heavy] = -1;
        }

        //플로이드-워셜
        for (int k = 1; k <= N; k++) {//경유지
            for (int i = 1; i <= N; i++) {//출발
                if (k == i)
                    continue;
                for (int j = 1; j <= N; j++) {//도착
                    if (k == j || i == j)
                        continue;

                    if (arr[j][k] != 0 && arr[i][k] == arr[k][j]) {
                        arr[i][j] = arr[i][k];
                    }
                }
            }
        }

        int[] heavy = new int[N + 1];
        int[] light = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 1)
                    heavy[i]++;
                if (arr[i][j] == -1)
                    light[i]++;
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (N / 2 + 1 <= heavy[i])
                answer++;
            if(N / 2 + 1 <= light[i])
                answer++;
        }
        System.out.print(answer);


    }
}