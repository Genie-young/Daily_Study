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
cur.close();
conn.commit();
conn.close()     #6.DB 닫기
print("ok");
