import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int L;
    static int R;
    static int[][] map;
    static ArrayList<Integer[]> list = new ArrayList<>();
    static int[][] visited;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        /*
            땅크기 N : 1~50
            인구차이 조건 L,R : 1~100
            인구수 : 0~100
            인구이동 발생 일 수는 2,000이하

            while(이동했으면 반복)
            인구;
            나라수;

            모든배열 탐색하면서 연합없을시 bfs시작 연합 int[N][N] visited관리
                bfs탐색끝났을때 연합수, 인원수 ArrayList[]에 저장 (인덱스가 연합번호)
            모든탐색 끝났을때 다시 모든배열탐색하면서 연합번호있을때 인원수 조정,
            인원수변동없을시 반복끝
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //map init
        map = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int unionNumber = 1;
        int answer = 0;

        while (0 < unionNumber) {//매일 반복
            //init
            unionNumber = 0;
            list.clear();
            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], -1);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == -1) {
                        unionNumber = bfs(i, j, unionNumber);
                    }
                }
            }

            if (0 < unionNumber) {//인구이동가능하면 이동 시작
                move();
                answer++;
            }
        }

        System.out.print(answer);
    }

    static void move() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int unionNumber = visited[i][j];
                if (unionNumber != -1) {
                    int country = list.get(unionNumber)[0];
                    int people = list.get(unionNumber)[1];
                    map[i][j] = people / country;
                }
            }
        }
    }

    static int bfs(int row, int col, int unionNumber) {

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{row, col});
        int country = 1;
        int people = map[row][col];
        visited[row][col] = unionNumber;

        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + delta[i][0];
                int nc = c + delta[i][1];

                //배열내, 연합없고, L ~ R사이의 인구차이면 연합화 진행
                if (0 <= nr && 0 <= nc && nr < N && nc < N && visited[nr][nc] == -1) {

                    int diff = Math.abs(map[r][c] - map[nr][nc]);//인구수차이
                    if (L <= diff && diff <= R) {
                        q.add(new Integer[]{nr, nc});
                        country++;
                        people += map[nr][nc];
                        visited[nr][nc] = unionNumber;
                    }
                }
            }
        }

        if (country == 1) {//연합 없는경우
            visited[row][col] = -1;
        } else {
            list.add(new Integer[]{country, people});
            unionNumber++;
        }
        return unionNumber;
    }
}