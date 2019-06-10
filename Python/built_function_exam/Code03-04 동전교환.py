## 함수 선언부 ##
## 변수 선언부 ##
money, c500, c100, c50, c10 = 0,0,0,0,0 ;    #[0]*5와 같은 표현.
## 메인 코드부 ##
if __name__ == '__main__' :
    money = int(input("금액을 입력하세요 ==> "))
    c500 = money//500; money %= 500
    c100 = money//100; money %= 100
    c50 = money//50; money %= 50
    c10 = money//10; money %=10

    print( "500원 = ", c500," 100원 = " ,c100," 50원 = " , c50, " 51원 = " ,c10 );


