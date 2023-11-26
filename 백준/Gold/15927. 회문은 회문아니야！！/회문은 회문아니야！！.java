import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        주어진 문자열의 길이 : 1~50만

        완탐 불가

        if 문자열 자체가 회문
            if문자열전체가 같은글자
                -1
            else
                문자열길이-1
        else
            문자열길이

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        String reverse = sb.reverse().toString();
        sb.reverse();

        if (sb.toString().equals(reverse)) {
            char c = sb.charAt(0);
            for (int i = 1; i < sb.length(); i++) {
                if (sb.charAt(i) != c) {
                    System.out.print(sb.length() - 1);
                    return;
                }
            }
            System.out.print(-1);
        } else {
            System.out.print(sb.length());
        }

    }
}