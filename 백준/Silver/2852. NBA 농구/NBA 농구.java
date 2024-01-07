import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /*
            골이 들어간 횟수 N : 1~100
            분 : 0~47
            초: 0~59

            양 팀 점수 기록
            시간 변할때마다 점수 비교
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int time = 0;//게임 시간(초)

        //1팀,2팀 득점
        int teamScore1 = 0;
        int teamScore2 = 0;

        //1팀,2팀 이긴 시간(초)
        int winTime1 = 0;
        int winTime2 = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());

            String tempTime = st.nextToken();
            int minute = Integer.parseInt(tempTime.substring(0, 2));
            int second = Integer.parseInt(tempTime.substring(3, 5));
            int nextTime = minute * 60 + second;

            if (teamScore2 < teamScore1) {//1팀 이기는중
                winTime1 += nextTime - time;
            } else if (teamScore1 < teamScore2) {//2팀 이기는중
                winTime2 += nextTime - time;
            }

            if (team == 1)
                teamScore1++;
            else
                teamScore2++;

            time = nextTime;
        }

        //48분까지의 이긴시간 추가기록
        if (teamScore2 < teamScore1) {//1팀 이기는중
            winTime1 += 48 * 60 - time;
        } else if (teamScore1 < teamScore2) {//2팀 이기는중
            winTime2 += 48 * 60 - time;
        }

        getAnswer(winTime1);
        getAnswer(winTime2);

        System.out.print(answer);

    }

    static void getAnswer(int winTime) {
        int minute = winTime / 60;

        if (minute == 0)
            answer.append("00");
        else if (minute < 10) {
            answer.append("0");
            answer.append(minute);
        } else
            answer.append(minute);


        answer.append(":");

        int second = winTime % 60;

        if (second == 0)
            answer.append("00");
        else if (second < 10) {
            answer.append("0");
            answer.append(second);
        } else
            answer.append(second);

        answer.append("\n");
    }
}