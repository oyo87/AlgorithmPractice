import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            선을 그은 횟수 N : 1~1,000,000
            선을 그을때 두 점의 위치 x,y : -1,000,000,000 ~ 1,000,000,000 (x<=y)

            정렬을 해보자
            x기준 오름차순, x같으면 y기준 오름차순 정렬
            init
            [0]인덱스 y-x 해주고 y를 max로 지정
            
            for 순회
            x이 max보다 작으면
               x값을 max로 지정
               y값도 max보다 작다면
                y값도 max로지정
            
            answer+= y-x
            max를 y로 갱신하며 순회
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            ;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int answer = arr[0][1] - arr[0][0];
        int max = arr[0][1];
        for (int i = 1; i < N; i++) {
            int x = arr[i][0];
            int y = arr[i][1];

            if (x < max) {
                x = max;

                if (y < max)
                    y = max;
            }

            answer += y - x;

            max = y;
        }

        System.out.print(answer);

    }
}