import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        입력데이터수 T
        Q에 적용할 연산의 개수 K : 0~100만
        I 숫자 : 숫자 삽입, D 1 최대값 삭제, D -1 최소값삭제

        TreeMap활용한 편리한 풀이도 가능
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map;
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int Q = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());

                char command = st.nextToken().charAt(0); //I, D
                int number = Integer.parseInt(st.nextToken());// num, 1, -1

                if (command == 'I') {
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else { //command == 'D'
                    if (map.isEmpty()) {
                        continue;
                    }

                    if (number == 1) {//최대값 삭제
                        int max = map.lastKey();
                        if (map.get(max) == 1)
                            map.remove(max);
                        else
                            map.put(max, map.get(max) - 1);
                    } else {// number == -1 최소값 삭제
                        int min = map.firstKey();
                        if (map.get(min) == 1)
                            map.remove(min);
                        else
                            map.put(min, map.get(min) - 1);
                    }
                }
            }//Q for end

            if (map.isEmpty())
                sb.append("EMPTY");
            else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey());
            }
            sb.append("\n");
        }//tc end

        System.out.print(sb);

    }
}