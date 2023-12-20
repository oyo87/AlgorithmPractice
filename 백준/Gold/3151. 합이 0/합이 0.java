import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        /*
            학생수 N : 1 ~ 10,000
            코딩실력 A : -10,000 ~ 10,000
            합이 0이되는 3인조 최대한 많이 만들기.

            코딩실력arr sort
            이중포문으로 두개선택이후 이분탐색으로 합을 0으로만드는개수 아서 answer에 합산

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long answer = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                //합이 0이되게하는 i,j,k인덱스 찾기
                int target = -1 * (arr[i] + arr[j]);//0이되게하는값

                //타겟이 여러개일경우 타겟의 시작지점, end지점 계산
                int targetStart = getStart(j + 1, N, target);

                int targetEnd = getEnd(j + 1, N, target);

                answer += (targetEnd - targetStart);
            }
        }

        System.out.print(answer);
    }

    static int getStart(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (target <= arr[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    static int getEnd(int left, int right, int target) {
        while (left < right) {

            int mid = (left + right) / 2;

            if (target < arr[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}