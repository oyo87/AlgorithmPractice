import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        /*
        도시의 수 N : 200이하
        여행 계획에 속한 도시들의 수 M : 1000이하

        사이클을 이루는지 확인하기
        유니온 파인드로 접근
        여행계획 주어진 도시들의 부모가 같을경우 여행가능

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        //부모배열 init
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {//1이면 연결된 경우
                    union(i + 1, j + 1);
                }
            }
        }

        //방문 순서
        int[] plan = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        //여행 계획대로 가능한지 확인
        int temp = find(plan[0]);
        boolean success = true;
        for (int i = 1; i < M; i++) {
            if (temp != find(plan[i])) {
                success = false;
                break;
            }
        }

        if (success)
            System.out.print("YES");
        else
            System.out.print("NO");
    }

    static int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a < b)
            parent[a] = b;
        else
            parent[b] = a;
    }
}