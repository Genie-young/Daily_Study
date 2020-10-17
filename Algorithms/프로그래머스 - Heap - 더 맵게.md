# 프로그래머스 - Heap - 더 맵게

```java
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(); 
        for(int i : scoville)
            pq.offer(i);

        while( pq.peek() < K  ){
            if( pq.size() == 1){
                answer = -1;
                break;
            }
            pq.offer(pq.poll()+(pq.poll()*2)); 
            answer++; 
        }; 
        
        return answer;
    }
}
```


큐에 새로운 데이터를 삽입하는 작업을 의미하며, 이는 리스트의 끝 부분을 가리키는 rear에서 발생하며 데이터가 삽입될 때 하나 증가시킨 후 새로운 데이터를 삽입합니다.

#### 제거 - poll,remove

큐에서 데이터를 제거하는 작업을 의미하며 이는 항상 front에서 발생합니다. front값이 rear를 추월하게 되면 더이상 제거할 데이터가 없는 상태 즉, 자료가 하나도 없는 빈 큐를 의미합니다.

`poll`은 큐가 비어있다면 **null**을 반환
`remove`는 큐가 비어있다면 **예외** 발생

#### 읽기 - peek,element

큐에서 front가 가리키는 데이터를 읽는 작업을 peek이라 합니다. 데이터를 제거하지 않고 읽는 작업만 수행하므로 front값을 변경시키지 않습니다.
`peek`은 큐가 비어있다면 **null**을 반환
`element`은 큐가 비어있다면 **예외** 발생



Stack 내장 함수

| 함수명     | 함수 설명                            |
| ---------- | ------------------------------------ |
| push(item) | 스택 맨 위에 item을 넣음             |
| pop()      | 스택 맨 위 item을 제거하고 객체 반환 |
| peek()     | 스택 맨 위 item 객체를 반환          |
| isEmpty()  | 해당 객체가 비어있는지 boolean 반환  |



Queue 내장 함수

| 함수명      | 함수 설명                                 |
| ----------- | ----------------------------------------- |
| offer(item) | 큐 맨 뒤에 item을 넣음                    |
| poll()      | 큐 맨 앞에 있는 item을 제거하고 객체 반환 |
| peek()      | 큐 맨 앞에 있는 item 객체를 반환          |
| isEmpty()   | 해당 객체가 비어있는지 boolean 반환       |



Priority Queue 내장 함수

| 함수명      | 함수 설명                                                    |
| ----------- | ------------------------------------------------------------ |
| offer(item) | 우선순위 큐에 item을 넣음                                    |
| add(item)   | 우선순위 큐에 item을 넣음 (예외처리)                         |
| poll()      | 우선순위 큐에 따라 가장 작은 값을 제거 하고 객체 반환(empty일 시 null을 반환) |
| remove()    | 우선순위 큐에 따라 가장 작은 값을 제거 하고 객체 반환(empty일 시 예외처리 발생) |
| peek()      | 우선순위 큐에 따라 가장 작은 item 객체를 반환                |
| isEmpty()   | 해당 객체가 비어있는지 boolean 반환                          |



