import operator

ttL = [("토마스",5), ("헨리",8),('에드워드',9),('토마스',12),('에드워드',1)]

tD ={}
tL =[]
tR, cR=1,1
for tmpTup in ttL :
    tName = tmpTup[0]
    tWeight = tmpTup[1]
    if tName in tD :   #딕셔너리를 이터레이터로 사용할 때는 키값만 추출함.
        tD[tName]+= tWeight
    else :
        tD[tName] = tWeight

print(tD)
tL = sorted(tD.items(), key=operator.itemgetter(1), reverse =True)
print(tL)