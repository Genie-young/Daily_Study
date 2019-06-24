from sklearn import svm,metrics
import pandas as pd

"""
붓꽃 데이터 분류(머신러닝)
- 개요 : 150개 붓꽃 정보(꽃받침길이, 꽃받침폭, 꽃잎 길이, 꽃잎 폭)
- 종류 : 3개(Iris-sentosa, Iris-versicolor, Iris-virginica)
- csv 파일 : 검색 iris.csv
"""


#0. 훈련데이터 테스트 데이터 준비
csv = pd.read_csv("C:/PythonExample/CSV/iris.csv")
train_data = csv.iloc[0:120,0:-1] #행의 위치에 따라 불러옴, csv.loc[]는 행의 이름이 0인것을 찾아옴.
train_label = csv.iloc[0:120,[-1]]
test_data = csv.iloc[120:,0:-1]
test_label = csv.iloc[120:,[-1]]

##1. classifier 생성(선택) --> 머신러닝 알고리즘 선택
clf = svm.SVC(gamma="auto")
## 데이터로 학습 시키기
#clf.fit([훈련데이터], [정답])
clf.fit(train_data,train_label)

#예측하기
#clf.predict([예측할 데이터])

result = clf.predict(test_data)
#print(result)
score = metrics.accuracy_score(result,test_label)
print("정확도 ==> {0:.2f}%".format(score*100))


