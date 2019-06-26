from sklearn import svm,metrics
from sklearn.model_selection import train_test_split
import pandas as pd
import joblib

def changeValue(lst):
    return [float(v)/255 for v in lst]

#0. 훈련데이터 테스트 데이터 준비
csv = pd.read_csv("C:/PythonExample/mnist/t10k_1K.csv")
test_data = csv.iloc[:,1:].values
test_data = list(map(changeValue, test_data))
test_label = csv.iloc[:,0].values

clf = joblib.load('mnist_model_1k.dmp')
result = clf.predict(test_data)
#print(result)
score = metrics.accuracy_score(result,test_label)
print("정확도 ==> {0:.2f}%".format(score*100))
import matplotlib.pyplot as plt
##학습된 모델 저장하기

