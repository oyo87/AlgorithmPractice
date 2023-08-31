class Solution {
    public int solution(int[] a) {
        /*
        가장 작은값은 무조건 살아남기 가능
        가장작은값의 왼쪽구간, 우측구간으로 나눠서
        왼쪽구간은 0~자신까지 최소값이 자신이라면 살아남기가능
        우측구간은 끝~자신까지 최소값이 자신이라면 살아남기 가능
        
        최소값의 왼쪽구간은 왼쪽부터시작해서 최소값 기록
        최소값의 오른쪽구간은 오른쪽부터 시작해서 최소값 기록
        최소값이 자신이라면 answer++
        */
        if(a.length < 3){
            return a.length;
        }
        
        int INF = 2111111111;
        int answer = 0;
        int min = INF; //최소값
        int minIndex = 0; //최소값 위치
        int[] minArr = new int[a.length];//각 구간별 최소값을 기록(0~최소값왼쪽, 최소값, 최소값우측~끝)
        for(int i=0; i<a.length; i++){
            if(a[i] < min){
                min = a[i];
                minIndex = i;
                minArr[i] = min;
            }            
        }
        
        int minLeft = INF;
        for(int i=0; i<minIndex; i++){
            if(a[i] < minLeft){
                minLeft = a[i];
            }
            minArr[i] = minLeft;
        }
        
        int minRight = INF;
        for(int i=a.length-1; minIndex < i; i--){
            if(a[i] < minRight){
                minRight = a[i];
            }
            minArr[i] = minRight;
        }
        for(int i=0; i<minArr.length; i++){
            if(minArr[i] == a[i])
                answer++;
        }
        
        
        return answer;
    }
}