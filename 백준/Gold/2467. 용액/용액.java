import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        전체 용액의 수 N : 2~100000
        용액의 특성값 : -10억 ~ 10억
        투포인터 start, end잡고
        start<end 반복해서
        abs(start+end)가 작은값 출력

        투포인터 두번돌려서
        한번은 start+end가 음수면 start++, 양수면 end--
        한번은 음수면 end-- 양수면 start++
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = N - 1;
        int[] answer = new int[3];//더작은값, 큰값, 합
        answer[2] = 2111111111;
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (Math.abs(sum) < answer[2]) {
                answer[0] = arr[start];
                answer[1] = arr[end];
                answer[2] = Math.abs(sum);
            }

            if (0 <= sum)
                start++;
            else
                end--;
        }
        start = 0;
        end = N - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (Math.abs(sum) < answer[2]) {
                answer[0] = arr[start];
                answer[1] = arr[end];
                answer[2] = Math.abs(sum);
            }

            if (0 <= sum)
                end--;
            else
                start++;
        }


        System.out.print(answer[0] + " " + answer[1]);

    }
}