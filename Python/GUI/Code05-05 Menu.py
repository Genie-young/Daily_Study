from tkinter import *
from tkinter import messagebox

window= Tk()

def fileClick():
    messagebox.showinfo("제목", "내용")


mainMenu = Menu(window)
window.config(menu=mainMenu)
filemenu = Menu(mainMenu)
mainMenu.add_cascade(label="파일", menu=filemenu) # cascase는 아래로 확장 가능


editMenu= Menu(mainMenu)
mainMenu.add_command(label="편집", menu=filemenu ,command=fileClick) # cascase는 아래로 확장 가능
filemenu2= Menu(mainMenu)
mainMenu.add_cascade(label="편집", menu=filemenu2) # cascase는 아래로 확장 가능


moveMenu = Menu(mainMenu)
mainMenu.add_cascade(label="이동", menu=moveMenu)
moveMenu.add_command(label ="앞으로")
moveMenu.add_separator()
moveMenu.add_command(label ="뒤로")

jumpMenu = Menu(mainMenu)
mainMenu.add_cascade(label="건너뛰기", menu=jumpMenu)
jumpMenu.add_command(label ="[1]")
jumpMenu.add_separator()
jumpMenu.add_command(label ="[2]")
jumpMenu.add_separator()
jumpMenu.add_command(label ="[3]")
#mainMenu.add_cascade(label="건너뛰기")
# mainMenu.add_command()

window.mainloop()