import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] parent;


    public static void main(String[] args) throws IOException {
        /*
            점의 개수 n : 3~500,000
            진행된 차례의 수 m : 3~1,000,000

            사이클이 처음으로 만들어진 차례의 번호를 출력

            사이클이 만들어졌는지 확인하기->
            유니온파인드를 진행(작은수기준 union) 이미 같은 그룹끼리 union이 진행된다면 사이클 생성이므로 출력후 return하면 될듯하다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int turn = 0; turn < m; turn++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                System.out.print(turn + 1);
                return;
            } else {
                union(a, b);
            }


        }

        System.out.print(0);

    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pb < pa) {
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        parent[pb] = pa;
    }

    static int find(int num) {
        if (parent[num] == num)
            return num;
        return parent[num] = find(parent[num]);
    }
}