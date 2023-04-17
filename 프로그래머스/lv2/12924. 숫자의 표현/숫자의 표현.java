class Solution {
    public int solution(int n) {
        //누적합
        if(n==0)
            return 0;
        int answer = 0;
        int[] sum = new int[n];
        for(int i=1; i<n; i++){
            sum[i] = sum[i-1] + i;
        }
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(sum[j] - sum [i] == n){
                    answer++;
                    break;
                }
                else if(n < sum[j] - sum[i]){
                    break;
                }
            }
        }
        
        answer++;//숫자 자기자신
        
        return answer;
    }
}