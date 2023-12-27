import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            고객들의 수 n : 1~100,000
            고객들의 위치 x,y : -1,000,000 ~ 1,000,000

            거리를 최소로 하기
            각 좌표의 중앙값에 편의점 설치하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//문제에 n입력뒤에 개행이있어서 br대신 st로 받아봄

        int[] xArr = new int[n];
        int[] yArr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xArr);
        Arrays.sort(yArr);

        int midX = xArr[n / 2];
        int midY = yArr[n / 2];

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Math.abs(xArr[i] - midX);
            answer += Math.abs(yArr[i] - midY);
        }

        System.out.print(answer);

    }
}