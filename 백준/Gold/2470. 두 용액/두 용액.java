import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        /*
         * 배열받고 오름차순 정렬하기
         * 왼쪽포인터 오른쪽포인터 잡고
         * 둘다 더함
         * 0-더해서 나온 첫값의 절대값 min에 저장 min = 2111111111
         * min ==0이면 마무리
         * 아니라면 0-더해서나온값 보고
         * 음수면 왼쪽포인터 옮기고 양수면 우측포인터 옮기기
         * 둘이 인덱스가 같아질경우 종료
         * */
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int min = 2111111111; //10억으로했다가 오류발생
        int left = 0;
        int right = N - 1;
        int[] answer = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) { //차이0발견되면 즉시 종료
                answer[0] = arr[left];
                answer[1] = arr[right];
                break;
            }
            int dist = 0 - sum;
            if (Math.abs(dist) < min) {//갱신
                answer[0] = arr[left];
                answer[1] = arr[right];
                min = Math.abs(dist);
            }

            if (0 < dist)
                left++;
            else
                right--;
        }
        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.println(sb);
    }
}