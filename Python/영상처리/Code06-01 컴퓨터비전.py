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
                test =rFp.read(1) #rFp를 read 하면 15진수 값으로 불러옴.
                print(ord(test))
                inImage[i][k] = int(ord(test))

    #print(int(ord(inImage[80][80]))) #ord는 문자에 해당하는 숫자로 바꿔줌.

#파일 선택해서 메모리로 로딩하는 함수
def openImage():
    global window, canvas, paper,inImage, outImage,inW, inH, outH, outW, filename
    filename = askopenfilename(parent=window, filetypes=(("text파일", "*.raw"), ("모든 파일", "*.*")))
    loadImage(filename)
    equalImage()


def saveImage():
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    pass

def displayImage() :
    global window, canvas, paper, inImage, outImage, inW, inH, outH, outW, filename
    if(canvas != None) :
        canvas.destroy()

    ## 윈도우창 맞추기
    window.geometry(str(outH)+'x'+str(outW))
    canvas = Canvas(window,height =outH, width=outW)
    paper = PhotoImage(height =outH, width=outW)
    canvas.create_image((outH//2, outW//2),image =paper,state='normal')

    for i in range(inH):
        for k in range(inW):
            r =g=b = outImage[i][k]
            paper.put("#%02x%02x%02x"%(r,g,b),(k,i))
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

######################
### 전역변수 선언부 ##
######################
inImage, outImage =[], []
inW, inH, outH, outW = [0]*4 #이렇게 하면 [0,0,0,0]이 되서 변수마다 하나씩 들어감.
window, canvas, paper = [None]*3
filename = ""


######################
##### 메인 코드 ######
######################

window = Tk()
window.geometry("500x500")
window.title("컴퓨터 비전(딥러닝) ver 0.01")
window.resizable(True, True)
nowFileName = ""
text = Text(window)

mainMenu = Menu(window)
window.config(menu=mainMenu)
window.title("메모장")

fileMenu = Menu(mainMenu)
mainMenu.add_cascade(label="파일",menu=fileMenu)
fileMenu.add_command(label="열기",command=openImage)
fileMenu.add_command(label="저장",command=saveImage)

comvisionMenu1 = Menu(mainMenu)
mainMenu.add_cascade(label="알고리즘A",menu=comvisionMenu1)
comvisionMenu1.add_command(label="알고리즘1",command=None)
comvisionMenu1.add_command(label="알고리즘2",command=None)



window.mainloop()
