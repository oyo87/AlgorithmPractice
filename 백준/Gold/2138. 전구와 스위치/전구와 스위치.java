import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        첫번째 스위치를 누른경우, 누르지 않은경우 두가지 탐색
        N : 2~100,000

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];//맨 왼쪽 스위치를 누른경우
        int[] arr2 = new int[N];//누르지 않은경우
        String temp = br.readLine();
        for (int i = 0; i < N; i++) {
            arr1[i] = temp.charAt(i) - '0';
            arr2[i] = arr1[i];
        }
        int[] target = new int[N];
        temp = br.readLine();
        for (int i = 0; i < N; i++) {
            target[i] = temp.charAt(i) - '0';
        }

        //arr1 맨왼쪽스위치 누름
        arr1[0] ^= 1;
        arr1[1] ^= 1;

        int answer1 = 1;//arr1 누른횟수
        int answer2 = 0;//arr2 누른횟수
        for (int i = 1; i < N - 1; i++) {
            if (arr1[i - 1] != target[i - 1]) {
                arr1[i - 1] ^= 1;
                arr1[i] ^= 1;
                arr1[i + 1] ^= 1;
                answer1++;
            }

            if (arr2[i - 1] != target[i - 1]) {
                arr2[i - 1] ^= 1;
                arr2[i] ^= 1;
                arr2[i + 1] ^= 1;
                answer2++;
            }

        }

        //마지막스위치 작업
        if (arr1[N - 2] != target[N - 2]) {
            arr1[N - 2] ^= 1;
            arr1[N - 1] ^= 1;
            answer1++;
        }
        if (arr2[N - 2] != target[N - 2]) {
            arr2[N - 2] ^= 1;
            arr2[N - 1] ^= 1;
            answer2++;
        }

        int answer = -1;
        for (int i = 0; i < N + 1; i++) {
            if (i == N) {
                answer = answer1;
                break;
            }
            if (target[i] != arr1[i])
                break;
        }

        for (int i = 0; i < N + 1; i++) {
            if (i == N) {
                if (answer == -1)
                    answer = answer2;
                else
                    answer = Math.min(answer, answer2);
                break;
            }
            if (target[i] != arr2[i])
                break;
        }

        System.out.print(answer);
        
    }
}