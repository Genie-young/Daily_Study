import pymysql

conn = pymysql.connect(host = "192.168.56.107", user="root", password="1234", db ="samsongDB", charset="utf8")   #1.DB 연결 (다리)
cur = conn.cursor();   #2. 커서 생성(트럭, 연결루프)
sql = "Create Table IF NOT EXISTS userTable2(userId INT, userName CHAR(5));"  #SQL서버는 IF NOT EXISTS는 SQL서버는 안됨.
cur.execute(sql);
sql = "INSERT INTO  userTable2 VALUES(" + "1"+",'"+"홍길동"+"')";
sql += "추가";
cur.execute(sql);
sql = "INSERT INTO  userTable2 VALUES(2,'이순신')";
cur.execute(sql);
sql = "SELECT * FROM userTable2";
cur.execute(sql);
cur.close();
conn.commit();
conn.close()     #6.DB 닫기
print("ok");
