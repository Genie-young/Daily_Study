# Day 5. 파일

1. 파일 종류 
   - text : ASCII파일, ini 메모장, *.txt인 모든 파일 . .py인 파일 
   - Binary : 이진 파일, .gif와 같은 사진, 동영상 등 텍스트를 제외한 파일 

```python
import os

#하위 폴더를 다 긁어서 경로,파일 이름을 다 가져옴 .
for dirName,subDirList, fnames in os.walk('C:/images') : 
    for fname in fnames:
        #split은 dir쪼개서 파일명만 남기는 거, splittext는 파일이름과 파일형식 쪼개기
        if os.path.splitext(fname)[1].upper() =="GIF": 
            #가져온 경로명과 파일 이름을 더해서 실제 파일 경로를 생성.
            print(os.path.join(dirName, fname)) 
```



```python
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
```

- inFp = open("c:/windows/win.ini","rt")를 사용하면 inFp.close() 반드시 해야하지만

  ```python
  with open(filename,'r') as rFp 
  ```

  with open(filename,'r') as rFp 를 사용하면 자동으로 close 된다.

