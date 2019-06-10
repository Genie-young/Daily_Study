import random

mylist = []

#append 예제
for i in range(10) :
    mylist.append(i)  #공간을 추가할당하여 대입함.

#pop 함수 예제
mylist.pop() #마지막 항목이 삭제됨 ==> 9
mylist.pop(0) #해당 인덱스의 값을 반환함.



##insert 함수 예제
#sort 예제
mylist.sort(reverse=True) #내림차순 정렬==> [8,7,6,5,4,3,2,1]
sorted(mylist)  #mylist자체는 변하지 않음.
sorted(mylist,reverse=True)


##index함수 예제
myList = [random.randint(1,5) for _ in range(10)]
NUMBER  =5

print(myList)
index = 0
while True :
    try:
        n = myList.index(NUMBER, index) #인덱스 위치에서 NUMBER를 찾음.
        print(n)
        index+=1
    except :
        break;
n = myList.index(NUMBER, 0)  # 인덱스 위치에서 NUMBER를 찾음.
print(n)

##copy 함수
copylist = mylist[:]
copylist = mylist.copy()

##count 함수
mylist.count(1) #1이 나온 횟수를 출력함.
