import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        물이새는곳의 개수 N : 1~1,000
        테이프의 길이 L : 1~1,000
        물이새는곳의 위치 : 1~1,000

        새는 물 위치의 간격 입력받고

        L-1이하이면 커버가능
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = 0;
        int tape = 0;
        for (int i = 0; i < N; i++) {
            if (tape < arr[i]) {
                answer++;
                tape = arr[i];
                tape += L - 1;
            }
        }

        System.out.print(answer);


    }
}