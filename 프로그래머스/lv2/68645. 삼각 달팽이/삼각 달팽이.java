class Solution {
    public int[] solution(int n) {
        /*
        ex n = 5이면 5*5만들고
        1 0 0 0 0
        2 12 0 0 0
        3 13 11 0 0
        4 14 15 10 0
        5 6  7  8  9
        내려오기, 우로이동, 좌상단이동 반복
        
        max = n+ n-1 + n-2 + ...
        */
        if(n==1)
            return new int[] {1};
        int[][] arr = new int[n][n];
        int number = 1;
        int max = 0;
        for(int i=1; i<=n; i++)
            max +=i;
        int[] answer = new int[max];
        
        int r = 0;
        int c = 0;
        while(number <= max){
            //아래 이동
            while(r<n && arr[r][c] == 0){
                arr[r++][c] = number++;
            }
            r--;
            c++;
            
            //우측 이동
            while(c<n && arr[r][c] == 0){
                arr[r][c++] = number++;
            }
            r--;
            c-=2;
            
            //좌상단 이동
            while(arr[r][c] == 0){
                arr[r--][c--] = number++;
            }
            r+=2;
            c++;
        }
        //answer에 넣기
        int index = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] != 0)
                    answer[index++] = arr[i][j];
            }
        }
        
        return answer;
    }
}