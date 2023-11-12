import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        탑의 수 N : 1 ~ 500,000
        탑들의 높이 : 1 ~ 1억

        스택사용하면 될듯하다
        맨 끝 인덱스 stack에 넣기 Integer[2] 값, 인덱스위치
        for문 맨끝-1~맨앞 순회
        ifpeek()값보다 높은경우
            while(peek보다높으면)
                pop인덱스위치에 현재for인덱스위치+1(시작탑번호가 0이아닌 1이므로 +1)

        for 값,인덱스 스택에 push
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tower = new int[N];
        for (int i = 0; i < N; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer[]> stack = new Stack<>();
        stack.add(new Integer[]{tower[N - 1], N - 1});
        for (int i = N - 2; 0 <= i; i--) {
            if (!stack.isEmpty() && stack.peek()[0] <= tower[i]) {
                while (!stack.isEmpty() && stack.peek()[0] <= tower[i]) {
                    Integer[] pop = stack.pop();
                    answer[pop[1]] = i + 1;
                }
            }
            stack.push(new Integer[]{tower[i], i});

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.print(sb);


    }
}