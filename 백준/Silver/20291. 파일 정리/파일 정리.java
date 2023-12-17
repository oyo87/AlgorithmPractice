import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
            바탕화면 파일의 개수 N : 1~50,000
            파일의 이름 길이 3~100, 소문자와 점 하나

            Map에 확장자,등장횟수 저장
            확장자 이름 사전순 정렬후 출력
         */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int j;//.등장위치 처음과 마지막은 제외
            for (j = 1; j < str.length() - 1; j++) {
                if (str.charAt(j) == '.')
                    break;
            }

            String extension = str.substring(j + 1);//확장자
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        String[][] answer = new String[map.size()][2];
        int index = 0;
        for (String s : map.keySet()) {
            answer[index][0] = s;
            answer[index++][1] = map.get(s).toString();
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }

        System.out.print(sb);

    }
}