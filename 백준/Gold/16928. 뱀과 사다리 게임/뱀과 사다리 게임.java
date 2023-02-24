import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, Integer> map = new HashMap<>();
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        visited = new boolean[101];

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) { // 사다리, 뱀관련 이벤트위치를 map에 넣어줌 (위치, 이동할지점)
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bfs();
    }   //  main-end

    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{1, 0});//시작
        visited[1] = true;

        firstLoop:
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int curPos = poll[0];   //  현재 위치
            int curCnt = poll[1];   //  현재 위치까지 오는데 주사위 던진 횟수
            int nextPos;                    //  다음 위치
            int nextCnt =  curCnt + 1;      //  다음 위치까지 가는데 주사위 던진 횟수

            if(map.containsKey(curPos)) {
                curPos = map.get(curPos);
                visited[curPos] = true;
            }

            if(curPos == 100) {
                System.out.println(curCnt);
                return;
            }

            for(int d = 1; d <= 6; d++) {
                nextPos = curPos + d;   //  주사위 던졌을 때 갈 수 있는 칸
                if(nextPos > 100) break;

                if(visited[nextPos])    //  이미 방문한 칸일 경우
                    continue;

                visited[nextPos] = true;
                q.offer(new Integer[]{nextPos, nextCnt});
            }
        }   //  while-end
    }   // bfs-end
}
