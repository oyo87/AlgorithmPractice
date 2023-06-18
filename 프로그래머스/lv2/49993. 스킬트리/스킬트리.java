class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        //완탐접근 가능해보임
        //skill탐색하면서 각각 순서 저장 ex)cbd면 c0, b1, d2
        //skill_trees 길이만큼 반복
        //매탐색마다 skill앞에서부터 일치하는지확인하면서 일치하면 count와 비교, 맞으면 count++, 아니면 continue
        int[] order = new int[26];
        for(int i=0; i<order.length; i++){
            order[i] = -1;
        }
        for(int i=0; i<skill.length(); i++){
            order[skill.charAt(i) - 'A'] = i;
        }
        loop : for(int i=0; i< skill_trees.length; i++){
            int count = 0;
            for(int j=0; j<skill_trees[i].length(); j++){
                //선행스킬을 배우지않고 나중 스킬을 배우려는경우 불가능
                if(order[skill_trees[i].charAt(j)-'A'] != -1 && 
                   order[skill_trees[i].charAt(j)-'A'] != count){
                    continue loop;
                }
                //선행스킬에 맞는걸 배우는경우 다음스킬배울수있게 count증가
                else if(order[skill_trees[i].charAt(j)-'A'] != -1 && 
                        order[skill_trees[i].charAt(j)-'A'] == count){
                    count++;
                }
                //선행스킬과 관련없는스킬배우면 넘어감
            }
            answer++;
        }
        
        return answer;
    }
}