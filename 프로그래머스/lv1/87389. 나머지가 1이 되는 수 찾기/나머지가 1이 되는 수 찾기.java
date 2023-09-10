class Solution {
    public int solution(int n) {
        /*
        100만 케이스
        모든 케이스 처리해보며 단순 구현
        */
        for(int i=1; i<=Integer.MAX_VALUE; i++){
            if(n%i == 1)
                return i;
        }
        return -1;
    }
}