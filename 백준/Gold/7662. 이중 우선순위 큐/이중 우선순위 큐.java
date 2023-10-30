import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        입력데이터수 T
        Q에 적용할 연산의 개수 K : 0~100만
        I 숫자 : 숫자 삽입, D 1 최대값 삭제, D -1 최소값삭제

        최소힙, 최대힙 두개 생성, map생성

        I, D구현

        map key 돌면서
        max, min 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;
        HashMap<Integer, Integer> map;
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int Q = Integer.parseInt(br.readLine());
            min = new PriorityQueue<>();
            max = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());

                char command = st.nextToken().charAt(0); //I, D
                int number = Integer.parseInt(st.nextToken());// num, 1, -1

                if (command == 'I') {
                    min.add(number);
                    max.add(number);
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else { //command == 'D'
                    if (map.isEmpty()) {
                        continue;
                    }

                    if (number == 1) {//최대값 삭제
                        int maxValue = max.poll();
                        int count = map.getOrDefault(maxValue, 0);
                        while (count == 0) {
                            map.remove(maxValue);
                            maxValue = max.poll();
                            count = map.getOrDefault(maxValue, 0);
                        }

                        if (count == 1) {
                            map.remove(maxValue);
                        } else {
                            map.put(maxValue, count - 1);
                        }


                    } else {// number == -1 최소값 삭제

                        int minValue = min.poll();
                        int count = map.getOrDefault(minValue, 0);

                        while (count == 0) {
                            map.remove(minValue);
                            minValue = min.poll();
                            count = map.getOrDefault(minValue, 0);
                        }

                        if (count == 1) {
                            map.remove(minValue);
                        } else {
                            map.put(minValue, count - 1);
                        }
                    }
                }
            }//Q for end

            if (map.isEmpty())
                sb.append("EMPTY");
            else {
                int maxValue = Integer.MIN_VALUE;
                int minValue = Integer.MAX_VALUE;
                for (int key : map.keySet()) {
                    maxValue = Math.max(maxValue, key);
                    minValue = Math.min(minValue, key);
                }

                sb.append(maxValue).append(" ").append(minValue);
            }
            sb.append("\n");
        }//tc end

        System.out.print(sb);

    }
}