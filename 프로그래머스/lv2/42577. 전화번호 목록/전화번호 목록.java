import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        Map<String, Integer> map = new HashMap<>();
        
        //전체 phone_book의 번호를 map에 등록
        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i], i);
        }
        
        for(int i=0; i<phone_book.length; i++){ // 전체 phone_book 반복
            for(int j=0; j<phone_book[i].length(); j++){ //개별 phone_book 한글자씩 map에서 찾아봄
                if(map.containsKey(phone_book[i].substring(0,j+1))){ // 만약 찾아보던중에 map에 존재한다면
                    if(map.get(phone_book[i].substring(0,j+1)) != i) //본인이 아니라면
                      return false; // 무언가의 접두어
                }
            }
        }
        return true;
    }
}