import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            수열의 크기 N : 1~1,000,000
            내부 값 : 1~1,000,000
            가장 긴 증가하는 부분수열의 길이 출력

            이분탐색을 활용한 LIS을 진행
            LIS를 이루는 정확한 요소는 알수없어도 길이는 판별가능하다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[N];//수열
        for (int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();//LIS
        list.add(seq[0]);

        for (int i = 1; i < N; i++) {
            int now = seq[i];

            if (list.get(list.size() - 1) < now) {//기존수열보다 큰 값이 들어온경우
                list.add(seq[i]);
            } else {//들어갈곳있는지 확인(now이상의 값이 처음 나온 위치 탐색)
                int left = 0;
                int right = list.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) < now) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                //기존값 대체
                list.set(left, now);
            }
        }

        System.out.print(list.size());

    }
}