from sklearn import svm,metrics


##1. classifier 생성(선택) --> 머신러닝 알고리즘 선택
train_data = [[0,0],[0,1],[1,0],[1,1]];
train_label = [0,0,0,1]
test_data = [[1,0],[0,0]]
test_label =[1,0]

clf = svm.SVC(gamma="auto")
## 데이터로 학습 시키기
#clf.fit([훈련데이터], [정답])
clf.fit(train_data,train_label)

#예측하기
#clf.predict([예측할 데이터])

result = clf.predict(test_data)
score = metrics.accuracy_score(result,test_label)
print("정확도 ==>", score)


