import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[][] planet;

    static PriorityQueue<Integer[]> edges;

    static int[] parent;

    static long answer = 0;


    public static void main(String[] args) throws IOException {
        /*
            행성의 개수 N : 1~100,000
            행성의 좌표 x,y,z : -1,000,000,000 ~ 1,000,000,000
            총 비용 long 계산

            각 행성의 parent배열 생성
            행성 연결비용 PriorityQueue edges에 저렴한 순서대로 정렬
            while poll 하면서 parent 다를경우 union
            N-1번의 연결 이후 결과값 출력 MST

            ============
            행성별 모든 엣지를 연결하다보니 메모리초과발생 (10만*5만의 엣지)..;
            엣지를 x,y,z로 정렬후 인접한것들만 넣어주게 변경(10만*3의 엣지)

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //planet init
        planet = new int[N][4];//x,y,z,index
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                planet[i][j] = Integer.parseInt(st.nextToken());
            }
            planet[i][3] = i;
        }

        //edges init
        edges = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });//행성1,행성2,연결비용
        for (int i = 0; i < 3; i++) {//x기준 정렬후 edges추가, y기준.. z기준..
            edgesAdd(i);
        }

        //parent init
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        mst();

        System.out.print(answer);
    }

    static void edgesAdd(int sortIndex) {
        Arrays.sort(planet, (o1, o2) -> {
            return o1[sortIndex] - o2[sortIndex];
        });
        for (int i = 0; i < N - 1; i++) {
            int start = planet[i][3];
            int end = planet[i + 1][3];
            int cost = Math.abs(planet[i][sortIndex] - planet[i + 1][sortIndex]);

            edges.add(new Integer[]{start, end, cost});
        }
    }

    static void mst() {
        int count = 0;

        while (count < N - 1) {
            Integer[] poll = edges.poll();
            int start = poll[0];
            int end = poll[1];
            int cost = poll[2];

            if (find(start) != find(end)) {
                union(start, end);
                count++;
                answer += cost;
            }

        }

    }

    static void union(int start, int end) {
        int p1 = find(start);
        int p2 = find(end);

        if (p1 > p2)
            parent[p1] = p2;
        else
            parent[p2] = p1;
    }

    static int find(int planetNumber) {
        if (parent[planetNumber] == planetNumber)
            return planetNumber;
        return parent[planetNumber] = find(parent[planetNumber]);
    }
}