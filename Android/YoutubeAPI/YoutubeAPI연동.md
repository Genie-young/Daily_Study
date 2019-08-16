# Youtube API연동

Youtube Android API 검색 후 다음에 접속해서

https://developers.google.com/youtube/android/player/downloads/?hl=ko

다운로드 > 파일 다운로드 > 압축 풀기 > lib에 jar 파일 복사

안스 프로젝트로 디렉토리 구조 변경 > app/libs에 붙여넣기

File > project structure > dependencies > + > libs/YoutubeAndroidPlayerApi.jar파일 implementation으로 추가

구글 개발자 센터에 가서 YoutubeAPI 생성, 패키지 이름 작성하고 안스의 siging report를 실행, SHA1 값을 복사해서 붙여넣기.

![1565942977316](C:\Users\user\AppData\Roaming\Typora\typora-user-images\1565942977316.png)



이 외에 .java 파일에서 api키와 동영상 주소 넣고 개발하기! 