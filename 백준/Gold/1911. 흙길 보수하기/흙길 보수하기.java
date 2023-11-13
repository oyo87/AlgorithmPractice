import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        물웅덩이 N : 1~10,000
        널빤지 L : 1~1,000,000
        웅덩이 위치는 0~ 10억 이하

        입력에서 끝나는 지점에는 웅덩이가 없음 끝나는지점 -1이 진짜 끝나는지점

        웅덩이 [0],[1]기준 오름차순 정렬후
        범위구하기 그리디접근

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] puddle = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            puddle[i][0] = Integer.parseInt(st.nextToken());
            puddle[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(puddle, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int range = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (range < puddle[i][0]) {
                range = puddle[i][0];
            }

            if (range < puddle[i][1]) {
                while (range < puddle[i][1]) {
                    range += L;
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}