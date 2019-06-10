#전역변수와 지역변수의 이름은 보통 다르게 설정함. 똑같이 하면 잘못하는 코딩 #헝가리안 표기법 배우기
def func1() :
    global a #선언과 동시에 값할당은 안됨.
    a=10
    print('func1-->',a)

def func2():
    print('func2-->',a)

a=1234
func1()
func2()


##두 수를 받아서 연산 값을 반환하는 함수
def calc(v1,v2,v3 = 0):
    result1 = v1+v2 +v3
    result2 = v1-v2 -v3
    return result1,result2

def calc2(*para) :  #여러개를 받을 때, para는 튜플이다.
    res = 0
    for num in para :
        res += num
    return res

hap1, hap2 = calc(100,200,300)
print(hap1,hap2)
hap = calc2(12,3,3,4,5,6,7)
print(hap)
