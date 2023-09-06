import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        /*
        사이즈를 큰것, 작은것으로 정렬한 후에
        가장 큰값 찾아서 곱하기
        */
        
        //가로가 더 크게 정렬
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                swap(sizes,i);
            }
        }
        
        int maxW = 0;
        int maxH = 0;
        for(int i=0; i<sizes.length; i++){
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }
        //가로 가장큰값, 세로가장 큰값 찾아서 곱하기
        return maxW * maxH;
    }
    
    void swap(int[][] sizes, int i){
        int temp = sizes[i][0];
        sizes[i][0] = sizes[i][1];
        sizes[i][1] = temp;
    }
}