import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[101];
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) { // 사다리, 뱀관련 이벤트위치를 map에 넣어줌 (위치, 이동할지점)
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{1, 0});//시작
        firstLoop:
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();

            if (map.containsKey(poll[0])) { // 현재위치가 사다리, 뱀이있다면 이동
//                if (!visited[map.get(poll[0])]) {
                    poll[0] = map.get(poll[0]);
                    visited[poll[0]] = true;
//                }
            }
            if (poll[0] == 100) { // 만약 현재위치가 100이라면 출력하고 끝내기
                System.out.println(poll[1]);
                return;
            }

            for (int i = 1; i <= 6; i++) { // 1부터 6까지 차례대로 넣고 주사위 굴림, 100초과하면 멈춤
                if (100 < poll[0] + i)
                    continue firstLoop;
                if (!visited[poll[0] + i]) {
                    q.add(new Integer[]{poll[0] + i, poll[1] + 1});
                    visited[poll[0] + i] = true;
                }
            }
        }
    }
}
