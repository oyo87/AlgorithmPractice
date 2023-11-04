import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int[][] minCost;
    static StringBuilder sb = new StringBuilder();
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        /*
        동굴의 크기 N : 2~125
        도둑루피의 값 K : 0~9

        맵배열, 금액배열 만들고
        BFS 탐색하면서 중복된곳에 방문할때는 금액배열의 최소값 갱신
        새로운곳 탐색할때는 현재위치 비용+다음위치비용과 다음위치가 가진 최소비용 비교
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0)
                break;

            //맵배열, 금액배열, 방문처리배열 생성
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            minCost = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(minCost[i], Integer.MAX_VALUE);
            }
//            visited = new boolean[N][N];

            //bfs탐색
            bfs();

            sb.append("Problem ").append(tc++).append(": ").append(minCost[N - 1][N - 1]).append("\n");
        }

        System.out.print(sb);


    }

    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0, 0, map[0][0]});

        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int cost = poll[2];

            if (minCost[r][c] <= cost) {
                continue;
            }
            minCost[r][c] = cost;

            for (int i = 0; i < 4; i++) {
                int nr = r + delta[i][0];//next row ...
                int nc = c + delta[i][1];
                if (0 <= nr && 0 <= nc && nr < N && nc < N && cost + map[nr][nc] < minCost[nr][nc]) {
                    q.add(new Integer[]{nr, nc, cost + map[nr][nc]});
                }
            }
        }
    }
}