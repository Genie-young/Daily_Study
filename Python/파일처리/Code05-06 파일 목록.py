import os

for dirName,subDirList, fnames in os.walk('C:/images') : #하위 폴더를 다 긁어서 경로,파일 이름을 다 가져옴 .
    for fname in fnames:
        if os.path.splitext(fname)[1].upper() =="GIF": #split은 dir쪼개서 파일명만 남기는 거, splittext는 파일이름과 파일형식 쪼개기
            print(os.path.join(dirName, fname)) #가져온 경로명과 파일 이름을 더해서 실제 파일 경로를 생성.
