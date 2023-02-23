class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        first : for(int r=3; r<=200000000; r++){
            for(int c=3; c<=r; c++){
                if(brown + yellow < r*c)
                    break;
                if( (2*r + c*2 == brown +4) && (yellow + brown == r*c) ) {
                    answer[0] = r;
                    answer[1] = c;
                    break first;
                }
            }
        }
        return answer;
        
    }
}