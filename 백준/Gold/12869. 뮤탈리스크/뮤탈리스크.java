import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        SCV의 수 N : 1~3
        SCV의 체력 : 1~60

        그리디 불가능 ex
        19 9 9
        10 6 8
        1 5 5
        0 0 2
        0 0 0

        19 9 9
        18 6 0
        9 3 0
        0 0 0

        dp로도 접근가능, scv경우의수가 3, hp가 60, 발생하는 경우의수가 6작은 값이라 bfs를 활용해서 풀이.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] hp = new Integer[4];
        Arrays.fill(hp, 0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }
        hp[3] = 0;//attackCountr

        Queue<Integer[]> q = new LinkedList<>();
        q.add(hp);
        int answer = Integer.MAX_VALUE;
        boolean[][][] visited = new boolean[61][61][61];
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            // scv1,2,3,공격횟수

            int survive = 0;
            for (int i = 0; i < 3; i++) {
                if (0 < poll[i]) {
                    survive++;
                } else {
                    poll[i] = 0;
                }
            }
            sort(poll);
            int one = poll[0];
            int two = poll[1];
            int three = poll[2];
            int attack = poll[3];

            if (visited[one][two][three])
                continue;
            visited[one][two][three] = true;

            if (survive == 0) {
                answer = Math.min(answer, attack);
                break;
            }

            q.add(new Integer[]{one - 9, two - 3, three - 1, attack + 1});
            q.add(new Integer[]{one - 9, two - 1, three - 3, attack + 1});
            q.add(new Integer[]{one - 3, two - 9, three - 1, attack + 1});
            q.add(new Integer[]{one - 1, two - 9, three - 3, attack + 1});
            q.add(new Integer[]{one - 3, two - 1, three - 9, attack + 1});
            q.add(new Integer[]{one - 1, two - 3, three - 9, attack + 1});
        }

        System.out.print(answer);
    }

    static void sort(Integer[] arr) {
        //[0],[1],[2] 정렬
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}