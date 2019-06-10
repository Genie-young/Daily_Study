import pymysql

conn = pymysql.connect(host = "192.168.56.107", user="root", password="1234", db ="samsongDB", charset="utf8")   #1.DB 연결 (다리)
cur = conn.cursor();   #2. 커서 생성(트럭, 연결루프)
sql = "Create Table IF NOT EXISTS missionTable(userId INT, userName CHAR(10), userindate INT);"
cur.execute(sql);

while(True) :   #0이 입력될때까지 반복.
    id = input("id ==> ");
    if(id == "0") : break;
    name = input("name ==> "); indate = input("user In date ==> ");
    sql = "INSERT INTO  missionTable VALUES("+ id +", '"+ name  +"', " +indate+");";
    print(sql)
    cur.execute(sql);
cur.close();
conn.commit();  #변경된 사항을 저장.

cur = conn.cursor();   #2. 커서 재생성
sql = "SELECT * FROM missionTable"
cur.execute(sql);
print("\n\n", "========결과========"+"\n");
while(True):
    rows = cur.fetchone();
    if(rows != None) :
      print(rows)
conn.close()     #6.DB 닫기
print("ok");
