import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] gear;
    static int[][] leftRight;

    public static void main(String[] args) throws IOException {
        /*
            톱니바퀴의 상태 : 8개의 0,1의 정수
            회전횟수 K : 1 ~ 100
            회전시킨 톱니바퀴의 번호, 방향 1, -1 주어짐

            톱니바퀴 2번인덱스가 우측, 6번인덱스가 좌측

            회전 명령에 맞춰서 몇번 인덱스가 좌측을 가르켜고있고, 몇번이 우측을 가르켜고있는지만 저장


            톱니 4개
            특정 번호의 톱니 회전, 반시계회전 메소드
                회전할 톱니, 영향줄수있는 톱니(시작일땐 양옆, 왼쪽이면 왼쪽으로만, 우측이면 우측으로만)

            구현
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gear = new String[4];
        for (int i = 0; i < 4; i++) {
            gear[i] = br.readLine();
        }
        leftRight = new int[4][2];
        for (int i = 0; i < 4; i++) {//[0]좌 [1]우
            leftRight[i][0] = 6;
            leftRight[i][1] = 2;
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int gearNumber = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            rotate(gearNumber, direction, 3);
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            int north = leftRight[i][0] + 2;//톱니바퀴의 12시방향(9시방향 + 2칸)
            north %= 8;
            if (gear[i].charAt(north) == '1') {//12시가 S극
                answer += Math.pow(2, i);
            }
        }

        System.out.print(answer);

    }

    /*
        direction 1 = 시계방향, -1 = 반시계방향 회전
        effect 1 = 좌, 2 = 우, 3 = 좌우 영향
     */
    static void rotate(int now, int direction, int effect) {
        int left = leftRight[now][0];
        int right = leftRight[now][1];

        if (now != 0 && (effect == 1 || effect == 3)) {//현재 기어의 회전이 좌측에 영향
            int prevRight = leftRight[now - 1][1];
            if (gear[now].charAt(left) != gear[now - 1].charAt(prevRight)) {
                rotate(now - 1, direction * -1, 1);
            }
        }
        if (now != 3 && (effect == 2 || effect == 3)) {//현재 기어의 회전이 우측에 영향
            int nextLeft = leftRight[now + 1][0];
            if (gear[now].charAt(right) != gear[now + 1].charAt(nextLeft)) {
                rotate(now + 1, direction * -1, 2);
            }

        }

        if (direction == 1) {//시게방향
            left--;
            right--;
        } else {//반시계
            left++;
            right++;
        }
        left = (left + 8) % 8;
        right = (right + 8) % 8;

        leftRight[now][0] = left;
        leftRight[now][1] = right;
    }

}