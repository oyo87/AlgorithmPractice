import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        /*
            N : 1~100
            글로벌값 이용 부모구하기

            부모가 본인과 일치할경우 값 추가

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        parent = new int[N + 1];
        for(int i=0; i<=N; i++){
            parent[i] = arr[i];
        }

        boolean[] answer = new boolean[N+1];
        int size = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            if(find(i, i) == i){
                answer[i] = true;
                size++;
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n");
        for(int i=0; i<answer.length; i++){
            if(answer[i])
                sb.append(i).append("\n");
        }

        System.out.print(sb);

    }

    static int find(int index, int start){
        if(arr[index] == start)
            return start;

        if(visited[index])
            return -1;
        visited[index] = true;

        return find(arr[index], start);
    }
}