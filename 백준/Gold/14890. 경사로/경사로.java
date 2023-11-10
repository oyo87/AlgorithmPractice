import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int L;
    static int[][] map;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        /*
        지도의 크기 N : 2 ~ 100
        경사로 길이 L : 1 ~ 10
        각 칸의 높이는 1 ~ 10

        구현, 브루트포스 접근하면 될듯하다.
        좌->우, 상->하 탐색
        현재지점보다 다음지점이 2이상높거나낮으면 불가
        1이상 높거나 낮은경우 경사로 설치 가능한지 확인
        마지막까지 진행가능하면 성공
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            search(i, 0, 0);//시작지점 r,c, 이동방향
            search(0, i, 1);
        }

        System.out.print(answer);

    }

    static void search(int r, int c, int dir) {
        //dir == 0 좌 -> 우 이동, dir == 1 상 -> 하 이동
        boolean[] visited = new boolean[N];
        if (dir == 0) {
            for (int i = 1; i < N; i++) {
                int beforeH = map[r][i - 1];
                int nowH = map[r][i];
                if (beforeH == nowH) {
                    beforeH = nowH;
                } else if (Math.abs(beforeH - nowH) == 1) {
                    int start;
                    //이번높이가 1더큰경우
                    if (nowH - beforeH == 1) {
                        start = i - L;//경사로 설치시작위치
                        if (0 <= start) {
                            for (int j = start; j < start + L; j++) {
                                if (visited[j] || map[r][j] != beforeH) return;
                                visited[j] = true;
                            }
                        } else//Array 범위 밖경사로설치불가
                            return;
                    }
                    //이번높이가 1더낮은경우
                    else {
                        start = i + L - 1;
                        if (start < N) {
                            for (int j = start; i <= j; j--) {
                                if (visited[j] || map[r][j] != nowH) return;
                                visited[j] = true;
                            }
                        } else//Array범위밖 경사로설치불가
                            return;
                    }
                } else {
                    //불가능
                    return;
                }
            }
        } else {//dir ==1
            for (int i = 1; i < N; i++) {
                int beforeH = map[i - 1][c];
                int nowH = map[i][c];
                if (beforeH == nowH) {
                    beforeH = nowH;
                } else if (Math.abs(beforeH - nowH) == 1) {
                    int start;
                    //이번높이가 1더큰경우
                    if (nowH - beforeH == 1) {
                        start = i - L;//경사로 설치시작위치
                        if (0 <= start) {
                            for (int j = start; j < start + L; j++) {
                                if (visited[j] || map[j][c] != beforeH) return;
                                visited[j] = true;
                            }
                        } else//Array 범위 밖경사로설치불가
                            return;
                    }
                    //이번높이가 1더낮은경우
                    else {
                        start = i + L - 1;
                        if (start < N) {
                            for (int j = start; i <= j; j--) {
                                if (visited[j] || map[j][c] != nowH) return;
                                visited[j] = true;
                            }
                        } else//Array범위밖 경사로설치불가
                            return;
                    }
                } else {
                    //불가능
                    return;
                }
            }
        }
        answer++;
    }
}