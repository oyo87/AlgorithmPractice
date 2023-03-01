import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int idx = 0; idx < commands.length; idx++){
            int i= commands[idx][0];// i-1 번째 인덱스부터 시작 -1처리해줘야함
            int j = commands[idx][1];// j 번째 인덱스까지 자름 +1처리해줘야함
            int k = commands[idx][2];// 정렬한후 k번째인덱스 골라서 리턴 -1처리
            
            // int[] temp = new int[j-i+1];
            int[] temp = Arrays.copyOfRange(array, i-1, j); // i-1 ~ j까지 복사
            Arrays.sort(temp);//정렬
            answer[idx] = temp[k-1]; // k-1번째 인덱스 리턴
        }
        return answer;
    }
}