import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            수열크기 N : 1~1,000,000
            수열 내부 값 : -10억~10억

            이전에 푼 N크기 100만의 가장 긴 증가하는 부분수열은 이분탐색, 치환 을 이용해서 길이만 구했었는데
            정답이 될 수 있는 가장 긴 증가하는 부분 수열 출력까지 진행해보기
            방법이 쉽게 떠오르지 않아 해설을 참고하여 진행했다. 인덱스를 관리하며 탐색.

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] indexArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            int now = seq[i];

            if (list.get(list.size() - 1) < now) {//리스트의 마지막보다 현재 탐색중인 순열이 큼
                list.add(now);
                indexArr[i] = list.size() - 1;
            } else {
                int left = 1;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;

                    if (now <= list.get(mid))
                        right = mid;
                    else
                        left = mid + 1;
                }
                list.set(right, now);
                indexArr[i] = right;
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(list.size() - 1).append("\n");

        Stack<Integer> stack = new Stack<>();
        int index = list.size() - 1;
        for (int i = N - 1; 0 <= i; i--) {
            if (indexArr[i] == index) {
                index--;
                stack.push(seq[i]);
            }
        }

        while (!stack.isEmpty())
            answer.append(stack.pop() + " ");

        System.out.print(answer);


    }
}