import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        //오름차순 정렬한후 앞에서부터 1위,2위,3위 순으로 부여해주고 예상과의 차의 절대값을 누적시킨다.
        long answer = 0;
        int count = 1;
        for (int i = 0; i < N; i++) {
            answer += Math.abs(arr[i] - count);
            count++;
        }
        System.out.println(answer);
    }
}