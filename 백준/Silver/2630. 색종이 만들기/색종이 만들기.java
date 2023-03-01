import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 무조건 짝수

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, N);
        System.out.println(white);
        System.out.println(blue);

    }

    private static void recursion(int row, int col, int size) {
        //1 ~ 4사분면을 모두 탐색한다. 편의상 좌측상단부터 1, 2, 3, 4사분면으로 생각
        if (sameColor(row, col, size) != -1) {
            if (map[row][col] == 0)
                white++;
            else
                blue++;
            return;
        }

        recursion(row, col, size / 2); //1사분면
        recursion(row, col + size / 2, size / 2); // 2사분면
        recursion(row + size / 2, col, size / 2); // 3사분면
        recursion(row + size / 2, col + size / 2, size / 2); // 4사분면
    }

    private static int sameColor(int row, int col, int size) { //-1이면 다름, 0이면 white, 1이면 blue

        int color = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != color)
                    return -1;
            }
        }
        return color;
    }
}