import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         수열 길이 N : 10~100,000
         부분합 만족 조건 S : 0~100,000,000
         원소값 10,000

         투포인터 잡고 0,0에서 시작
         s미만이면 right++, s이상이면 left++ 하며 탐색
         right가 length벗어나면 탐색종료
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());


        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (S == 0) {
            System.out.print(1);
            return;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int length = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < arr.length) {
            if (sum < S) {
                sum += arr[right++];
                length++;
            } else {
                while (S <= sum) {
                    minLength = Math.min(minLength, length);
                    sum -= arr[left++];
                    length--;
                }
            }
        }

        while (left < right && S <= sum) {
            minLength = Math.min(minLength, length);
            sum -= arr[left++];
            length--;
        }

        if (S <= sum)
            minLength = Math.min(minLength, length);

        if (minLength == Integer.MAX_VALUE) {
            System.out.print(0);
        } else {
            System.out.print(minLength);
        }


    }
}