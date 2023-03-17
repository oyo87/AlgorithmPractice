import java.util.*;

class Solution {
    static int answer = 10000000;
    public int solution(String begin, String target, String[] words) {
        
        boolean possible = false;
        boolean[] visited = new boolean[words.length];
        for(String s : words){
            if(s.equals(target)){
                possible = true;
                break;
            }
        }
        if(!possible){
            return 0;
        }
        
        dfs(begin, target, words, visited, 0);
        
        if(answer == 10000000)
            answer = 0;
        return answer;
    }
    
    public void dfs(String word, String target, String[] words, boolean[] visited, int depth){
        if(answer <= depth)
            return ;
        if(word.equals(target)){
            answer = Math.min(answer, depth);
            return ;
        }
        
        for(int i=0; i<words.length; i++){// words배열만큼 탐색
            if(!visited[i] && differentCount(word, words[i]) == 1){//다른 글자가 한글자일때만
                for(int j=0; j<word.length(); j++){
                    if(word.charAt(j) != words[i].charAt(j)){//탐색중인 위치 단어가 다르고, 다른지점의 words배열값이 target과일치하면 변경
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(j, words[i].charAt(j)); // 단어교체
                        // System.out.println(sb.toString()+" "+ (depth+1));
                        visited[i] = true;
                        dfs(sb.toString(), target, words, visited, depth + 1);
                        visited[i] = false;
                        break;
                    }
                }
            }//if differentCount
        }//for i
        
        
    }//dfs
    
    public int differentCount(String currentWord, String words){
        int count =0;
        for(int i=0; i<currentWord.length(); i++){
            if(currentWord.charAt(i) != words.charAt(i)){
                count++;
            }
        }
        return count;
    }
}//solution