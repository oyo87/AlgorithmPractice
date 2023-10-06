import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int M = 1000000;

    public static void main(String[] args) throws IOException {
        /*
        골드바흐 파티션 구하기
        100개의 케이스, N은 2~1000000

        소수를 구하고
        구한 소수를 이용해서 골드바흐 파티션 개수 찾기
         */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] prime = new boolean[M + 1];
        getPrime(prime);

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int answer = 0;
            int target = Integer.parseInt(br.readLine());
            for (int i = 2; i <= target / 2; i++) {
                if (prime[i] && prime[target - i])
                    answer++;
            }
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static void getPrime(boolean[] prime) {
        for (int i = 2; i < prime.length; i++)
            prime[i] = true;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            if (prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}