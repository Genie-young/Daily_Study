from tkinter import *
from tkinter.simpledialog import *
from tkinter.filedialog import *
import math
import os
import os.path

######################
##### 함수 선언부 ####
######################
#파일을 메모리로 로딩하는 함수
def malloc(h,w):
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    returnMemory =[]
    for _ in range(h):
        tmpList = []
        for _  in range(w) :
            tmpList.append(0)
        returnMemory.append(tmpList)
    return returnMemory

def loadImage(fname):
    global window, canvas, paper, inImage, outImage, inW, inH, outW, outW, filename
    fsize = os.path.getsize(fname) #파일 크기(바이트)
    inH = inW = int(math.sqrt(fsize))

    inImage =[]
    inImage=malloc(inH,inW)
    #파일 --> 메모리
    with open(filename, "rb") as rFp:
        for i in range(inW):
            for k in range(inW):
                test =rFp.read(1) #rFp를 read 하면 15진수 값으로 불러옴. 이걸 정수값(0~255)으로 변환
                print(ord(test))
                inImage[i][k] = int(ord(test))

    #print(int(ord(inImage[80][80]))) #ord는 문자에 해당하는 숫자로 바꿔줌.

#파일 선택해서 메모리로 로딩하는 함수
def openImage():
    global window, canvas, paper,inImage, outImage,inW, inH, outH, outW, filename
    filename = askopenfilename(parent=window, filetypes=(("text파일", "*.raw"), ("모든 파일", "*.*")))
    loadImage(filename)
    equalImage()

import struct #1byte씩 저장을 도와주는 패키지 ==> 자주 사용하진 않음.
def saveImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    saveFp = asksaveasfile(parent=window, mode ="wb",defaultextension="*.raw", filetypes=(("raw파일", "*.raw"), ("모든 파일", "*.*")))
    if saveFp=='' or saveFp==None :
        return
    for i in range(outH) :
        for k in range(outW):
            saveFp.write(struct.pack("B", outImage[i][k]))

def displayImage() :
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    if(canvas != None) :
        canvas.destroy()

    ## 윈도우창 맞추기
    window.geometry(str(outH)+'x'+str(outW))

    canvas = Canvas(window,height =outH, width=outW)
    paper = PhotoImage(height =outH, width=outW)
    canvas.create_image((outH//2, outW//2),image =paper,state='normal')


    # for i in range(inH):
    #     for k in range(inW):
    #         r =g=b = outImage[i][k]
    #         paper.put("#%02x%02x%02x"%(r,g,b),(k,i))
    ##성능개선
    rgbStr ='' #전체 필셀의 문자열을 저장
    for i in range(outH) :
        tmp=""
        for k in range(outW) :
            r=g=b=outImage[i][k]
            tmp += " #%02x%02x%02x"%(r,g,b)
        rgbStr+='{'+tmp+'} '

    paper.put(rgbStr)

    canvas.bind('<Button-1>', mouseClick)
    canvas.bind('<ButtonRelease-1>', mouseDrop)
    canvas.pack(expand =1,anchor=CENTER)



##### 컴퓨터 비전(영상처리) 알고리즘 함수 모음 #####
def equalImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)

    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    for i in range(inH):
        for k in range(inW) :
            outImage[i][k] = inImage[i][k]
    displayImage()


def addImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)

    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    value = askinteger("밝게하기", "밝게할 값-->",minvalue=1,maxvalue=255)
    for i in range(inH):
        for k in range(inW) :
            outImage[i][k] = (inImage[i][k]+value)
            if(outImage[i][k] > 255):
                outImage[i][k]=255
    displayImage()

def subtImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)

    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    value = askinteger("어둡게하기", "어둡게 할 값-->",minvalue=1,maxvalue=255)
    for i in range(inH):
        for k in range(inW) :
            outImage[i][k] = (inImage[i][k]-value)
            if(outImage[i][k] <0):
                outImage[i][k]=0
    displayImage()

def mulImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)

    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    value = askinteger("곱하기", "곱할 값-->",minvalue=1,maxvalue=255)
    for i in range(inH):
        for k in range(inW) :
            outImage[i][k] = (inImage[i][k]*value)
            if(outImage[i][k] > 255):
                outImage[i][k]=255
    displayImage()

def divImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)

    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    value = askinteger("빼기", "뺄 값-->",minvalue=1,maxvalue=255)
    for i in range(inH):
        for k in range(inW) :
            outImage[i][k] = (inImage[i][k]//value)
    displayImage()

def oppImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)

    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    for i in range(inH):
        for k in range(inW) :
            outImage[i][k] = (255-inImage[i][k])
            if(outImage[i][k] <0):
                outImage[i][k]=0
    displayImage()

def binImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)

    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    for i in range(inH):
        for k in range(inW) :
            if(inImage[i][k] >126):
                outImage[i][k] = 255
            else :
                outImage[i][k]=0
    displayImage()

def meanImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)

    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    meanvalue = 0
    for i in range(inH):
        for k in range(inW) :
            meanvalue += inImage[i][k]
    meanvalue = meanvalue//(outW*outH)

    messagebox.showinfo("화소의 평균값","평균값 -->" +str(meanvalue))



#파라볼라 알고리즘 with LUT
def paraImage() :
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)
    LUT = [0 for _ in range(256)]
    for input in range(256) :
        LUT[input] = int(255-255* math.pow(input/128 -1,2))
    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    for i in range(inH):
        for k in range(inW) :
            outImage[i][k] =LUT[inImage[i][k]]
    displayImage()

#상하반전알고리즘
def upDownImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)

    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    for i in range(inH):
        for k in range(inW) :
            outImage[inH-i-1][k] = inImage[i][k]
    displayImage()

#화면이동 알고리즘.
def moveImage():
    global panYN
    panYN = True

def mouseClick(event):
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    global panYN,sx,sy,ex,ey
    if(panYN == False):
        pass
    sx=event.x ;
    sy=event.y ;


def mouseDrop(event) :
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    global panYN, sx, sy, ex, ey

    if(panYN == False):
        pass
    ex=event.x ;
    ey=event.y ;

    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)
    mx = sx-ex;my=sy-ey
    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    for i in range(inH):
        for k in range(inW) :
            if 0<= i - my < outW and 0 <=k-mx < outH :
                outImage[i-my][k-mx] = inImage[i][k]

    panYN = False
    displayImage()

def upDownImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)

    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    for i in range(inH):
        for k in range(inW) :
            outImage[inH-i-1][k] = inImage[i][k]
    displayImage()

#오른쪽 90도 회전 알고리즘
def rotationImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    outW = inW
    outH = inH
    outImage = []
    outImage = malloc(outH, outW)
    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    for i in range(inH):
        for k in range(inW) :
            outImage[i][k] = inImage[outW-k-1][i]
    displayImage()


#상하좌우이동알고리즘
def rotationImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    #중요코드 출력 영상 크기 결정
    direc = askinteger("좌우이동", "좌=1, 우=2, 상 =3, 하 =4")
    changeval= askinteger("이동값", "이동할 값을 선택하세요 -->")
    outW = inW
    outH = inH
    if(direc ==1 or direc == 2) :
        outW += changeval
    elif(direc == 3 or direc == 4) :
        outH += changeval
    outImage = []
    outImage = malloc(outH, outW)
    ############# 진짜 컴퓨터 비전 알고리즘 ##############
    if(direc == 1) :
        s = chanval;

    for i in range(inH):
        x = i+changeval
        for k in range(inW) :
            y = k+changey
            outImage[x][y] = inImage[i][k]
    displayImage()


######################
### 전역변수 선언부 ##
######################
inImage, outImage =[], []
inW, inH, outH, outW = [0]*4 #이렇게 하면 [0,0,0,0]이 되서 변수마다 하나씩 들어감.
window, canvas, paper = [None]*3
filename = ""
panYN = False
sx,sy,ex,ey = [0]*4

######################
##### 메인 코드 ######
######################

window = Tk()
window.geometry("500x500")
window.title("컴퓨터 비전(딥러닝) ver 0.01")
window.resizable(True, True)
nowFileName = ""
text = Text(window)

##마우스 이벤트

mainMenu = Menu(window)
window.config(menu=mainMenu)
window.title("메모장")

fileMenu = Menu(mainMenu)
mainMenu.add_cascade(label="파일",menu=fileMenu)
fileMenu.add_command(label="열기",command=openImage)
fileMenu.add_command(label="저장",command=saveImage)

comvisionMenu2 = Menu(mainMenu)
mainMenu.add_cascade(label="화소처리",menu=comvisionMenu2)
comvisionMenu2.add_command(label="밝게하기",command=addImage)
comvisionMenu2.add_command(label="어둡게하기",command=subtImage)
comvisionMenu2.add_command(label="영상곱셈",command=mulImage)
comvisionMenu2.add_command(label="영상나눗셈",command=divImage)
comvisionMenu2.add_command(label="화소값 반전",command=oppImage)
comvisionMenu2.add_command(label="이진화",command=binImage)
comvisionMenu2.add_command(label="평균값",command=meanImage)
comvisionMenu2.add_command(label="파라볼라 변환",command=paraImage)

comvisionMenu1 = Menu(mainMenu)
mainMenu.add_cascade(label="기하학 처리",menu=comvisionMenu1)
comvisionMenu1.add_command(label="상하반전",command=upDownImage)
comvisionMenu1.add_command(label="이동",command = moveImage)
comvisionMenu1.add_command(label="축소",command = moveImage)
comvisionMenu1.add_command(label="오른쪽 90도 회전",command=rotationImage)
window.mainloop()
