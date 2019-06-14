# Day 3. Basic of DB Integration with python

```mysql
CREATE DATABASE samsongDB; #samsongDB라는 이름의 DB를 만듦.
USE samsongDB; #samsongDB 사용할게

CREATE TABLE UserTable(     #테이블 생성 
userId CHAR(10), 
userName CHAR(5),
USERMail VARCHAR(50),   #Char는 고정형 데이터 타입이고, VARCHAR는 가변형타입이라서 공간 절약 + 시간적약됨. 
birthYear SMALLINT   
);

INSERT INTO UserTable VALUES('AAA','에이','aa@aa.com',1995);
INSERT INTO UserTable VALUES('BBB','삐이','bb@aa.com',1991);
INSERT INTO UserTable VALUES('CCC','씨이','cc@aa.com',1988);

COMMIT;  #Insert, update, delete와 같은 변경 사항을 확정함. 이전에는 입시 버퍼에 저장됨.

```



```mysql
CREATE DATABASE UserTable;
USE UserTable;

CREATE TABLE USERInfo(
userid CHAR(5),
userName VARCHAR(10),
userEmail VARCHAR(100),
userBirthYear SMALLINT
);
```





## Python 과 DB연동하기

### 1. sqlite3로 테스트하기(내 로컬에서 DB를 임시로 생성)

```python
import sqlite3

conn = sqlite3.connect("samsongDB")   #1.DB 연결 (다리)
cur = conn.cursor();   #2. 커서 생성(트럭, 연결루프)
sql = "Create Table IF NOT EXISTS userTable(userId INT, userName CHAR(5));"  #SQL서버는 IF NOT EXISTS는 SQL서버는 안됨.
cur.execute(sql);
sql = "INSERT INTO  userTable VALUES(1,'홍길동')";
cur.execute(sql);
sql = "INSERT INTO  userTable VALUES(2,'이순신')";
cur.execute(sql);
sql = "SELECT * FROM userTable";
cur.execute(sql);
sql = "SELECT * FROM userTable"  #SQL서버는 IF NOT EXISTS는 SQL서버는 안됨.
cur.execute(sql);
rows = cur.fetchall();    #데이터가 많으면 못 가져오고 프로그램이 다운될 수 있으니 한 건씩 가져오는 걸로 최대한 하기
cur.close();
conn.commit();
conn.close()     #6.DB 닫기
print("ok");

```



문자열은 ", ' 두개 다 사용가능하지만 DB 연동시에는 DB가 문자열은 '로 쓰므로 파이썬에서는 "를 주로 사용. 

 ```python
#Script작성 요령   ==> 주석 정말정말 많이 달기, 범용적으로 짜기 
## 함수 선언부 ##

## 변수 선언부 ##

## 메인 코드부 ##

 ```



## DB설계

### 1.  DB논리적 설계

DB : BigdataDB

Table : rawImageTBL( 아이디, 가로크기, 세로크기, 파일명, 평균값, 업로드일자, 업로더, 이미지파일)

### 2. 물리적 설계

 raw_id int, raw_height smallint, raw_width smallint, raw_fname Varchar(30), raw_update DATE, raw_uploader Varchar(20), raw_data LONGBLOB)

-- LOB(DB 데이터타입) 잠고

- text, 이미지, 사운드 등 구조화되지 않은 대형 데이터를 저장

- 대형 데이터는 DB에 저장하기 힘들기 때문에 OS상 존재하는 파일을 데이터베이스가 접근

- LONG, LONG RAW 데이터 유형은 이전 버전, 현재는 대부분 LOB 데이터 유형을 사용
- TO_LOB 함수를 이용하여 LONG 및 LONG RAW 를 LOB 으로 변경할 수 있다.

종류

- CLOB: 문자 대형 객체. Oracle Server는 CLOB과 VARCHAR2 사이에 암시적 변환가능.  //4G

- BLOB : 이진 대형 객체 (Binary). 이미지, 동영상, MP3 등... 

- NCLOB : 내셔널 문자 대형 객체 (National). 오라클에서 정의되는 National Character Set을 따르는 문자.

- BFILE : OS에 저장되는 이진 파일의 이름과 위치를 저장. 읽기 전용 모드로만 액세스 가능.