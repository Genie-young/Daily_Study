from sklearn import svm,metrics
from sklearn.model_selection import train_test_split
import pandas as pd

def changeValue(lst):
    return [float(v)/255 for v in lst]

#0. 훈련데이터 테스트 데이터 준비
csv = pd.read_csv("C:/PythonExample/mnist/train_1K.csv")
train_data = csv.iloc[:,1:].values
train_label = csv.iloc[:,0].values
train_data = list(map(changeValue, train_data))
csv = pd.read_csv("C:/PythonExample/mnist/t10k_1K.csv")
test_data = csv.iloc[:,1:].values
test_data = list(map(changeValue, test_data))
test_label = csv.iloc[:,0].values

#훈련용

##1. classifier 생성(선택) --> 머신러닝 알고리즘 선택
clf = svm.NuSVC(gamma="auto")
## 데이터로 학습 시키기
#clf.fit([훈련데이터], [정답])
clf.fit(train_data,train_label)

#예측하기
#clf.predict([예측할 데이터])

result = clf.predict(test_data)
print(result)
score = metrics.accuracy_score(result,test_label)
print("정확도 ==> {0:.2f}%".format(score*100))
import matplotlib.pyplot as plt
import numpy as np
#img =np.array(test_data[0].reshape(28,28))
#plt.imshow()

