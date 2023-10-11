import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        크기 1~100만 수열A의 오동등수 구하기
        원소 값은 1~100만

        오등큰수를 출력하기

        1.입력값 받아 int 배열 저장
        2.answer[]배열 -1로 채워둠
        3.HashMap 등장횟수 세어둠

        입력값 받은 배열, 등장횟수 세어둔 배열, 스택 사용

        값을 stack에 넣음
        다음인덱스
        stack top등장횟수와 현재인덱스의 등장횟수비교
        현재가 더 크다면 stack을 빼서 해당인덱스 값을 현재인덱스 값으로 입력
        아니라면 스택에 넣음 반복
        반복

        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        Map<Integer, Integer> map = new HashMap<>();//등장횟수
        for (int i = 0; i < N; i++) {
            map.put(seq[i], map.getOrDefault(seq[i], 0) + 1);
        }

        Stack<Integer[]> stack = new Stack<>(); //[0] value, [1]index
        stack.push(new Integer[]{seq[0], 0});
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty()) {
                Integer[] peek = stack.peek();

                int peekCount = map.get(peek[0]);
                int indexCount = map.get(seq[i]);
                
                if (indexCount <= peekCount)
                    break;

                answer[peek[1]] = seq[i];
                stack.pop();

            }

            stack.push(new Integer[]{seq[i], i});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.print(sb);


    }
}