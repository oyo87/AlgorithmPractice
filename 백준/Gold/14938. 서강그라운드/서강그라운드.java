import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            지역의 개수 n : 1~100
            예은이의 수색범위 m : 1~15
            길의 개수 r : 1~100
            각 구역 아이템수 t : 1~30
            길의 길이 l : 1~15

            경우의 수가 적다. 플로이드 워셜

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++)
            item[i] = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n + 1][n + 1];
        int INF = 1000000000;
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            dist[start][end] = length;
            dist[end][start] = length;
        }

        for (int k = 1; k < n + 1; k++) {//경유
            for (int i = 1; i < n + 1; i++) {//출발
                if (i == k)
                    continue;
                for (int j = 1; j < n + 1; j++) {//도착
                    if (i == j) {
                        dist[i][j] = 0;
                    } else if (k == j)
                        continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int[] getItem = new int[n + 1];
        int answer = 0;
        //answer구하기
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dist[i][j] <= m) {//거리가 수색범위내라면
                    getItem[i] += item[j];//아이템 획득
                }
            }
            answer = Math.max(answer, getItem[i]);
        }

        System.out.print(answer);


    }
}