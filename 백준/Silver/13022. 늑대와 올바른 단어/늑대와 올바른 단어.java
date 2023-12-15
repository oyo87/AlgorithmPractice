import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        /*
            입력 문자열 : w,o,l,f 로만 이루어짐, 길이 50 이하

            길이 짧아서 완탐가능
            앞에서 순차 탐색
            w면 count++ w가 아닌 문자 나올때까지 탐색
            다음에 o가아닌경우 실패
            o,l,f가 동일하게 나와야함

            인덱스 문자열 끝난지점으로 조정

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            int count = checkWord(i, 'w');

            //w가없음
            if (count == 0) {
                impossible();
            }

            //w개수만큼 wolf불가능
            if (str.length() < count * 4 + i) {
                impossible();
            }

            for (int j = 1; j < 4; j++) {
                int startIndex = count * j + i;
                if (j == 1) {
                    if (checkWord(startIndex, 'o') != count)
                        impossible();
                } else if (j == 2) {
                    if (checkWord(startIndex, 'l') != count)
                        impossible();
                } else {
                    if (checkWord(startIndex, 'f') != count)
                        impossible();
                }
            }

            i += count * 4 - 1;

        }
        System.out.print(1);

    }

    static void impossible() {
        System.out.print(0);
        System.exit(0);
    }

    //start시점에서 문자c가 연달아 몇개가 나오는지 리턴
    static int checkWord(int start, char c) {
        int count = 0;
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
            else
                break;
        }
        return count;
    }
}