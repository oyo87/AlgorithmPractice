import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[] score;

    static int minDepth = Integer.MAX_VALUE;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        /*
        회원의 수 N : 50명 이하

        ArrayList로 관계 연결해주고
        친구 완전탐색진행하면서 점수 부여,저장
        가장 낮은점수 찾아서 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1)
                break;

            list[a].add(b);
            list[b].add(a);
        }

        score = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            search(i);
        }

        //정답 출력
        StringBuilder sb = new StringBuilder();
        sb.append(minDepth).append(" ");

        int answerCount = 0;
        for (int i = 1; i < score.length; i++) {
            if (score[i] == minDepth) {
                answerCount++;
            }
        }
        sb.append(answerCount).append("\n");
        for (int i = 1; i < score.length; i++) {
            if (score[i] == minDepth) {
                sb.append(i).append(" ");
            }
        }

        System.out.print(sb);

    }

    static void search(int start) {
        boolean[] visited = new boolean[N + 1];
        int friendCount = 1;//친구, 친구의 친구, ... 수 전체 인원이 되어야 점수부여가능
        int depth = 0;

        visited[start] = true;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{start, depth});
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int index = poll[0];
            depth = poll[1];

            for (int i = 0; i < list[index].size(); i++) {
                int friend = list[index].get(i);
                if (!visited[friend]) {
                    visited[friend] = true;
                    friendCount++;
                    q.add(new Integer[]{friend, depth + 1});
                }
            }
        }
        if (friendCount == N) {
            score[start] = depth;
            minDepth = Math.min(minDepth, depth);
        }


    }
}