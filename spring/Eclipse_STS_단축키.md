# Eclipse 단축키

## Editing

- Ctrl + D : 줄 삭제
- Ctrl + Alt + 위/아래 : 줄 복사
- Ctrl + Shift + Enter : 현재 줄에 새줄 추가
- Shift + Enter : 다음줄에 새줄 추가
- Ctrl + Right : 다음문자로 이동 (Ctrl + Left : 이전 문자로 이동 )
- Ctrl + Shift + / : 주석처리 (Ctrl + Shit + \ 주석 풀기)
- Ctrl + / : 라인별로 주석처리
- Ctrl + Shift + O : import 정리
- Ctrl + L : 원하는 라인으로 이동
- Alt + Shift + 방향키 : 블록선택하기

## 검색

- Ctrl + J : 점증적 검색 - Ctrl + J 입력후 원하는 단어 입력하면 이클립스 하단바에 찍히고 바로 검색 가능
- Ctrl + K : 다음 찾기(Ctrl + Shift + K 이전 찾기)  - 현재 블럭설정된 단어 찾기
- Ctrl + H : 검색 다이얼로그(메서드, 타입, 패키지 등 검색 가능)
- Tab : 들여쓰기 (Shift + Tab : 내어쓰기)
- Ctrl + Space : 코드어시스트 (키보드 Type3를 쓸 경우에는 왼쪽 Ctrl을 누른 상태에서 오른쪽 Ctrl을 누르고 왼쪽 Ctrl을 뗀 후에(오른쪽 Ctrl은 누른 상태) Space를 눌러준다.)
- Shift + Alt + T : 리펙토링 메뉴 띄우기
- Ctrl + E : 에디터안에서 열린 파일간의 이동(작은 레이어로 뜬다.)
- Ctrl + F6 : 에디터안에 열링 파일간 이동하는데 F6누를때마다 하나씩 순차적으로 넘어감.
- Ctrl + E : 퀵 에디터간 이동
- Ctrl + F7 : 뷰간 전환
- Ctrl + F8 : 퍼스펙티브 간 전환
- F12 : 어디서든 에디터로 포커스 됨
- Ctrl + Shift + R : 리소스 찾기
- Ctrl + O : 레이어로 현재파일의 Outline 보여줌
- Ctrl + T : 레이어로 계층구조 보여줌
- Ctrl + Shift  + Space : 메서드의 괄호안에서 누르면 파라미터 타입 볼 수 있음.
- Ctrl + 1 : 에러난 곳(빨간 줄 표시)에서 누르면 레이어로 해결방법이 나옴.
- F3 : 해당 메서드나 클래스가 정의된 곳으로 이동
- Ctrl + Shift + G : 해당 메서드, 객체, 변수가 사용(호출)된 모든 곳을 찾는다.
- Ctrl + 3 : Quick Access
- Ctrl + M : 화면 최대화
- Ctrl + W : 파일에디터 닫기
- Alt + Shift + X, R : Run on Server
- F11 or Ctrl + F11 : 최근 실행한 Run 실행

 

Eclipse >

빌드 및 실행

메이븐 빌드 : Alt + Shift + X, M

실행 모드로 실행 : Ctrl + F11   <= 요놈으로 톰켓 실행도 됨.

톰켓 중지 : Ctrl + F7로 서버 뷰 영역으로 이동후 Ctrl + Alt + S  

 

톰켓 실행 : Ctrl + F7로 서버 뷰 영역으로 이동후 Ctrl + Alt + R(이놈은 실행중일때 재시작됨)  혹은 Ctrl + F11( 이놈은 서버가 운영 중이라며 포트 충돌난다고 문제 경고 띄워주네요 )

 

톰켓 디버그 모드 실행 : Ctrl + F7로 서버 뷰 영역으로 이동후 Ctrl + Alt + D   혹은 F11

 

빌드 : Ctrl + B   ( Project 메뉴에 Build Automatically 에 체크 되어 있으면 자동 빌드 됨)

디버그

 

브레이크포인트 토글 : Ctrl + Shift + B  ( 빈 라인에서 하면 해당 커서 바로 아랫 내용이 있는 라인에 적용됨 )

디버그 모드로 실행 : F11

Step Into : F5 ( 실행 되는 메소드 안으로 들어가서 확인 됨)

Step Over : F6 ( 다음줄로 동 진행 )

Step Return : F7 (듬은 브레이크 포인트로 이동 되긴 하나 계속 진행은 안된다. ;;)

Run to Line : Ctrl + R  ( 커서 있는 라인에서 단축키 실행시 해당 커서 까지 디버그 진행 [요거 좋아보임 많이 사용할 듯 ])

Resume : F8  ( 진행 , 요넘이 다음 브레이크포인트로 이동하며 다음 브레이크포인트가 없을시 프로그램 계속 진행. )

프로그램 종료 : Ctrl + F2 ( 요놈은 안해 봤음)

ctrl+shift+R 파일 열기

NOTE: 

Standard shortcuts are not covered, such as Ctrl + A (select all), Ctrl + Z (undo), etc.



1. **Ctrl + D**: Deletes current line.

2. **Ctrl + Delete:** Deletes next word after the cursor.

3. **Ctrl + Shift + Delete:** Deletes from the cursor until end of line.

4. **Ctrl + Backspace:** Deletes previous word before the cursor.

5. **Shift + Ctrl + y:** Changes a selection to lowercase.

6. **Shift + Ctrl + x:** Changes a selection to uppercase.

7. Alt + Up Arrow

   :

    Moves up current line (or a selected code block) by one line:

   

   

8. Alt + Down Arrow

   :

    Moves down current line (or a selected code block) by one line:

   

   

9. Ctrl + Alt + Up Arrow: 

   Copies and moves up current line (or a selected code block) by one line:

   

   

10. Ctrl + Alt + Down Arrow: 

    Copies and moves down current line (or a selected code block) by one line:

    

    

11. Shift + Enter:

     Inserts a blank line after current line, regardless where the cursor is at the current line (very different from press 

    Enter

     key alone):

    

    

12. **Ctrl + Shift + Enter:** works similar to the **Shift + Enter**, but inserts a blank line just before the current line.

13. Ctrl + Shift + O:

     Organizes import statements by removing unused imports and sorts the used ones alphabetically. This shortcut also adds missing imports.

    

    

14. Ctrl + Shift + M:

     Adds a single import statement for the current error due to missing import. You need to place the cursor inside the error and press this shortcut:

    

    

15. Ctrl + Shift + F:

     Formats a selected block of code or a whole source file. This shortcut is very useful when you want to format messy code to Java-standard code. Note that, if nothing is selected in the editor, Eclipse applies formatting for the whole file:

    

    

    

16. Ctrl + I:

     Corrects indentation for current line or a selected code block. This is useful as it helps you avoid manually using 

    Tab

     key to correct the indentation:

    

    

17. Ctrl + /

    or 

    Ctrl + 7

    : Toggle single line comment. This shortcut adds single-line comment to current line or a block of code. Press again to remove comment. For example:

    

    

18. Ctrl + Shift + /:

     Adds block comment to a selection.

    

    

19. Ctrl + Shift + \:

     Removes block comment.  

    

    1. 

20. Alt + Shift + S:

     Shows context menu that lists possible actions for editing code:

    

    From this context menu, you can press another letter (according to the underscore letters in the names) to access the desired functions.

    

    1. Recommended Book: 

       [Eclipse 4 Application Development: The complete guide to Eclipse 4 RCP development (Volume 1)](https://www.amazon.com/gp/product/3943747034/ref=as_li_tf_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=3943747034&linkCode=as2&tag=code0ac-20)![img](https://ci5.googleusercontent.com/proxy/ZFwUf9nd6DBqDxpekxuiaBMAyVeCtbhbBg1QuejoNnYJ6D9mRVE-QRzfd2C23Xw_LoZbOONgmiK2XMBobbRs08QoHDKYDlFhCXye1HRuRHzNhVoiMTeeKZj09o6z=s0-d-e1-ft#https://ir-na.amazon-adsystem.com/e/ir?t=code0ac-20&l=as2&o=1&a=3943747034)

       

       1. 

21. Alt + Shift + S, R:

     Generates getters and setters for fields of a class. This is a very handy shortcut that helps us generate getter and setter methods quickly. The following dialog appears:

    

    

22. Alt + Shift + S, O: 

    Generates constructor using fields. This shortcut is very useful when you want to generate code for a constructor that takes class’ fields as its parameters. The following dialog appears:

    

    

23. Alt + Shift + S, C:

     Generates Constructors from Superclass. A common example for using this shortcut is when creating a custom exception class. In this case, we need to write some constructors similar to the 

    Exception 

    superclass. This shortcut brings the 

    Generate Constructors from Superclass

     dialog which allows us to choose the constructors to be implemented in the subclass:

    

    

24. Alt + Shift + S, H:

     Generates 

    hashCode()

     and 

    equals()

     methods, typically for a JavaBean/POJO class. The class must have non-static fields. This shortcut brings the 

    Generate hashCode() and equals() 

    dialog as below:

    

    

    Select the fields to be used in 

    hashCode()

     and 

    equals()

     method, and then click OK. We got the following result (example):

    

    |      | `@Override``public` `int` `hashCode() {``    ``final` `int` `prime = ``31``;``    ``int` `result = ``1``;``    ``result = prime * result + id;``    ``result = prime * result``            ``+ ((password == ``null``) ? ``0` `: password.hashCode());``    ``result = prime * result``            ``+ ((username == ``null``) ? ``0` `: username.hashCode());``    ``return` `result;``}` `@Override``public` `boolean` `equals(Object obj) {``    ``if` `(``this` `== obj)``        ``return` `true``;``    ``if` `(obj == ``null``)``        ``return` `false``;``    ``if` `(getClass() != obj.getClass())``        ``return` `false``;``    ``User other = (User) obj;``    ``if` `(id != other.id)``        ``return` `false``;``    ``if` `(password == ``null``) {``        ``if` `(other.password != ``null``)``            ``return` `false``;``    ``} ``else` `if` `(!password.equals(other.password))``        ``return` `false``;``    ``if` `(username == ``null``` |
    | ---- | ------------------------------------------------------------ |
    |      |                                                              |

...