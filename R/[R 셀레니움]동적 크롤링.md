# [R 셀레니움]동적 크롤링



1. 첨부 파일을 컴퓨터에 편한 곳에 다운로드 받아서 압축 해제 한다. 

2. cmd창을 켜서 압축한 곳으로 이동한다. 

   <예시> ==> 바탕화면에 압축 화면을 했다면 

   ```cmd
   cd /
   cd C:\Users\계정명\Desktop 
   ```



3. 다음의 명령어 입력

   ```cmd
   cd selenium-server-standalone-master\selenium-server-standalone-master\bin
   
   java -jar selenium-server-standalone.jar -port 4445
   ```

   ==>해당 명령의 결과로 Selenium Server is up and running이라고 나오면 정상적으로 실행이 된 상태입니다.

   

4. R Studio로 이동

   ```R
   install.packages("RSelenium")
   
   library(RSelenium)
   
   remDr <- remoteDriver(remoteServerAddr="localhost", port=4445, browserName ="chrome") #cmd에서 기동한 서버로 연결을함. 
   
   remDr$open() #크롬 브라우저 하나를 열음. 
   
   
   
   remDr$navigate("http://konlpy.org/ko/latest/") #열려고 하는 url을 넣어줌. 
   
   webElem <-remDr$findElement("css","body")  #바디를 찾음.
   
   \#스크립트를 실행하는데 아까 찾은 바디를 scroll, 내리는데 어디까지? 바디의 높이 만큼,즉 아까 찾은 바디의 스크롤을 끝까지 내림. 
   
   remDr$executeScript("scrollTo(0,document.body.scrollHeight)",args=list(webElem))  
   
   Sys.sleep(1) #스크롤하면 서버에서 데이터를 불러오는 시간이 있으니 그 시간동안 잠시 시간을 가져.
   
   \#요소를 찾는데, 우리는 CSS요소로 찾을 껀데 class가 DY5T1d인걸 찾아와.
   
   title <- remDr$findElements(using="css","p")
   
   title <- sapply(title, function(x){x$getElementText()})#title은 요소의 집합이니 각 요소의 텍스트를 가져와서 title 에 넣어줘.
   
   title
   
   remDr$close() #크롬 브라우저를 닫아줘~ 
   ```