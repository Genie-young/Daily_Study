# Day 4. Dictionary 

## 1. 기본구조

>  dic = {키 : 값, 키1 :값 ,키2 :값,,, }

- 키는 중복되지 않는다.
- 순서는 중요하지 않다. 



## 2. 요소 접근

- dic[키] 로 접근. 
- index로는 접근 불가함.



## 3. 예제

각 기차의 합계를 구해서 오름차순 정렬해라.

```python
import operator

ttL = [("토마스",5), ("헨리",8),('에드워드',9),('토마스',12),('에드워드',1)]

tD ={}
tL =[]
tR, cR=1,1
for tmpTup in ttL :
    tName = tmpTup[0]
    tWeight = tmpTup[1]
    if tName in tD :
        tD[tName]+= tWeight
    else :
        tD[tName] = tWeight

print(tD)
tL = sorted(tD.items(), key=operator.itemgetter(1), reverse =True)
print(tL)
```







