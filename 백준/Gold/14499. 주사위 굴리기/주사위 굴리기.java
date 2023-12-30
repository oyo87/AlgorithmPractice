import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int r;
    static int c;
    static int K;
    static int[] dice = new int[6];
    static int[][] map;

    static int[][] delta = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};//동서북남
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /*
            지도크기 세로N 가로M : 1~20
            주사위좌표 x,y(r,c) : 0~N-1, 0~M-1
            명령의 개수 K : 1~1,000
            지도 칸에 쓰여있는 수 0~9

            구현하는 문제

            int[6] dice 주사위 위치 숫자 [0]상단 1정면 2우측 3뒷면 4좌측 5하단
            상하좌우 이동시 주사위 상태 변경되는 메소드 구현
            이동시 상단에있는값 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            command(Integer.parseInt(st.nextToken()) - 1);
        }

        System.out.print(answer);
    }

    static void command(int num) {
        int nr = r + delta[num][0];
        int nc = c + delta[num][1];

        if (0 <= nr && 0 <= nc && nr < N && nc < M) {//이동가능
            r = nr;
            c = nc;
            move(num, nr, nc);
            answer.append(dice[0]).append("\n");
        }
    }

    static void move(int num, int nr, int nc) {
        /*
            num 0동, 1서, 2북, 3남
            각num에 맞게 4가지케이스 나눠서 dice 정렬
            dice[0]상단 1정면 2우측 3후면 4좌측 5하단
        */
        int temp = dice[0];
        if (num == 0) {
            //상->우 우->하 하->좌 좌->상
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[2];
            dice[2] = temp;
        } else if (num == 1) {
            //상->좌 좌->하 하->우 우->상
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[4];
            dice[4] = temp;
        } else if (num == 2) {
            //상->후 후->하 하->정 정->상
            dice[0] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[3];
            dice[3] = temp;
        } else {//num==3
            //상->정 정->하 하->후 후->상
            dice[0] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;
        }

        //해당위치로 이동할때 바닥에있는 숫자가 0이면 바닥에있는것 복사
        //0이아니라면 지도에쓰여있는수가 0이되고 지도에쓰여있던수가 주사위 바닥면으로 복사
        if (map[nr][nc] == 0) {
            map[nr][nc] = dice[5];
        } else {
            temp = map[nr][nc];
            map[nr][nc] = 0;
            dice[5] = temp;
        }
    }
}