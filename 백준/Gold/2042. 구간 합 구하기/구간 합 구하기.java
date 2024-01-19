import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        /*
            수의 개수 N : 1,000,000
            수의 변경이 일어나는 횟수 M : 1~10,000
            구간의 합을 구하는 횟수 K : 1~10,000
            숫자 a,b,c가 주어지고 a가 1인경우 숫자 변경 2인경우 구간합 출력

            입력으로 주어지는 수는 long
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int treeHeight = 0;
        int arrLength = N;
        while (0 < arrLength) {
            arrLength /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int startIndex = treeSize / 2 - 1;

        tree = new long[treeSize + 1];


        //리프노드에 데이터 입력받기
        for (int i = startIndex + 1; i <= startIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        //트리 만들기
        int index = treeSize - 1;
        while (1 < index) {
            tree[index / 2] += tree[index];
            index--;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {//숫자 변경
                change(startIndex + b, c);
            } else {//구간합 출력
                b += startIndex;
                c += startIndex;
                answer.append(sum(b, (int) c)).append("\n");
            }
        }

        System.out.print(answer);

    }

    static long sum(int b, int c) {//b~c 구간합
        long sum = 0;
        while (b <= c) {
            if (b % 2 == 1) {
                sum += tree[b];
                b++;
            }
            if (c % 2 == 0) {
                sum += tree[c];
                c--;
            }
            b /= 2;
            c /= 2;
        }

        return sum;
    }

    static void change(int index, long num) {
        long diff = num - tree[index];
        while (0 < index) {
            tree[index] = tree[index] + diff;
            index /= 2;
        }
    }


}