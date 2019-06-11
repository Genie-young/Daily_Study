from tkinter import *
from tkinter import messagebox
window = Tk()
label = Label(window, text = "파이썬 공부")
photo = PhotoImage(file="C:\images\Pet_GIF\Pet_GIF(256x256)/cat01_256.gif") #경로는 한글x 바탕화면x 띄어쓰기x
label4 = Label(window,image=photo)
def clickButton() :
    messagebox.showinfo("요기제목","요기내용")
button1 = Button(window, text="나를 눌러줘", command=clickButton)
button2 = Button(window, text="나를 눌러줘", command=clickButton, image=photo)
label4.pack()
button1.pack()
button2.pack()
window.mainloop()
