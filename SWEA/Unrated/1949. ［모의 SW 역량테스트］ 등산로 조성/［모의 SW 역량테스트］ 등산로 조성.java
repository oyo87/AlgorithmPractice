import java.util.Scanner;
 
public class Solution {
    static int N; // 지도 한변 길이
    static int K; // 땅 팔수있는 깊이
    static int[][] map; // 지도
    static boolean[][] visit; // 방문처리
    static int maxHeight; // 가장 높은 봉우리 저장
    static int maxLength; // 출력할값. 최대 길이
 
    static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 상우하좌
    static StringBuilder sb;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            map = new int[N][N];
            visit = new boolean[N][N];
            maxHeight = 0;
            maxLength = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }
 
            // 탐색하면서 배열 한칸한칸마다 k만큼 땅을 파주면서 maxHeight일때 출발해서 최대길이구함
            for (int k = 0; k <= K; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        map[i][j] -= k;// 땅파기
                        for (int x = 0; x < N; x++) {
                            for (int y = 0; y < N; y++) {
                                if (map[x][y] == maxHeight) {
                                    Recursion(x, y, 1);
                                    visit = new boolean[N][N]; // 한번썼으니 초기화
                                }
                            }
                        }
                        map[i][j] += k;// 팠던 땅 복구
                    }
                }
            }
 
            sb.append("#").append(tc).append(" ").append(maxLength).append("\n");
        } // tc끝
        System.out.println(sb);
    }
 
    static void Recursion(int x, int y, int depth) {
        if (visit[x][y]) {
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            if (rangeCheck(x, y, i) && map[x + delta[i][0]][y + delta[i][1]] < map[x][y]) {// 인덱스 범위 내이고 이동할곳이 지금보다
                                                                                            // 작은값이면 이동가능
                visit[x][y] = true;
                maxLength = Math.max(maxLength, depth + 1);
                Recursion(x + delta[i][0], y + delta[i][1], depth + 1);
                visit[x][y] = false;
            }
        }
 
    }
 
    static boolean rangeCheck(int x, int y, int i) { // 인덱스 범위 벗어나는지체크
        if (0 <= x + delta[i][0] && x + delta[i][0] < N && 0 <= y + delta[i][1] && y + delta[i][1] < N)
            return true;
        return false;
    }
}