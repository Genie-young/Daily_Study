import sqlite3

conn = sqlite3.connect("samsongDB")   #1.DB 연결 (다리)
cur = conn.cursor();   #2. 커서 생성(트럭, 연결루프)
sql = "SELECT * FROM userTable"  #SQL서버는 IF NOT EXISTS는 SQL서버는 안됨.
cur.execute(sql);
rows = cur.fetchall();   #데이터가 많으면 못 가져오고 프로그램이 다운될 수 있으니 한 건씩 가져오는 걸로 최대한 하기
print(rows);
cur.close();
conn.close()     #6.DB 닫기
print("ok");
