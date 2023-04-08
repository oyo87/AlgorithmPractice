import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE; 
    static int N;
    static int M;
    static int[][] arr;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상하좌우
    static ArrayList<int[]> chickenList; // 치킨집 위치 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        chickenList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) { // 치킨집이면 위치 저장
                    chickenList.add(new int[]{i, j});
                }
            }
        }

        boolean[] selectedChicken = new boolean[chickenList.size()];
        comb(0, 0, selectedChicken); 

        if (answer == Integer.MAX_VALUE) { 
            answer = 0;
        }
        System.out.println(answer);
    }

    public static void comb(int start, int depth, boolean[] selectedChicken) {
        if (depth == M) { // M개를 고른 상태
            int cityChickenDist = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1) { // 집이라면
                        int minChickenDist = Integer.MAX_VALUE;
                        for (int k = 0; k < selectedChicken.length; k++) {
                            if (selectedChicken[k]) { 
                                int[] chickenLoc = chickenList.get(k);
                                int chickenDist = Math.abs(i - chickenLoc[0]) + Math.abs(j - chickenLoc[1]);
                                minChickenDist = Math.min(minChickenDist, chickenDist);
                            }
                        }
                        cityChickenDist += minChickenDist;
                    }
                }
            }

            answer = Math.min(answer, cityChickenDist);
            return;
        }

        for (int i = start; i < chickenList.size(); i++) { 
            selectedChicken[i] = true;
            comb(i + 1, depth + 1, selectedChicken);
            selectedChicken[i] = false;
        }
    }
}