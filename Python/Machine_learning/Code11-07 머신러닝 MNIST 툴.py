from tkinter import *
from tkinter.simpledialog import *
from tkinter.filedialog import *
import math
import os
import os.path
from PIL import Image, ImageFilter, ImageEnhance, ImageOps
import time
import pandas as pd
import numpy as np
from sklearn import svm, metrics
from sklearn.model_selection import train_test_split
import joblib

def changeValue(lst):
    return [float(v) / 255 for v in lst]

def studyCSV() :
    global csv, train_data, train_label, test_data, test_label, clf
    global inImage, outImage, inH, inW, outH, outW, window, canvas, paper
    ##0. 훈련데이터, 테스트데이터 준비
    filename = askopenfilename(parent=window,
        filetypes=(("CSV 파일", "*.csv"), ("모든 파일", "*.*")))
    if filename == None or filename == '' :
        return
    csv = pd.read_csv(filename)
    train_data = csv.iloc[:, 1:].values
    train_data = list(map(changeValue, train_data))
    train_label = csv.iloc[:, 0].values
    # 1. Classifire 생성(선택) --> 머신러닝 알고리즘 선택
    clf = svm.SVC(gamma='auto')
    # 2. 데이터로 학습 시키기
    clf.fit(train_data, train_label)
    status.configure(text='훈련 성공 ~~')

def studyDump() :
    global csv, train_data, train_label, test_data, test_label, clf
    global inImage, outImage, inH, inW, outH, outW, window, canvas, paper
    filename = askopenfilename(parent=window,
        filetypes=(("덤프 파일", "*.dmp"), ("모든 파일", "*.*")))
    if filename == None or filename == '' :
        return
    # 학습된 모델 저장하기
    clf = joblib.load(filename)
    status.configure(text='모델 로딩 성공 ~~')

def studySave() :
    global csv, train_data, train_label, test_data, test_label, clf
    global inImage, outImage, inH, inW, outH, outW, window, canvas, paper
    saveFp = asksaveasfile(parent=window, mode='wb',
            defaultextension='.', filetypes=(("덤프 파일", "*.dmp"), ("모든 파일", "*.*")))
    if saveFp == '' or saveFp == None:
        return
    # 학습된 모델 저장하기
    joblib.dump(clf,saveFp.name)
    status.configure(text='저장 성공 ~~~~')

def studyScore() :
    global csv, train_data, train_label, test_data, test_label, clf
    global inImage, outImage, inH, inW, outH, outW, window, canvas, paper
    if clf == None :
        return
    filename = askopenfilename(parent=window,
                               filetypes=(("CSV 파일", "*.csv"), ("모든 파일", "*.*")))
    if filename == None or filename == '':
        return
    csv = pd.read_csv(filename)
    test_data = csv.iloc[:, 1:].values
    test_data = list(map(changeValue, test_data))
    test_label = csv.iloc[:, 0].values
    result = clf.predict(test_data)
    score = metrics.accuracy_score(result, test_label)
    status.configure(text='정답률 : '+ "{0:.2f}%".format(score * 100))


def predictMouse():
    global csv, train_data, train_label, test_data, test_label, clf
    global inImage, outImage, inH, inW, outH, outW, window, canvas, paper
    if clf == None :
        status.configure(text='모델 먼저 생성하삼~~~')
        return

    VIEW_X, VIEW_Y = 280, 280
    canvas = Canvas(window, height=VIEW_X, width=VIEW_Y, bg='black')
    paper = PhotoImage(height=VIEW_X, width=VIEW_Y)
    canvas.create_image((VIEW_Y // 2, VIEW_X // 2), image=paper, state='normal')
    canvas.pack(expand=1, anchor=CENTER)
    status.configure(text='' )
    ## 이벤트 바인드
    canvas.bind('<Button-3>', rightMouseClick)
    canvas.bind('<Button-2>', midMouseClick)
    canvas.bind('<Button-1>', leftMouseClick)
    canvas.bind('<B1-Motion>', leftMouseMove)
    canvas.bind('<ButtonRelease-1>', leftMouseDrop)
    canvas.configure(cursor='mouse')

def malloc(h, w, initValue=0) :
    retMemory= []
    for _ in range(h) :
        tmpList = []
        for _ in range(w) :
            tmpList.append(initValue)
        retMemory.append(tmpList)
    return retMemory

def rightMouseClick(event) :
    global leftMousePressYN
    global csv, train_data, train_label, test_data, test_label, clf
    global inImage, outImage, inH, inW, outH, outW, window, canvas, paper
    inImage = []
    inImage = malloc(280,280)
    ## paper --> inImage
    for i in range(280) :
        for k in range(280) :
            pixel = paper.get(k,i) # (r, g, b)
            if pixel[0] == 0 :
                inImage[i][k] = 0
            else :
                inImage[i][k] = 1
    ## 280 --> 28 축소
    outImage = []
    outImage = malloc(28, 28)
    scale = 10
    for i in range(28) :
        for k in range(28) :
            outImage[i][k] = inImage[i*scale][k*scale]
    ## 2차원 --> 1차원
    my_data = []
    for i in range(28) :
        for k in range(28) :
            my_data.append(outImage[i][k])
    ## 예측하기
    result = clf.predict([my_data]) # 숫자 1개
    status.configure(text='예측 숫자 ====> '+ str(result[0]))

def midMouseClick(event) :
    global leftMousePressYN
    global csv, train_data, train_label, test_data, test_label, clf
    global inImage, outImage, inH, inW, outH, outW, window, canvas, paper
    outH, outW = 280, 280
    stepX, stepY = 1, 1
    import numpy
    rgbStr = ''  # 전체 픽셀의 문자열을 저장
    for i in numpy.arange(0, outH, stepX):
        tmpStr = ''
        for k in numpy.arange(0, outW, stepY):
            i = int(i);
            k = int(k)
            r, g, b = 0,0,0
            tmpStr += ' #%02x%02x%02x' % (r, g, b)
        rgbStr += '{' + tmpStr + '} '
    paper.put(rgbStr)

leftMousePressYN = False
def leftMouseClick(event) :
    global  leftMousePressYN
    leftMousePressYN = True

def leftMouseMove(event) :
    global leftMousePressYN
    global csv, train_data, train_label, test_data, test_label, clf
    global inImage, outImage, inH, inW, outH, outW, window, canvas, paper
    if leftMousePressYN == False :
        return
    x = event.x; y = event.y
    # 주위 40x40개를 찍는다.
    for i in range(-15,15,1) :
        for k in range(-15,15,1) :
            if 0<= x+i < 280 and 0 <= y+k < 280 :
                paper.put("#%02x%02x%02x" % (255,255,255), (x+i, y+k))


def leftMouseDrop(event) :
    global leftMousePressYN
    leftMousePressYN = False
####################
#### 전역변수 선언부 ####
####################
R, G, B = 0, 1, 2
inImage, outImage = [], []  # 3차원 리스트(배열)
inH, inW, outH, outW = [0] * 4
window, canvas, paper = None, None, None
filename = ""
VIEW_X, VIEW_Y = 512, 512 # 화면에 보일 크기 (출력용)
# 머신러닝 관련 전역 변수
csv, train_data, train_label, test_data, test_label, clf = [None]*6
####################
#### 메인 코드부 ####
####################
window = Tk()
window.geometry("500x500")
window.title("머신러닝 툴 (MNIST) ver 0.01")

status = Label(window, text='', bd=1, relief=SUNKEN, anchor=W)
status.pack(side=BOTTOM, fill=X)

## 마우스 이벤트
mainMenu = Menu(window)
window.config(menu=mainMenu)

fileMenu = Menu(mainMenu)
mainMenu.add_cascade(label="학습 시키기", menu=fileMenu)
fileMenu.add_command(label="CSV 파일로 새로 학습", command=studyCSV)
fileMenu.add_command(label="학습된 모델 가져오기", command=studyDump)
fileMenu.add_separator()
fileMenu.add_command(label="정답률 확인하기", command=studyScore)
fileMenu.add_separator()
fileMenu.add_command(label="학습모델 저장하기", command=studySave)


predictMenu = Menu(mainMenu)
mainMenu.add_cascade(label="예측하기", menu=predictMenu)
predictMenu.add_command(label="그림 파일 불러오기", command=None)
predictMenu.add_separator()
predictMenu.add_command(label="마우스로 직접 쓰기", command=predictMouse)


window.mainloop()