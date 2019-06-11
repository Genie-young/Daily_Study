inFp = open("c:/windows/win.ini","rt")
outFp = open("c:/images/new_win.ini","w")


while(True):    #이건 데이터양이 많아도 하나씩 읽기때문에 다운은 안됨.
    inStr = inFp.readline()
    if not inStr :
        break;
    outFp.writelines(inStr)

# inStrList = inFp.readlines()
# print(inStrList)

inFp.close()
outFp.close()