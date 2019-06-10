#간단한 함수는 람다로 작성하기
hap2 = lambda v1, v2 : v1+v2
print(hap2(100,200))

mylist = [1,2,3,4]
def add10(num):
    return num+10

#위의 for문과 아래의 람다식과 같다.
# for i in range(len(mylist)):
#    mylist[i] = add10(mylist[i])
#mylist= list(map(add10,mylist)) #map의 return값은 map iterator 객체(map object)이므로 list로 변환함.
print(map(lambda num : num+10,mylist))
mylist= list(map(lambda num : num+10,mylist))
print(mylist)


# filter(함수, literable)
#두번째 인수인 반복 가능한 자료형 요소들을 첫번째 인자 함수에 하나씩 입력하여 리턴값이 참인 것만 묶어서 돌려준다.