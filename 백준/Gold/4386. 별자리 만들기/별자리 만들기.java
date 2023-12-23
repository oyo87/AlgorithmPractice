import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;

    static PriorityQueue<Double[]> pq;

    static int[] parent;

    static double answer = 0;

    public static void main(String[] args) throws IOException {
        /*
            별의 개수 n : 1~100
            별의 x,y좌표 : 1~1,000 최대 소수점 둘째자리

            MST 연결하기 비용은 두 별 사이의 거리 : sqrt((x값차)^2+(y값차)^2)

            별 위치정보 받고
            모든 별의 간선정보(거리)입력 n:100개이므로 모든경우 가능

            거리짧은순으로 pq, n-1개의 엣지 mst 연결
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        double[][] stars = new double[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        pq = new PriorityQueue<>((o1, o2) -> {
            return (int) (o1[2] - o2[2]);
        });
        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (i == j)
                    continue;

                double cost = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                pq.add(new Double[]{(double) i, (double) j, cost});
                pq.add(new Double[]{(double) j, (double) i, cost});
            }
        }

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        mst();

        answer = Math.round(answer * 100);
        System.out.print(answer / 100);

    }

    static void mst() {
        int count = 0;

        while (count < n - 1) {
            Double[] poll = pq.poll();

            int start = poll[0].intValue();
            int end = poll[1].intValue();
            double cost = poll[2];

            if (find(start) != find(end)) {
                union(start, end);
                count++;
                answer += cost;
            }


        }
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

    static int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
}