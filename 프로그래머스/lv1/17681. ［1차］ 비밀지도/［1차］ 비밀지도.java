class Solution {
    int gn = 0;//global n
    public String[] solution(int n, int[] arr1, int[] arr2) {
        /*
        int를 2진법으로 변경하고 둘다 0일경우 공백
        */
        gn = n;
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
            if(toBinary(arr1[i]).charAt(j) == '0' && toBinary(arr2[i]).charAt(j) == '0'){
                sb.append(" ");
            }
            else
                sb.append("#");
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
            
        return answer;
    }
    
    String toBinary(int num){
        StringBuilder sb = new StringBuilder();
        
        while(0 < num){
            sb.append(num%2);
            num /= 2;
        }
        
        //배열 크기 맞춰서 0 넣어주기
        while(sb.length() < gn){
            sb.append(0);
        }
        
        sb.reverse();
        return sb.toString();
    }
}