import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            테스트 케이스 T 자연수
            날의 수 N : 2~1,000,000
            날별 주기 N : 10,000이하

            주식 하나사기, 원하는만큼 팔기, 가만히 있기

            3 5 10 7 8 이면

            3 5 7 10 8

            3 10 7 5 9

            맨뒤에서 시작
            max값 끝값으로 저장
                --진행하면서 max값보다 작으면 answer에 차이만큼 증가
                끝값이상이면 max값 현재값으로 저장

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] price;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            price = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            int max = price[N - 1];
            long answer = 0;
            for (int i = N - 2; 0 <= i; i--) {
                if (price[i] < max){
                    answer += max-price[i];
                }else{
                    max = price[i];
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb);


    }
}