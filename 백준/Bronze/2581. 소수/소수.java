import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //N이상 M이하의 소수 찾고 소수의합, 최솟값 출력 소수없을시 -1출력
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[M + 1];
        visited[1] = true;
        for (int i = 2; i <= M; i++) {
            if (visited[i]) {
                continue;
            }
            for (int j = 2 * i; j <= M; j += i) { //소수가 아니면 true
                visited[j] = true;
            }
        }

        int min = 0;
        int sum = 0;
        boolean check = false; // 범위내에 소수가 있는지 판별. 소수가 있으면 true
        for (int i = N; i <= M; i++) {
            if (!visited[i]) {
                if (!check) {
                    check = true;
                    min = i;
                }
                sum += i;
            }
        }

        if (check) {
            sb.append(sum).append("\n").append(min);
            System.out.println(sb);
        }
        else{
            System.out.println(-1);
        }


    }
}