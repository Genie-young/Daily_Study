import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        for(String i : completion) {
        	int val = 1;
        	if(hm.containsKey(i))
        		val += hm.get(i);
        	hm.put(i, val );
        }
        
        for(String i : participant){
        	if(!hm.containsKey(i)){	
        		answer = i; 
                break; 
            }else {
            	int val = hm.get(i)-1;
            	if(val == 0) {
            		hm.remove(i);
            	}else
            		hm.put(i, val );
            }
        }
        return answer;
    }
}