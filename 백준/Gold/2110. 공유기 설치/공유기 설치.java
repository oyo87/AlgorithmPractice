import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            집의 개수 N : 2~200,000
            공유기 개수 C : 2~N
            집의 좌표 : 0 ~ 1,000,000,000


            공유기 간격을 몇으로 했을때 최대 설치가능개수인지 찾아보기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] house = new int[N];
        for (int i = 0; i < N; i++)
            house[i] = Integer.parseInt(br.readLine());

        Arrays.sort(house);

        int answer = 0;

        int left = 1;//최소거리
        int right = house[N - 1] - house[0]; //최대거리
        while (left <= right) {
            int mid = (left + right) / 2;
            int start = house[0];
            int count = 1;

            for (int i = 1; i < N; i++) {
                int dist = house[i] - start;
                if (mid <= dist) {
                    count++;
                    start = house[i];
                }
            }

            if (C <= count) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);

    }
}