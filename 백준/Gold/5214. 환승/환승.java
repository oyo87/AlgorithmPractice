import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int M;

    static ArrayList<Integer> station[];
    static ArrayList<Integer> hyperTube[];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        /*
        역의 수 N : 1~100,000
        서로 연결하는 역의 개수 K : 1~10,000
        하이퍼튜브개수 M : 1~10,000

        모든역의 연결상태를 연결하여 bfs하려 했으나 메모리 초과.
        하이퍼튜브와 역들을 연결하여 풀이

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        station = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            station[i] = new ArrayList<>();
        }
        hyperTube = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            hyperTube[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                int tempStation = Integer.parseInt(st.nextToken());
                hyperTube[i].add(tempStation);
                station[tempStation].add(i);
            }
        }

        bfs();

        if (answer == Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(answer);


    }

    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        boolean[] visitedStation = new boolean[N + 1];
        boolean[] visitedHyperTube = new boolean[M];

        q.add(new Integer[]{1, 1, 0});//역or하이퍼튜브 번호, 방문횟수, 상태 {0=역, 1=하이퍼튜브}
        visitedStation[1] = true;
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();

            int nowNumber = poll[0];
            int visitCount = poll[1];
            int status = poll[2];

            if (nowNumber == N && status == 0) {
                answer = visitCount;
                return;
            }

            if (status == 0) {//현재노드가 역
                for (int i = 0; i < station[nowNumber].size(); i++) {
                    int nextHyperTube = station[nowNumber].get(i);
                    if (!visitedHyperTube[nextHyperTube]) {
                        visitedHyperTube[nextHyperTube] = true;
                        q.add(new Integer[]{nextHyperTube, visitCount, 1});
                    }
                }
            } else {//현재노드가 하이퍼튜브
                for (int i = 0; i < hyperTube[nowNumber].size(); i++) {
                    int nextStation = hyperTube[nowNumber].get(i);
                    if (!visitedStation[nextStation]) {
                        visitedStation[nextStation] = true;
                        q.add(new Integer[]{nextStation, visitCount + 1, 0});
                    }
                }
            }


        }

    }
}