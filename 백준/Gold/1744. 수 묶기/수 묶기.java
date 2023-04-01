import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 음수, 양수 리스트를 따로 만들어줌
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> negative = new ArrayList<>(); // 값 <= 0 리스트 음수와 0곱했을때 최대가되므로 0도 포함시켜줌
        ArrayList<Integer> positive = new ArrayList<>(); // 0 < 값 리스트

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 0)
                negative.add(num);
            else
                positive.add(num);
        }
        Collections.sort(negative); // 음수는 오름차순
        Collections.sort(positive, Collections.reverseOrder()); // 양수는 내림차순
        int answer = 0;
        if (negative.size() == 1)
            answer += negative.get(0);
        if (positive.size() == 1)
            answer += positive.get(0);

        for (int i = 0; i < negative.size() - 1; i++) {
            int cur = negative.get(i);
            int next = negative.get(i + 1);
            if (cur < cur * next) {
                answer += cur * next;
                i++;
            } else
                answer += cur;
            if (i == negative.size() - 2) //마지막 값 더해주며 끝
                answer += negative.get(i + 1);
        }

        for (int i = 0; i < positive.size() - 1; i++) { // 위와 로직은 같음
            int cur = positive.get(i);
            int next = positive.get(i + 1);
            if (cur < cur * next) {
                answer += cur * next;
                i++;
            } else
                answer += cur;
            if (i == positive.size() - 2) //마지막 값 더해주며 끝
                answer += positive.get(i + 1);
        }

        System.out.println(answer);
    }

}