class Solution {
    static int answer = 0;
    static void DFS(int[] numbers, int target, int idx, int num){
        //System.out.println("idx : "+ idx+ " num : "+num);
        if(idx == numbers.length ){
            if(num == target)
                answer++;
            return;
        }
        
        DFS(numbers, target, idx+1, num+numbers[idx]);
        DFS(numbers, target, idx+1, num-numbers[idx]);
        
    }
    public int solution(int[] numbers, int target) {
        
         
        DFS(numbers, target, 1, numbers[0]);
        DFS(numbers, target, 1, -numbers[0]);
        return answer;
    }
}