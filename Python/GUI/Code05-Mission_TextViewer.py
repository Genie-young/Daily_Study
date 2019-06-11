
from tkinter.filedialog import *
from tkinter.simpledialog import *
import os
def doClick() :
    def clickButton():
        askstring( "변경할 문자열을 입력하세요", inStr)

    contentButton = Button(window, text="나를 눌러줘", command=clickButton)
    contentButton.pack();

def openFile():
    global fileName
    fileName = askopenfile()
    fileName=fileName.name
    inFp = open(fileName,"rt") #read-text
    global inStr
    inStr = ""
    while (True):           #파일 한 줄씩 읽어오기
        tmp = inFp.readline()
        if not tmp:
            break;
        inStr+=tmp
    print(inStr)

    global contentLabel,boxStr
    contentLabel = Label(window, text =inStr)
    contentLabel.pack()
    boxStr = StringVar()
    myEntryBox = Entry(window,width =30,textvariable = boxStr)
    myEntryBox.pack()
    inFp.close()

def saveFile():
    changedtxt = boxStr.get()
    outFp = open(fileName,"wt") #read-text
    outFp.writelines(changedtxt)
    outFp.close()

window= Tk()
#window.geometry("1000")
mainMenu = Menu(window)
window.config(menu=mainMenu)
filemenu = Menu(mainMenu)
mainMenu.add_cascade(label="파일", menu=filemenu) # cascase는 아래로 확장 가능
filemenu.add_command(label="열기", command=openFile) # cascase는 아래로 확장 가능
filemenu.add_command(label="저장", command=saveFile) # cascase는 아래로 확장 가능

window.mainloop()