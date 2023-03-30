import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//센서
        int K = Integer.parseInt(br.readLine());//집중국

        if (N <= K) { //집중국이 더 많으면 0리턴, 없이했더니 Null Exception 발생
            System.out.println(0);
            return;
        }

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Integer[] dist = new Integer[N - 1];// 다음 센서까지의 거리 차이
        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Math.abs(arr[i] - arr[i + 1]); // dist[i] = [i]와 [i+1]의 거리 차
            answer += dist[i]; //모든 거리를 더한후에 밑에서 빼줌
        }
        Arrays.sort(dist, Collections.reverseOrder());
        for (int i = 0; i < K - 1; i++) {
            answer -= dist[i]; // 가장 큰거리부터 빼줌
        }
        System.out.println(answer);
    }
}