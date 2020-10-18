import java.util.*;

class Solution {
    static HashSet<Integer> hs = new HashSet<Integer>();
    public void BFS(int[][] computers, int i,Queue<Integer> queue,int n ){
        for(int k = 0;k<n ; k++){
            if(computers[i][k] == 1 && hs.contains(k)){
                queue.add(k);        
            }
        }
        hs.remove(i);
        if(!queue.isEmpty())
            BFS(computers,queue.poll(),queue,n);
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i=0 ;i<n;i++)
            hs.add(i);
        for(int i = 0;i<n;i++){
            if(hs.contains(i)){
                BFS(computers, i,queue,n);
                answer++;
            }
        }
        return answer;
    }
}

/*
  1 2 3
1 1 1 0
2 1 1 0
3 0 0 1
*/