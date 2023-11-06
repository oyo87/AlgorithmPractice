import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static int[][] rotateInfo;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        /*
        배열의 크기 N,M : 3~50
        회전 연산의 개수 K : 1~6
        배열 내부 값 : 1~100
        rc는 1,1을 기준으로 주어지므로 -1씩해서 받기가능

        회전 구현하기
        모든 회전을 다 탐색해보며 최소값 구하기

        회전구현
        규칙상 정사각형으로만 주어지므로
        시작rc, 끝rc가 같으면 종료
        다르다면 회전구현
        시작 r+1,c+1, 끝 r-1, c-1 재귀
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateInfo = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            //문제에서는 (0,0)을 1행 1열기준으로 입력이 주어지므로 r,c는 미리 -1해서 받음
            rotateInfo[i][0] = Integer.parseInt(st.nextToken()) - 1;
            rotateInfo[i][1] = Integer.parseInt(st.nextToken()) - 1;
            rotateInfo[i][2] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[K];
        for (int i = 0; i < K; i++) {
            visited[i] = true;
            comb(map, visited, i, 1);//현재 map상태, 회전처리완료배열, 회전처리해야할 배열, depth
            visited[i] = false;
        }

        System.out.print(answer);


    }

    static void comb(int[][] map, boolean[] visited, int select, int depth) {

        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }

        rotate(newMap, select, 0);//회전할 map, 고를 rotateInfo의 인덱스, depth

        //종료조건
        if (depth == K) {
            //최소값 구하고 answer 갱신
            int tempMin = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += newMap[i][j];
                }
                tempMin = Math.min(tempMin, sum);
            }

            answer = Math.min(answer, tempMin);
            return;
        }

        //조합
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(newMap, visited, i, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void rotate(int[][] map, int select, int depth) {
        //start row,column  end row,column
        int sr = rotateInfo[select][0] - rotateInfo[select][2] + depth;
        int sc = rotateInfo[select][1] - rotateInfo[select][2] + depth;
        int er = rotateInfo[select][0] + rotateInfo[select][2] - depth;
        int ec = rotateInfo[select][1] + rotateInfo[select][2] - depth;

        if (sr == er) {//정사각형형태로 주어지기때문에 sr,er이같거나 c가 같아지는지점에서 회전 완료
            return;
        }

        //시계방향으로 회전
        int temp = map[sr][sc];

        //아래에서 위로 이동(좌측테두리)
        for (int i = sr; i < er; i++) {
            map[i][sc] = map[i + 1][sc];
        }
        //우측에서 좌측 이동(하단)
        for (int i = sc; i < ec; i++) {
            map[er][i] = map[er][i + 1];
        }

        //위에서 아래로 이동(우측)
        for (int i = er; sr < i; i--) {
            map[i][ec] = map[i - 1][ec];
        }
        //좌측에서 우측 이동(상단)
        for (int i = ec; sc < i; i--) {
            map[sr][i] = map[sr][i - 1];
        }

        map[sr][sc + 1] = temp;

        rotate(map, select, depth + 1);
    }
}