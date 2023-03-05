import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[9][9];
        for (int i = 0; i < 9; i++) { // 맵입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution(map, 0, 0);// map, row, col

    }

    private static void Solution(int[][] map, int row, int col) {
        if (9 <= col) { //col이 9가됐을땐 row++ col = 0
            col = 0;
            row++;
        }

        if (9 <= row) { // row가 9가됐을땐 스도쿠가 완성되었다는것
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                sb.append(map[i][0]);
                for (int j = 1; j < 9; j++) {
                    sb.append(" ").append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0); // 즉시종료
        }

        if (map[row][col] == 0) { //0이면 채워넣어야할 차례
            ArrayList<Integer> list = new ArrayList<>(); // 채워넣기 가능한 숫자들 모음
            list = checkSdoku(map, row, col); // 가능한 숫자 check

            if (list.isEmpty()) // 아무것도 넣을 수 없는경우
                return;
            else {
                for (int k = 0; k < list.size(); k++) { // 넣을수 있을경우 하나씩 넣고 재귀
                    map[row][col] = list.get(k);
                    Solution(map, row, col + 1);
                    map[row][col] = 0;
                }
            }
        } else {
            Solution(map, row, col + 1);
        }
    }

    private static ArrayList<Integer> checkSdoku(int[][] map, int r, int c) { //현재위치에 들어갈수있는 숫자를 찾고 반환
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] impossibleNumber = new boolean[10];

        //가로 조건
        for (int i = 0; i < 9; i++) {
            impossibleNumber[map[r][i]] = true;
        }

        //세로 조건
        for (int i = 0; i < 9; i++) {
            impossibleNumber[map[i][c]] = true;
        }
        //3*3조건
        //ex 012는 0 345 는 3 678 은 6으로 와야함
        int nr = r / 3 * 3;
        int nc = c / 3 * 3;

        for (int i = nr; i < nr + 3; i++) {
            for (int j = nc; j < nc + 3; j++) {
                impossibleNumber[map[i][j]] = true;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (!impossibleNumber[i])
                list.add(i);
        }
        return list;

    }
}