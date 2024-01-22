import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        /*
            정수의 개수 N : 1~100,000
            a,b의 쌍 M : 1~100,000
            내부 값은 10억 이하

            아직은 어려운 세그먼트트리 연습
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = N;
        while (0 < length) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int startIndex = treeSize / 2 - 1;

        tree = new long[treeSize + 1];//트리 MAX값으로 초기화
        for (int i = 0; i < tree.length; i++)
            tree[i] = Integer.MAX_VALUE;

        for (int i = startIndex + 1; i <= startIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        //tree init
        int index = treeSize - 1;
        while (1 < index) {
            tree[index / 2] = Math.min(tree[index / 2], tree[index]);
            if (tree[index] < tree[index / 2])
                tree[index / 2] = tree[index];
            index--;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start += startIndex;
            end += startIndex;
            answer.append(getMin(start, end)).append("\n");
        }
        System.out.print(answer);

    }

    //start~end 범위 최솟값 구하기
    static long getMin(int start, int end) {
        long Min = Long.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                Min = Math.min(Min, tree[start]);
                start++;
            }
            start /= 2;

            if (end % 2 == 0) {
                Min = Math.min(Min, tree[end]);
                end--;
            }
            end /= 2;
        }
        return Min;
    }
}