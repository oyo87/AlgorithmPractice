import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length -1;

        while(left < right){ // 겹침이 발생할때까지 반복
            if(arr[left] + arr[right] == target){ //같은값이면 left++ right--
                answer++;
                left++;
                right--;
                continue;
            }
            else{
                if(arr[left] + arr[right] < target){ // target보다 작으면 값을 키워야하니 left++
                    left++;
                }
                else{ // target보다 크다면 값을 줄어야하니 right-- 
                    right--;
                }
            }
        }

        System.out.println(answer);
    }
}