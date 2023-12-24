import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        나무수 N : 1~1,000,000
        집으로가져갈 나무의길이M : 1~2,000,000,000
        나무의 높이 0~1,000,000,000

        절단기에 설정할 수 있는 높이의 최댓값 출력하기

        이분탐색으로 진행
        나무높이가 10억까지되므로 계산할때 long 사용하기.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int left = 0;
        int right = tree[N - 1];

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;//절단기높이

            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (mid < tree[i])
                    sum += tree[i] - mid;
            }

            if (sum < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }


        System.out.print(answer);


    }
}