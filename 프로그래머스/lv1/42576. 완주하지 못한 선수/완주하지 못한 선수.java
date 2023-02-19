import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String c : completion) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (String p : participant) {
            if (map.containsKey(p) && 0 < map.get(p)) {
                map.put(p, map.get(p) - 1);
            } else {
                return p;
            }
        }
        return answer;
    }
}