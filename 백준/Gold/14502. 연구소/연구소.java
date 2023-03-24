import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int delta[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //0빈칸 1벽 2바이러스

        recursion(map, visited, 0);

        System.out.println(answer);
    }

    public static void recursion(int[][] map, boolean[][] visited, int depth) {
        if (depth == 3) {
            int safeArea = 0;//안전영역
            int[][] resultMap = new int[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M;j++){
                    resultMap[i][j] = map[i][j];
                }
            }
            bfs(resultMap);//바이러스 퍼트리기완료
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (resultMap[r][c] == 0)
                        safeArea++;
                }
            }
            answer = Math.max(answer, safeArea);
            return;
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0 && !visited[r][c]) {
                    visited[r][c] = true;
                    map[r][c] = 1;
                    recursion(map, visited, depth + 1);
                    map[r][c] = 0;
                    visited[r][c] = false;
                }
            }
        }
    }

    public static void bfs(int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 2 && !visited[r][c]) {
                    visited[r][c] = true;
                    q.add(new int[]{r, c});
                    while (!q.isEmpty()) {
                        int[] poll = q.poll();
                        int cr = poll[0];//current row
                        int cc = poll[1];//current col
                        for (int i = 0; i < 4; i++) {
                            int nr = cr + delta[i][0];
                            int nc = cc + delta[i][1];
                            if (0 <= nr && 0 <= nc && nr < N && nc < M && map[nr][nc] == 0 && !visited[nr][nc]) {
                                map[nr][nc] = 2;
                                visited[nr][nc] = true;
                                q.add(new int[]{nr, nc});
                            }
                        }

                    }
                }
            }
        }

    }
}