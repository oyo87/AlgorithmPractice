import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        마을개수 N : 1~100,000
        마을번호 : -10억 ~ 10억
        사람 수 : 1~10억
        
        수학?
        중간값을 구하고 가장 작게나온 마을부터시작해서 인원이 중간값이상인지점에 설치
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] village = new int[N][2];//[0]마을번호, [1]인원수
        long citizen = 0;//전체인원
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            village[i][0] = Integer.parseInt(st.nextToken());
            village[i][1] = Integer.parseInt(st.nextToken());

            citizen += village[i][1];
        }
        Arrays.sort(village, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        long temp = 0;//탐색위치까지의 인원수
        int answer = 0;
        for (int i = 0; i < N; i++) {
            temp += village[i][1];
            if ((citizen + 1) / 2 <= temp) {
                answer = village[i][0];
                break;
            }
        }

        System.out.print(answer);
    }
}