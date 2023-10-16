import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        스트링 길이는 150개 이하

        식별할 엔진소리패턴 : (100~1~ | 01)~

        정규표현식 없이 구현하다가 막혔는데 구현으로도 도전해볼만해보인다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sound = br.readLine();

        if (sound.matches("(100+1+|01)+")) {
            System.out.print("SUBMARINE");
        } else {
            System.out.print("NOISE");
        }


    }
}