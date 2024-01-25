import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            N : 1~100

            i번째줄일때 n-i개의 공백, i개의 *을 찍는다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                sb.append(" ");
            }
            for (int j = N - i; j < N; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.print(sb);


    }
}