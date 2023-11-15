import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        문제의 개수 N, 문제번호 P : 1~100,000
        명령문개수 M : 10,000
        난이도 L : 1~100

        우선순위 큐 두개 가장 어렵고,번호큰것 과 가장 쉽고,번호작은것 두개 사용, solved는 set 사용
        map하나로 문제,난이도 저장

        recommend 1일경우 어려운곳에서 추천, -1일경우 작은것에서 추천(출력)
        만약 set에 존재하는경우 존재하지않을때까지 || 큐에있는 문제,난이도가 map에있는 문제난이도,레벨이랑 다르면 poll() 이후 추천

        add P L : priorityQueue 두개에 add, 만약 solved에 존재한다면 solved에서 제거

        solved P : set에 add

        nullPointException 안 발생하게 입력이 주어진다.

        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer[]> hard = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        });//어려운것 우선
        PriorityQueue<Integer[]> easy = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });//쉬운것 우선

        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int problem = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            hard.add(new Integer[]{problem, level});
            easy.add(new Integer[]{problem, level});
            map.put(problem, level);
        }

        int M = Integer.parseInt(br.readLine());
        Set<Integer> solved = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("recommend")) {
                if (st.nextToken().equals("1")) {
                    int problem = hard.peek()[0];
                    int level = hard.peek()[1];

                    while (solved.contains(problem) || level != map.get(problem)) {
                        hard.poll();
                        problem = hard.peek()[0];
                        level = hard.peek()[1];
                    }
                    sb.append(problem);
                } else {//recommend -1
                    int problem = easy.peek()[0];
                    int level = easy.peek()[1];

                    while (solved.contains(problem) || level != map.get(problem)) {
                        easy.poll();
                        problem = easy.peek()[0];
                        level = easy.peek()[1];
                    }
                    sb.append(problem);
                }
                sb.append("\n");

            } else if (command.equals("add")) {
                int problem = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                if (solved.contains(problem)) {
                    solved.remove(problem);
                }
                easy.add(new Integer[]{problem, level});
                hard.add(new Integer[]{problem, level});
                map.put(problem, level);

            } else {//command is "solved"
                solved.add(Integer.parseInt(st.nextToken()));
            }

        }

        System.out.print(sb);

    }
}