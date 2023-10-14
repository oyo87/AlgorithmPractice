import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        돌은 1개 or 3개 가져가기 가능
        마지막 돌 가져가면 승리

        돌 개수 N : 1~1000

        홀수면 선

        짝수면 후

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 2)
            System.out.print("CY");
        else {
            if (N % 2 == 1)
                System.out.print("SK");
            else System.out.print("CY");
        }
    }
}