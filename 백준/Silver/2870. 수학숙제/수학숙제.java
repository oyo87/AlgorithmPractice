import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            종이의 줄의 개수 N : 1~100
            줄의 내용 최대 100글자, 알파벳 소문자와 술자

            숫자부분만 찾아서 pq에 넣기 앞에 0이아닌 숫자의 앞에붙은 0들은 제거

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //String을 숫자형 오름차순으로 정렬
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) == o2.charAt(i))
                        continue;
                    return o1.charAt(i) - o2.charAt(i);
                }
            }
            return o1.length() - o2.length();
        });

        for (int tc = 0; tc < N; tc++) {
            String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {
                //숫자부분만 StirngBuilder에 등록
                int j = i;
                if (isNum(str.charAt(i))) {
                    StringBuilder sb = new StringBuilder();
                    while (j < str.length()) {
                        if (isNum(str.charAt(j))) {
                            sb.append(str.charAt(j));
                        } else
                            break;
                        j++;
                    }

                    //0이아닌 숫자일때 앞의 0 제거
                    removePrefixZero(sb);
                    pq.add(sb.toString());
                }
                if (i < j)
                    i = j - 1;
            }
        }

        StringBuilder answerSb = new StringBuilder();
        while (!pq.isEmpty()) {
            answerSb.append(pq.poll()).append("\n");
        }
        System.out.print(answerSb);
    }

    static void removePrefixZero(StringBuilder sb) {
        while (1 < sb.length() && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
    }

    static boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }
}