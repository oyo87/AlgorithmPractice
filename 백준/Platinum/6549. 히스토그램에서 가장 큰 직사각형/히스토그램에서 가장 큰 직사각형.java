import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static long answer;

    public static void main(String[] args) throws IOException {
        /*
        직사각형의 수 n : 1~100,00
        높이 h = 0~1,000,000,000 10억

        long계산
        왼->오른쪽가면서 증가하는 부분수열 넓이 계산
        오 -> 왼 가면서(배열뒤집어서) 증가하는 부분수열 넓이 계산

        가장큰값을 결과출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0)
                break;

            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            answer = arr[0];

            //정방향 넓이, 역방향 넓이
            long[] temp1;
            long[] temp2;
            temp1 = getArea();
            arrReverse();
            temp2 = getArea();

            for (int i = 0; i < N; i++) {
                //넓이계산, 양방향 더하면서 본인칸은 두번들어가므로 -1해줌
                long tempAnswer = (temp1[i] + temp2[N - 1 - i] - 1) * arr[N - 1 - i];

                answer = Math.max(answer, tempAnswer);
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb);

    }

    static void arrReverse() {
        for (int i = 0; i < N / 2; i++) {
            int temp = arr[i];

            arr[i] = arr[N - 1 - i];
            arr[N - 1 - i] = temp;
        }
    }

    static long[] getArea() {
        long[] increase = new long[N];
        Stack<Integer[]> stack = new Stack<>();
        //증가하는 순열 길이 구하기
        for (int i = 0; i < N; i++) {
            int now = arr[i];

            if (stack.isEmpty() || stack.peek()[0] <= now) {
                stack.push(new Integer[]{now, i});
                continue;
            }

            while (!stack.isEmpty() && now < stack.peek()[0]) {
                Integer[] pop = stack.pop();
                increase[pop[1]] += i - pop[1];
            }
            i--;


        }
        while (!stack.isEmpty()) {
            Integer[] pop = stack.pop();
            increase[pop[1]] += N - pop[1];
        }

        return increase;

    }
}