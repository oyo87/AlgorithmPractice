import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            끊어진 기타줄 개수 N : 1~100
            기타줄 브랜드 개수 M : 1~50
            가격 : 0~1,000
            6개묶음가격, 단일판매가격 주어짐

            기타줄 N개사기위해 필요한 돈의 최솟값은?
            가장 저렴한 6개가격, 단일구매가격 저장

            만약 가장저렴한 6개가격보다 가장저렴한 단일가격*6이 저렴하다면 단일로만 구매
                else
                    N/6개만큼 가장저렴한 6개묶음가격 구매
                    N%6개만큼 가장 저렴한 단일로 구매
                    위값과
                    N/6개+1개만큼 6묶음 가격중 적은값



         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minSix = 1000;
        int minOne = 1000;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            minSix = Math.min(minSix, six);
            minOne = Math.min(minOne, one);
        }

        if (minOne * 6 < minSix)
            minSix = minOne * 6;

        int answer = 0;
        answer += N / 6 * minSix;
        answer += N % 6 * minOne;

        answer = Math.min(answer, (N/6+1) * minSix);

        System.out.print(answer);


    }
}