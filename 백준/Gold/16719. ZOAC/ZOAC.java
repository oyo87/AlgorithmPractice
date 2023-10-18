import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static String str;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /*
        문자열의 길이 : 1~100

        사전순으로 문자열 보여주기

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        visited = new boolean[str.length()];

        search(0, str.length());

        System.out.print(sb);

    }

    static void search(int start, int end) {
        if (end <= start)
            return;

        int index = start;

        for (int i = start; i < end; i++) {
            if (str.charAt(i) < str.charAt(index)) {
                index = i;
            }
        }
        visited[index] = true;
        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                sb.append(str.charAt(i));
            }
        }
        sb.append("\n");

        search(index + 1, end);
        search(start, index);
    }
}