import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            테스트케이스 t : 50이하
            편의점 개수 n : 0~100
            좌표 x,y: -32768~32767

            bfs
            상근이집 큐에넣고시작
            !visited하고 거리가1000이내인 편의점, 락페스티벌 큐에 추가
            락페스티벌 가능하면 happy 불가능하면 sad


         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] house = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};//상근이네 집
            int[][] beer = new int[n + 1][2];//편의점
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                beer[i][0] = Integer.parseInt(st.nextToken());
                beer[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};//락페스티벌

            Queue<Integer[]> q = new LinkedList<>();
            q.add(new Integer[]{house[0], house[1]});

            boolean success = false;
            boolean[] visited = new boolean[n];
            //bfs
            while (!q.isEmpty()) {
                Integer[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];

                if (getDistance(r, c, end[0], end[1]) <= 1000) {
                    success = true;
                    break;
                }

                for (int i = 0; i < n; i++) {
                    int nr = beer[i][0];
                    int nc = beer[i][1];
                    if (!visited[i] && getDistance(r, c, nr, nc) <= 1000) {
                        visited[i] = true;
                        q.add(new Integer[]{nr, nc});
                    }
                }


            }

            if (success)
                answer.append("happy");
            else
                answer.append("sad");

            answer.append("\n");
        }
        System.out.print(answer);


    }

    static int getDistance(int r, int c, int nr, int nc) {
        // (row, col), (next row, next col) 거리 계산
        return Math.abs(r - nr) + Math.abs(c - nc);
    }
}