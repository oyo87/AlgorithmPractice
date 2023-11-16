import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        사과나무 개수 N : 1~100,000
        정수 값 : 0~10,000

        높이의 합이 3의 배수
        홀수나무 개수 <= 전체합/3 이면 가능
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int odd = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            sum += height;
            if ((height & 1) == 1) {
                odd++;
            }
        }

        if (sum % 3 == 0 && odd <= sum / 3)
            System.out.print("YES");
        else
            System.out.print("NO");

    }
}