import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            수행해야할 작업 N : 3~10,000
            각 작업마다 걸리는 시간 : 1~100

            위상정렬 문제
            진입차수가 0이된것들 실행
            읽반적인 위상정렬 노드순서 출력이아닌 시간을 구해야함

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++)
            list[i] = new ArrayList<>();


        int[] time = new int[N + 1];//작업 시간

        int[] inDegree = new int[N + 1];//진입차수
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            int count = Integer.parseInt(st.nextToken());//선행관계 작업 개수
            for (int j = 0; j < count; j++) {
                int node = Integer.parseInt(st.nextToken());
                list[node].add(i);
                inDegree[i]++;
            }
        }


        int[] completeTime = new int[N + 1];//작업 수행에 총 걸린 시간
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            completeTime[i] = time[i];

            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();

            for (int j = 0; j < list[poll].size(); j++) {
                int nextNode = list[poll].get(j);

                inDegree[nextNode]--;

                completeTime[nextNode] = Math.max(completeTime[nextNode], completeTime[poll] + time[nextNode]);

                if (inDegree[nextNode] == 0) {
                    q.add(nextNode);

                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<N+1; i++)
            answer = Math.max(answer, completeTime[i]);

        System.out.print(answer);

    }
}