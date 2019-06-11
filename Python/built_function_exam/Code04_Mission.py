data = ["A37B", "23CC", "88D9", "BB8F","3A9A"]  #기존 16진수 데이터
data_decimal= [];  #10진수로 바꿀 새 리스트 생성
for i in range(len(data)): #16진수를 10진수를 바꾸는 반복문 *주의 int(문자열, 문자열의 원래 진수값) *
    data_decimal.append(int( data[i] , 16))
print("==>기본 10진수값 " ,data_decimal)

def printHex(para):
    for i in range(len(para)):
        para[i]=hex(para[i])
    return para


##선택정렬
def SelectionSort(ss):
    for i in range(0, len(ss) - 1):  # 길이 마지막 전 요소까지 정렬하면 모두 정렬됨. //N-2은 정렬 안해도 N-2하면서 자동 정렬.
        min = i  # 작은 값을 찾을 때마다 swap하면 시간이 많이 소요되므로 min인덱스만 저장했다가 라운드의 마지막에 한번만 바꿈.
        for j in range(i + 1, len(ss)):
            if (ss[j] < ss[min]):  # 만약 min위치의 값이 현재 검사하는 값보다 크면 min을 현재인덱스로 변경
                min = j
        ss[i], ss[min] = ss[min], ss[i]  # 두 값을 바꿈.#파이썬의 swap은 temp를 사용하지 않아도 되서 간편하다! 이유는 튜플로 변환해서!
    return ss


originalArray  = data_decimal.copy() #selection sort에 사용할 배열로 copy
afterSS = SelectionSort(originalArray[:])
print("\n===========선택정렬============")
print("==>10진수 결과값 " ,afterSS)
print("==>16진수 결과값 " ,printHex(afterSS))


##버블 정렬
def BubbleSort(bs):
    for i in range(len(bs)):
        flag = False
        for k in range(len(bs) - i - 1):  # 각 순회마다 len(bs) -i번째에 있는 요소가 정렬되기 때문에 다음 순회에서는 그 전까지 순회한다. 또한 k+1까지 비교하니까 -1을 해줘야지 인덳가 넘어가지 않는다.
            if (bs[k] > bs[k + 1]):  # 다음에 있는 값과 비교함.
                bs[k], bs[k + 1] = bs[k + 1], bs[k]  # 두 값을 바꿈.
                flag =True
        if (flag==False):
            break;
    return bs

afterBS = BubbleSort(originalArray[:])
print("\n===========버블정렬============")
print("==>10진수 결과값 :" ,afterBS)
print("==>16진수 결과값 " ,printHex(afterBS))

##퀵정렬
def QuickSort(arr):
    if len(arr) <= 1: #arrd의 크기가 1보다 작으면, 즉 정렬할 게 더이상 없을 정도로 크기가 작아지면 종료
        return arr
    pivot = arr[len(arr) // 2]  #피봇은 중간값으로
    lesser_arr, equal_arr, greater_arr = [], [], [] #작은거, 같은거, 큰거로 리스트 쪼개기
    for num in arr:
        if num < pivot:
            lesser_arr.append(num)
        elif num > pivot:
            greater_arr.append(num)
        else:
            equal_arr.append(num)
    return QuickSort(lesser_arr) + equal_arr + QuickSort(greater_arr)

afterQS = QuickSort(originalArray[:])
print("\n===========퀵정렬============")
print("==>10진수 결과값 :" ,afterQS)
print("==>16진수 결과값 " ,printHex(afterQS))


print("\n\n")
print("==============================================예제 2, 문자와 숫자가 섞인 데이터 정렬하기=========================================")
originList =["A37B","23CC","88D9","BB8F","3A9A"]
extractList =[]
for txt in originList :
    num =""
    for j in range(len(txt)):
        if txt[j] >="0" and txt[j]<="9" :  #숫자만 캐치해서 붙여넣기
            num+=txt[j]
    extractList.append(int(num)) #하나의 리스트로 만들기. 순서는 추출한 원본 순서와 같음
txtDic = {} #추출값 = 원값 형식으로 Dic형식으로 변경해서 추출값으로 원값을 바로 찾을 수 있게함. !!!주의!!! 추출값이 중복되면 안됨.
for i in  range(len(extractList)):
    txtDic[extractList[i]] = originList[i];
print("==> txt 전처리",txtDic)

##선택정렬
afterSS = SelectionSort(extractList[:])
restoreSS = []
for i in afterSS :
    restoreSS.append(txtDic[i])
print("\n===========선택정렬============")
print("==>결과값 :" ,restoreSS)

##버블정렬
afterBS = BubbleSort(extractList[:])
restoreBS = []
for i in afterBS :
    restoreBS.append(txtDic[i])
print("\n===========버블정렬============")
print("==>결과값 :" ,restoreBS)

##퀵정렬
afterQS = QuickSort(extractList[:])
restoreQS = []
for i in afterQS :
    restoreQS.append(txtDic[i])
print("\n===========퀵정렬============")
print("==>1결과값 :" ,restoreQS)