import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        문자열 S의 길이 : 1~49
        문자열 T의 길이 : 2~50
        S길이 < T길이

        S에서 T 불가능,
        S에서 T절반, T에서 S절반 접근했더니 메모리초과발생
        거꾸로 T에서 S로 만들기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        Queue<String> q = new LinkedList<>();
        q.add(T);

        StringBuilder sb;
        int answer = 0;
        String str;
        while (!q.isEmpty()) {
            str = q.poll();

            if (str.length() == S.length()) {
                if (str.equals(S)) {
                    answer = 1;
                    break;
                }
                continue;
            }

            sb = new StringBuilder(str);
            if (sb.charAt(sb.length() - 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
                q.add(sb.toString());
                sb.append("A");
            }
            if (sb.charAt(0) == 'B') {
                sb.reverse();
                sb.deleteCharAt(sb.length() - 1);
                q.add(sb.toString());
            }

        }

        System.out.print(answer);


    }
}