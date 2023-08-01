class Solution {
    public int solution(int[] stones, int k) {
    
        /*
        건널수 있는 인원 수를 찾는 이분탐색으로 해결
        */
        int answer = 0;
        int left = 1;
        int right = 200000000;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            //mid 인원으로 건널수 있는지 확인
            if(isPossible(stones, k, mid)){
                answer = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
            
        }
        
        return answer;
    }
    
    public boolean isPossible(int[] stones, int k, int mid){
        int count = 0;
        for(int i=0; i<stones.length; i++){
            if(mid <= stones[i]){
                count = 0;
            }
            else{
                count++;
            }
            
            if(count == k)
                return false;
        }
        
        return true;
    }
}