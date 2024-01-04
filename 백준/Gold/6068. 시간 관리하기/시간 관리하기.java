import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            일의 개수 N : 1~1,000
            일 완성될때 필요한 시간 T_i : 1~1,000
            끝내야하는시간 : 1~1,000,000

            가장 늦게 일어나도 되는 시간을 출력
            제시간에 일 못끝내면 -1

            빨리끝내야하는작업부터 정렬한다. 예제의경우
            3 5
            8 14
            1 16
            5 20

            0초부터 시작하면 3초에 1번완료 2초여유
            11초에 2번완료 3초여유
            12초에 3번완료 4초여유
            17초에 5번완료 3여유
            이중 가장 작은 여유시간인 2초가 정답
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] jobs = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            jobs[i][0] = Integer.parseInt(st.nextToken());
            jobs[i][1] = Integer.parseInt(st.nextToken());
        }

        //빨리끝내야하는 작업 우선 정렬
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int answer = Integer.MAX_VALUE;//가장 작은 여유시간이 정답
        int time = 0;
        for (int i = 0; i < N; i++) {
            //작업시간 더하기
            time += jobs[i][0];

            //정해진 시간내에 마칠수있는가? 못마치면 -1
            if (jobs[i][1] < time) {
                answer = -1;
                break;
            }

            answer = Math.min(answer, jobs[i][1] - time);

        }
        System.out.print(answer);


    }
}