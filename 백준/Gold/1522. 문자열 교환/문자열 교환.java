import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        문자열의 길이는 최대 1,000

        a의 개수 체크

        문자열은 원형으로 이어져있으니 a를 늘려줌

        a의개수만큼 슬라이딩 윈도우 진행하면서 b의개수체크
        min(b)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        int aCount = 0;//전체 a의 개수

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aCount++;
            }
        }
        sb.append(str.substring(0, aCount));//ex) abab면 ababab

        int b = 0;
        for (int i = 0; i < aCount; i++) {
            if (str.charAt(i) == 'b')
                b++;
        }

        int min = b;
        for (int i = 1; i < str.length(); i++) {
            if (sb.charAt(i - 1) == 'b')
                b--;
            if (sb.charAt(i + aCount - 1) == 'b')
                b++;

            min = Math.min(min, b);
        }

        System.out.print(min);

    }
}