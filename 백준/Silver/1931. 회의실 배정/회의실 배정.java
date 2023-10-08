import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         회의 수 N 1~100,000
         회의실은 한개, 겹치지 않게 사용 가능한 최대 회의의 수
         */
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        //끝나는시간 오름차순, 끝나는 시간 같다면 시작시간 오름차순
        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int answer = 0;
        int now = 0;
        for (int i = 0; i < N; i++) {
            if (time[i][0] == time[i][1] && now <= time[i][0]) {//시작, 끝 같은경우
                now = time[i][0];
                answer++;
                continue;
            }

            if (now <= time[i][0]) {
                now = time[i][1];
                answer++;
            }
        }

        System.out.print(answer);


    }
}