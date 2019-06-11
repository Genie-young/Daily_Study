from tkinter import *
from tkinter import messagebox
##전역변수 선언부##
#C:\images\Pet_GIF\Pet_GIF(256x256)/cat01_256.gif
dirName="C:\images\Pet_GIF\Pet_GIF(256x256)/"
fnameList = ["cat01_256.gif","cat02_256.gif","cat03_256.gif","cat04_256.gif","cat05_256.gif","cat06_256.gif"]
photoList =[ None] *6
num=0 #현재 사진 순번

##함수 선언부##
def clickPrev():
    global num
    num-=1
    if(num <0 ) :
        num= len(fnameList)-1
    photo = PhotoImage(file=dirName+fnameList[num])
    pLable.configure(image=photo)
    pLable.photo=photo

def clickNext():
    global num
    num+=1
    if(num >= len(fnameList)) :
        num=0
    photo = PhotoImage(file=dirName+fnameList[num])
    pLable.configure(image=photo)
    pLable.photo=photo

def checkPressedKey(event) :
    global num
    pressKey = chr(event.keycode)
    #messagebox.showinfo("키보드 이벤트","눌린 키 :"+chr(event.keycode))
    if(pressKey=="$") :
        num=0;
    elif(pressKey=="#") :
        num = len(fnameList)-1
    elif(pressKey=="'"):
        num+=1
        if (num >= len(fnameList)):
            num = 0
    elif(pressKey=="%") :
        num-=1
        if (num < 0):
            num = len(fnameList) - 1
    elif(pressKey >="0" and pressKey<="9"):
        num+= int(pressKey)
        if (num >= len(fnameList)):
            num = len(fnameList) -1
    elif(pressKey >="a" and pressKey<="i"):
        # print(int(pressKey))
        # num+= (int(pressKey)-int('a')+1)
        # if (num >= len(fnameList)):
        #     num = len(fnameList) -1
        pass 
    photo = PhotoImage(file=dirName+fnameList[num])
    pLable.configure(image=photo)
    pLable.photo=photo

# def pressHome() :
#     global num
#     num=0
#    # messagebox.showinfo("키보드 이벤트", "눌린 키 :" + chr(event.keycode))
#     photo = PhotoImage(file=dirName + fnameList[num])
#     pLable.configure(image=photo)
#     pLable.photo = photo

# def pressHome(event) :
#     global num
#     num=0
#     photo = PhotoImage(file=dirName + fnameList[num])
#     pLable.configure(image=photo)
#     pLable.photo = photo
##메인 코드부##
window = Tk()
window.title('GIF 사진 뷰어(ver 0.01)')
window.geometry("500x300")
window.resizable(width=FALSE, height =TRUE)
photo = PhotoImage(file=dirName+fnameList[num])
pLable = Label(window,image=photo)
btnprev = Button(window, text="<<이전 그림", command=clickPrev)
btnnext = Button(window, text="다음 그림>>", command=clickNext)
btnprev.place(x=250,y=10);btnnext.place(x=450,y=10)
pLable.place(x=15,y=50)
window.bind("<Key>",checkPressedKey)
window.mainloop()