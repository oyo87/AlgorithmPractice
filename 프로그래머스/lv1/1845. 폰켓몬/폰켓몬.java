class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        boolean[] bool = new boolean[200001];
        
        for(int i = 0; i < nums.length; i++){
            if(!bool[nums[i]]){
                answer++;
                bool[nums[i]] = true;
            }
        }
        
        return nums.length/2 < answer ? nums.length/2 : answer;
    }
}