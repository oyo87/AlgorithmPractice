import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        /*
        장르별로 가장 많이 재생된 노래를 두개씩 모아 베스트 앨범 출시.
        가장 많이 재생된 장르 체크하여 먼저 수록
        장르 내에서 가장 많이 재생된 노래2개 체크. 횟수 같을경우 고유번호 낮은노래먼저 수록
        */
        
        HashMap<String, Integer> genresMap = new HashMap<>(); // 해당 장르가 재생된 총 횟수 ex) pop : 3100
        HashMap<String, Integer[][]> playsMap = new HashMap<>(); // 해당 장르에서 가장 많이 재생된것의 재생횟수, 인덱스 저장 ex) classic : {{800, 3},{500, 0}}
        
        for(int i=0; i<genres.length; i++){
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
            
            if(!playsMap.containsKey(genres[i])){
                playsMap.put(genres[i], new Integer[][] {{plays[i], i},{-1, -1}});//재생횟수, 인덱스
            }
            else{
                Integer[][] get = playsMap.get(genres[i]);
                if(get[0][0] < plays[i]){ // 들어오는게 가장 큰경우
                    playsMap.put(genres[i], new Integer[][] {{plays[i], i},{get[0][0], get[0][1]}});
                }
                else if (get[1][0] < plays[i]){ // 들어오는게 2번째로 큰경우
                    playsMap.put(genres[i], new Integer[][] {{get[0][0], get[0][1]},{plays[i], i}});
                }
            }
        }
        
        
        ArrayList<String[]> list = new ArrayList<>();//장르, 총 재생횟수
        
        for(String s : genresMap.keySet()){
            list.add(new String[] {s, genresMap.get(s).toString()});
        }
        
        Collections.sort(list, (o1, o2) -> { // 총 재생횟수 내림차순
           return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
        });
        
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0; i< list.size(); i++){
            Integer[][] get = playsMap.get(list.get(i)[0]);
            answerList.add(get[0][1]);//장르에서 가장 많이 재생된 곡
            if(get[1][1] != -1){ // 장르에 속한곡이 하나가 아니라면 두번째것도 추가
                answerList.add(get[1][1]);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}