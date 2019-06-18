# Day 10. Numpy

```Python
import numpy as np
import random


##랜덤함수##
np.random.seed(0)#씨드 설정하기 
data = np.random.randn(2,3)
Vector = np.random.rand(5);
print("Random Data==>", data) #2행3열짜리 랜덤 변수 생성 
np.random.choice(Vector, size=None, replace=True, p=None) #샘플링
np.random.shuffle(Vector) #원소의 순서를 바꿈.

##리스트 연산## 
dataList = [[random.random() for _ in range(3)]for _ in range(2)]
print(data[0][0])
A = [[10,20],[30,40]]
B = [[1,2],[3,4]]
print(A+B)  ##리스트 연산 결과는 [[10, 20], [30, 40], [1, 2], [3, 4]]
AA = np.array(A)
BB = np.array(B)
print(AA+BB)  #np배열의 연산 결과 [[11 22] ,[33 44]] ==> 각 행렬의 위치마다 더함
print(A*2) #A*2 = [[10,20],[30,40],[10,20],[30,40]]
print(AA*2) #AA*2 = [[20,40],[60,80]]

##벡터와 매트릭스## 
V1 = np.array([1,2,3]) #벡터==> 1차원
V2 = np.array([4,5,6]) #2차원 매트릭스
print(data.shape) ##2행 3열 확인
print(data.reshape(3,2)) #기존 행렬값을 3행 2열로  재배치함.  #모든 값을 일렬로 았을 때 이걸 행수로 자르는 듯함.
data.T #전치 행렬로 바꿈.===> 행과 열을 바꿈 .
list1 = [n for n in range(10, 70,10)]
AA= np.array(list1)  #리스트를 np배열로 변경
BB = AA.reshape(3,2) #1차원 행렬을 2차원으로 만듦
print(BB)


BB [0][1]; BB [0,1]; # 두 형태가 같은 의미
BB[:, 0] #모든 행의  0번째열 
BB[0: -1, 1: 2 ]  #==> 0행부터 끝행 바로 전행까지 선택, 1열선택 random
CC = BB[:, :] # ==> 복사
CC = BB # ==> 객체 참조 동일한 주소값 공유
list2 =[n for n in range(10,90,10)]
AA = np.array(list2).reshape(2,4)
print(AA)

##np배열 iterator로 변환==> 비추, 속도가 느림. ## 
it = np.nditer(AA, flags = ['multi_index'], op_flags = ['readwrite']) #iterator로 변환함. 
while not it.finished :
    idx = it.multi_index
    print(AA[idx])
    it.iternext()
    
##concatenate 함수## 
""" 번외, 리스트를 사용할 때에 아래의 방법이 그나마 빠름
def method5():
  from cStringIO import StringIO
  file_str = StringIO()
  for num in xrange(loop_count):
    file_str.write(`num`)

  return file_str.getvalue()
"""
##DD = np.concatenate((AA, np.array([1,2,3,4])), axis = 1)
##print(DD)
BB  = np.array([1,2,3,4])
BB =BB.reshape(1,4)
CC = np.concatenate((AA,BB),axis=0) #axis = 1을 기준으로 조인함. 테스트 더 해봐야함.

##영행렬, 단위행렬## 
np.zeros([2,3], dtype=np.uint8) #unsigned int 8byte의 np배열을 만듦. 
np.eye(2) #길이 2인 정사각형 단위행렬 생성  
```

1. random함수  ==>난수 생성 

   - randn 명령은 기댓값이 0이고 표준편차가 1인 가우시안 표준 정규 분포를 따르는 난수를 생성

   - rand: 0부터 1사이의 균일 분포

   - randint: 0부터 1사이의 균일 분포에서의 정수

     

2. np배열 확인 함수

   ```Python
   print(AA.shape) #행,열정보 리턴
   print(AA.dtype) #데이터 타입 리턴
   AA.ndim #차원정보를 리턴
   ```

   