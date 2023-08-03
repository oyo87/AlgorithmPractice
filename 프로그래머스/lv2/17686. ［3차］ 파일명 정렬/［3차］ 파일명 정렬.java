import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        /*
        정렬 조건을 직접 구현해보자
        */
        
        Arrays.sort(files, (o1,o2) ->{
            /*
            head, number, tail중에서 number부분 인덱스를 알면 세가지를 모두 구할수 있음
            */
            int[] numberIndex1 = getNumberIndex(o1);
            int[] numberIndex2 = getNumberIndex(o2);
            
            String head1 = o1.substring(0, numberIndex1[0]).toLowerCase();
            int number1 = Integer.parseInt(o1.substring(numberIndex1[0], numberIndex1[1]));
            // String tail1 = o1.substring(numberIndex1[1]);
            
            String head2 = o2.substring(0, numberIndex2[0]).toLowerCase();
            int number2 = Integer.parseInt(o2.substring(numberIndex2[0], numberIndex2[1]));
            // String tail2 = o2.substring(numberIndex2[1]);
            
            if(!head1.equals(head2)){//head다를경우 head 사전순 비교
                return head1.compareTo(head2);
            }
            else if(number1 != number2){//head 같고 number 다를경우 number 크기 비교
                if(number1 < number2){
                    return -1;
                }
                else{
                    return 1;
                }
            }
            else{//head, number 같을경우 원래 순서 유지
                return 0;
            }
            
        });
        
        
        return files;
    }
    
    //head, number, tail중 number부분의 시작인덱스와 끝+1인덱스를 구하여 int[]배열에 위치 반환
    public int[] getNumberIndex(String str){
        
        int numberIndex = -1;
        int numberIndexEnd = -1;
        for(int i=0; i<str.length(); i++){
                if('0' <= str.charAt(i) && str.charAt(i) <= '9'){ //처음 숫자를 발견하면 Number의 시작 인덱스
                    numberIndex = i;
                    numberIndexEnd = i;
                    for(int j = i; j < str.length() && j < i+5; j++){ // 숫자가 아니거나 5개까지만
                        if('0' <= str.charAt(j) && str.charAt(j) <= '9'){
                            numberIndexEnd++;
                        }
                        else{
                            break;
                        }
                    }
                    break;
                }
        }
        
        return new int[] {numberIndex, numberIndexEnd};
    }
}
