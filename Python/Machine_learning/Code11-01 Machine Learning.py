""" XOR게이트
from sklearn import svm


##1. classifier 생성(선택) --> 머신러닝 알고리즘 선택
clf = svm.SVC()

## 데이터로 학습 시키기
#clf.fit([훈련데이터], [정답])
clf.fit([[0,0],[0,1],[1,0],[1,1]],[0,1,1,0])

#예측하기
#clf.predict([예측할 데이터])
result = clf.predict([[1,1]])
print(result)
"""

