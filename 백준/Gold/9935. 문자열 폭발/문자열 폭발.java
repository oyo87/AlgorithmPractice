import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            문자열의 길이 : 1~1,000,000
            폭발문자열 길이 : 1~36
            문자열은 알파벳, 숫자로만 구성

            스택사용
            시간초과.. 줄이기 위해
            StringBuilder reverse대신 for로 앞에서부터.

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (bomb.length() <= stack.size()) {
                int count = 0;
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) == bomb.charAt(j))
                        count++;

                    if (count == bomb.length())
                        for (int k = 0; k < bomb.length(); k++)
                            stack.pop();
                }
            }
        }

        if (stack.isEmpty())
            System.out.print("FRULA");
        StringBuilder sb = new StringBuilder();
        for (char c : stack)
            sb.append(c);
        System.out.print(sb);

//        남은 문자열 뺴주고 리버스
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//        sb.reverse();


    }
}