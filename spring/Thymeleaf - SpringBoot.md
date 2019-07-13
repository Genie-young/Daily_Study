# Thymeleaf - SpringBoot

## 1. 기본적인 Tymeleaf 사용법

```html
<!-- home.html --> 
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"> <!-- tymeleaf 사용을 위한 기본 설정 -->
  <head>
    <title>Good Thymes Virtual Grocery</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" media="all" 
          href="../../css/gtvg.css" th:href="@{/css/gtvg.css}" /> <!-- 상대적인 경로로 css 파일 지정 뒤에 설명 ㄱㄱ-->
  </head>

  <body>
  	<!-- 전체 변수 중에 home이라는 변수안에 있는 필드 변수 welcome을 가져와 => message 변수 -->
      <p th:text="#{home.welcome}">Welcome to our grocery store!</p>
  </body>
</html>
```


## 2. message 기능

> message 라는 건 현재 문서 외부에서 다른 언어로 작성되어 있던 정보들을 가지고 와서 사용하는 것. 즉, java파일에서 사용하던 변수들을 html파일로 가져와서 사용 가능하다! 

```html
<p th:text="#{home.welcome}">Welcome to our grocery store!</p>
```

아래와 같이  #{외부 변수 이름}으로 사용하면 된다. 

th:text는 Welcome to our grocery store!를 대체하는 문구이다. 즉 진짜로 해당 태그 내부에 표시되는 값은 #{home.welcome}의 값이 된다.

> advanced 외부 문서는 어디 저장될까?
>
> 일반적으로 *.properties*를 기반으로 구현되지만, org.thymeleaf.messageresolver.IMessageResolver 구현에 따라달라지고, 이에 따라 커스터마이징이 가능하다. 타임리프 초기화 하는 동안 *Standard Message Resolver*, 를 구현한 `org.thymeleaf.messageresolver.StandardMessageResolver`가 실행된다.
>
> *Standard Message Resolver*는 home.html이 있는 위치에 같은이름.properties(home.properties)으로 저장되어 있는 설정을 찾아가도록 되어 있다. 다음은 home.properties를 구현한 예이다.
>
> ```properties
> home.welcome=¡Bienvenido a nuestra tienda de comestibles!
> ```

## context기능 

- `${x}` will return a variable `x` stored into the Thymeleaf context or as a *request attribute*.

- `${param.x}` will return a *request parameter* called `x` (which might be multivalued).

- `${session.x}` will return a *session attribute* called `x`.

  ```java
  @Controller  
  @RequestMapping({"/"})
      String index(HttpSession session) {
          session.setAttribute("mySessionAttribute", "someValue"); //session정보에 다음 정보 저장 
          return "index";
      }
  ```

  ```html
  <p th:text="${session.mySessionAttribute}" th:unless="${session == null}">[...]</p> <!-- session.으로 session 내부 정보 저장 -->
  
  <!--https://www.thymeleaf.org/doc/articles/springmvcaccessdata.html-->
  ```

  

- `${application.x}` will return a *servlet context attribute* called `x`.