# from tkinter import *
#
# window = Tk()
# label = Tk.Label(window, text="Hello World", padx=10, pady=10)
# label.pack()
# window.mainloop()


import tkinter as tk

window = tk.Tk()
window.title("Park Ji Young")
window.resizable(True, True)
label = tk.Label(window, text="Hello World", padx=100, pady=100)  #pad는 기본 창크기
label.pack()
window.geometry("640x400+100+100")
label=tk.Label(window, text="파이썬", width=10, height=5, fg="red", relief="solid")
label.pack()

window.mainloop()