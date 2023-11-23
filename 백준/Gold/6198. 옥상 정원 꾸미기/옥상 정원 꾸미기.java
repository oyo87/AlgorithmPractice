import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        빌딩의 개수 N : 1~80,000
        빌딩의 높이 h = 1~ 1,000,000,000

        빌딩별 높이 입력받고

        Stack<Integer[]> [0]높이, [1]index
        1번빌딩 스택 푸쉬

        2~for순회
        현재 빌딩이 stack.peek()보다 더 높거나 같으면
        while(peek()높이가 더 낮거나 같으면)
            peek()인덱스는 현재인덱스-1 - peek()의인덱스 만큼 볼수있음
        마지막까지 진행

        현재인덱스 n이라고가정하고 남아있는 스택 정리
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] buildingHeight = new int[N];
        for (int i = 0; i < N; i++) {
            buildingHeight[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer[]> stack = new Stack<>();
        int[] benchMarking = new int[N];
        stack.add(new Integer[]{buildingHeight[0], 0});
        for (int i = 1; i < N; i++) {
            int height = buildingHeight[i];
            if (stack.peek()[0] <= height) {
                while (!stack.isEmpty() && stack.peek()[0] <= height) {
                    int popIndex = stack.pop()[1];

                    benchMarking[popIndex] = i - 1 - popIndex;
                }
            }
            stack.push(new Integer[]{buildingHeight[i], i});
        }

        while (!stack.isEmpty()) {
            int popIndex = stack.pop()[1];

            benchMarking[popIndex] = N - 1 - popIndex;
        }

        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += benchMarking[i];
        }

        System.out.print(answer);


    }
}