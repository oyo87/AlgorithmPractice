import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int I;//체스판길이
    static boolean[][] visited;
    static int answer;
    static int[] target; //도착지점
    static int[][] delta = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}}; //나이트 8방향움직임

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            answer = 0;
            I = Integer.parseInt(br.readLine());//체스판길이
            visited = new boolean[I][I];
            int[] now = new int[3]; //현재위치 row, col, turn
            target = new int[2]; //도착해야할 위치 row, col
            StringTokenizer st = new StringTokenizer(br.readLine());

            now[0] = Integer.parseInt(st.nextToken());
            now[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            target[0] = Integer.parseInt(st.nextToken());
            target[1] = Integer.parseInt(st.nextToken());

            visited[now[0]][now[1]] = true;
            BFS(now);
            System.out.println(answer);
        }
    }

    private static void BFS(int[] now) {
        Queue<int[]> q = new LinkedList<>();
        q.add(now);
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int row = poll[0];
            int col = poll[1];
            int turn = poll[2];
            if (row == target[0] && col == target[1]) {//목적지 도착
                answer = poll[2];
                return;
            }
            for (int i = 0; i < 8; i++) {
                int dr = delta[i][0];
                int dc = delta[i][1];

                if (0 <= row + dr && 0 <= col + dc && row + dr < I && col + dc < I && !visited[row + dr][col + dc]) {//나이트 움직임이 판 내부이고 방문안했으면
                    visited[row + dr][col + dc] = true;
                    int[] next = new int[2];
                    next[0] = row+dr;
                    next[1] = col+dc;
                    q.add(new int[] {row+dr, col+dc, turn+1});
                }
            }


        }

    }
}