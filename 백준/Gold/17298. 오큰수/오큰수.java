import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();

        //스택 맨위에 있는 인덱스(왼쪽에 있는 요소)와 현재 탐색중인 값(우측 요소)을 비교하여
        //현재탐색중인값이 클경우 오큰수이므로
        // 원래 값 왼쪽에있는요소에 현재 탐색중인값을 넣어줌.
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        
        //오큰수가 없는 값의 인덱스들이 스택에 남아있음
        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
