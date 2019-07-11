spring boot dependencies는 org-springframework.boot groupid 사용함. 

spring-boot-starter-parent 를 상속받음. ==> 부모에 있는 dependency와 plugin정보를 상속받음. 

==> 부모에 기본적인 버전을 정의해놓기 때문에 dependency 를 추가할 때 version을 사용하지 않아도 되는 라이브러릴들이 있다.

2. AOP 실습

   - @만들기 (@LogExecutionTime)// 자바 annotation공부하자  

     ```java
     /*LogExecutionTime*/
     @Target(ElememtType.METHOD)  //이걸 읽어서 ㅓ리하는 무언가 있어야함. 
     @Retention(RetentionPolicy.RUNTIME)
     public @interface LogExecutionTime{
         
     }
     ```

     ```java
     //Logaspect class ==> proxy 패턴 기반으로 만든 AOP
     @Cmomponent
     @Aspect 
     public class LogAspect{
          Logger logger = LoggerFActory.getLogger(LogAspect.class);
         @Around("@annotation(LogExecutionTime)") //이 annotation이 붙어있는 target method 주변에 이 코드를 적용하겠다. //after,before //annotation아 아니어도 됨.
         public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
             StopWatch stopwatch = new StopWatch();
             stopwatch.start();
             Object proceed = joinPoint.proceed();
             stopWatch.stop();
             logger.info(stopWatch.prettyPrint());
             return proceed;
         }
     }
         
     ```

     

3. PSA(Portable Service Abstraction) //spring triangle중의 마지막  부분 

4. @Transactional 

   ==> 해당 메소드는 transaction 하게 처리되어서 해당 메소드가 끝나면 commit 이 실행됨.

   ==> transaction 구현체를 JpaTransactionManager, DatasourceTransactionManaver, HibernateTransactionManager

5. spring cache

   ==>cache 구현체도 여러개

   @Cacheable("vets") ==> cache 구현체를 vets로 함.



## Thymeleaf

1. standard Expression

   - `${...}` : Variable expressions.  
   - `*{...}` : Selection expressions.
   - `#{...}` : Message (i18n) expressions.
   - `@{...}` : Link (URL) expressions.
   - `~{...}` : Fragment expressions.

2. ### Variable expressions.

   *context variables* 중에 맞는 변수를 찾아서 적용.

   ```html
   ${session.user.name}
   <span th:text="${book.author.name}">
   <!-- ((Book)context.getVariable("book")).getAuthor().getName() -->
   <li th:each="book : ${books}">
   ```

3. ### Selection expressions.

   선택한 변수 안에서 찾아서 적용을 해줌. 

   ```html
   <!-- *{customer.name}  기본적인 사용 형태 -->
   
   <div th:object="${book}">==> <!-- 변수 선택-->
     ...
     <span th:text="*{title}">...</span> <!-- 변수 안에서의 지역변수 선택-->
     ...
   </div>
   ```

4. ### Message (i18n) expressions

5. 



## Standrd URL syntax

1. ### 절대  URLs(Absolute URLs)

   ==>  첫 줄은 th:href를 사용한 url, 두번째는 browser가 받아들이는 url

   - http와 같이 프로토콜 이름으로 지정하면 절대 경로로 찾아감.

   ```html
   <a th:href="{@http://www.thymeleaf/documentation.html}"></a>
   <a href="http://www.thymeleaf/documentation.html">
   ```

2. ### 상대 URLs(Context-relative URLs)

   -  the *context name* 뒤에 붙여줌. 예제에서는 **http://localhost:8080/myapp** 가 기본 rul
   - 보통은 context name을 따로 지정해주지 않으면 기본 localhost:포트번호로 적용되는 거 같은 <추측>

   ```html
   <a th:href="@{/order/list}"> 
   <a href="/myapp/order/list">  <!-- 같은 url,  -->
   ```

3. ### Server-relative URLs

     상대 URL과 비슷하지만 기본 context name을 고려하지 않음. ==> 바로 html로 옮겨도 됨.

   ```html
   <a th:href="@{~/billing-app/showDetails.htm}">
   <a href="/billing-app/showDetails.htm">
   ```

   

4. ### Protocol-relative URLs

   - 앞에 http: 가 붙음.

   ```html
   <script th:src="@{//scriptserver.example.net/myscript.js}">...</script>
   <script src="//scriptserver.example.net/myscript.js">...</script>
   ```

   

5. ### Adding parameters

   ```html
   <a th:href="@{/order/details(id=3)}">
   <a href="/order/details?id=3">
   
   <a th:href="@{/order/details(id=3,action='show_all')}">
   <a href="/order/details?id=3&amp;action=show_all">
   
   <a th:href="@{/order/{id}/details(id=3,action='show_all')}">
   <a href="/order/3/details?action=show_all">
   ```

   

6. ### URL fragment identifiers

   Fragment identifiers 를 URL에 포함 가능. parameter 있어도 되고 없어도 가능.

   ```html
   <a th:href="@{/home#all_info(action='show')}">
   <a href="/home?action=show#all_info">
   ```

   

7. ### th:action

   ```html
   <form th:action="@{/order/processOrder}">
       
   <!-- or possible below, 이게 무슨 의미일까.. 다음에 알아보도록 하자 -->
   <p th:text="#{orders.explanation('3', @{/order/details(id=3,action='show_all')})}">
   ```

   

8. ## Using expressions in URLs

   ```html
   <a th:href="@{/order/details(id=3,action='show_all')}">
       
   <!-- 만약 id와 admin이 listeral이 아니라면? 웹페이지에서 동적으로 변한다면?다음과 같이 사용 -->
   <a th:href="@{/order/details(id=${order.id},action=(${user.admin} ? 'show_all' : 'show_public'))}">
   
   <!-- 다음 표현을 shortcut으로 표현 가능-->
   <a th:href="@{/order/details(id=${order.id})}">
   <a th:href="@{'/order/details'(id=${order.id})}">
   <a th:href="@{${detailsURL}(id=${order.id})}">
   <!-- externalized/internationalized text로는 다음과 같이 표현 -->
   <a th:href="@{#{orders.details.localized_url}(id=${order.id})}"> 
   
   <!-- 조건식 포함하면?-->
   <a th:href="@{(${user.admin}? '/admin/home' : ${user.homeUrl})(id=${order.id})}">
   <!-- 위의 조건식을 좀 깔끔하게 표현하면 -->
   <a th:with="baseUrl=(${user.admin}? '/admin/home' : ${user.homeUrl})"
     th:href="@{${baseUrl}(id=${order.id})}">
   <!-- 혹은 -->
   <div th:with="baseUrl=(${user.admin}? '/admin/home' : ${user.homeUrl})">
     ...
     <a th:href="@{${baseUrl}(id=${order.id})}">...</a>
     ...
   </div>
   
   ```

   




## Entity validation

1. dependency 추가

   ```xml
   <dependency>
   		<groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
   </dependency>
   ```

   

2. @Entity가 선언된 클래스에서 

   검증이 필요한 변수 위에 다음의 어노테이션을 필요에 맞게 사용한다.

   @NotNull: null 검증
   @Min, @Max: 최소값, 최대값 검증
   @Size: 범위 검증
   @Email: e-mail 검증
   @AssertTrue: true 검증
   @NotEmpty: null이나 size가 0 검증 (String, Collection)
   @NotBlank: null이나 whitespace 검증 (String)
   @Positive, @PositiveOrZero: 숫자 검증
   @Negative, @NegativeOrZero: 숫자 검증
   @Past, @PastOrPresent: 날짜 검증
   @Future, @FutureOrPresent: 날짜 검증




```java
package com.example.demo.board.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.domain.BoardVO;
import com.example.demo.board.domain.PageVO;
import com.example.demo.board.mappers.BoardMapper;
import com.example.demo.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardservice;

	// Todo : paging 서비스 추가, 잘못된 정보가 들어오면 alert페이지, fragments

	//리스트 
	@GetMapping({"/list","/" }) 
	public String showAllList(@RequestParam(value="page", required = false, defaultValue = "1") int page,Model model) {
		System.out.println(page);
		PageVO pagevo = boardservice.getPageInfo(page);
		if(pagevo.getTotalpagecnt() < page || page <1) {
			model.addAttribute("msg","해당 페이지 번호가 없습니다. 첫 페이지로 돌아갑니다.");
			model.addAttribute("errorcode","pageNumberNotFound");
			return "errorPage";
		}
		model.addAttribute("boardvolist", boardservice.getPageList(page));
		model.addAttribute("pagevo", pagevo );

		return "allList";
	}
	
//	// 모든 리스트 보여주기
//	@GetMapping({ "/list", "/" }) 
//	public String showAllList(Model model) {
//		model.addAttribute("boardlist", boardservice.getAllList());
//		return "AllList";
//	}
	
	//게시글 등록 폼 보여주기 
	@GetMapping("/create")
	public String createForm(Map<String, Object> model) { // , required = false, defaultValue = "0"
		model.put("boardvo", new BoardVO());
		return "createModifyForm";
	}

	//작성한 게시글 DB에 insert하고 view 페이지로
	@PostMapping("/create")
	public String procCreate(@Valid BoardVO boardvo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("msg","제목을 작성해주세요!");
			model.addAttribute("errorcode","createTitleNullException");
			return "errorpage";
		}
		boardservice.createBoard(boardvo);
		return "redirect:/view/" + boardvo.getSeq();
	}

	//게시글 번호로 DB에서 가져와서 해당 게시물 전체  보여주기
	@GetMapping("/view/{seq}")
	public String showDetailView(@PathVariable("seq") int seq, Model model) {
		BoardVO boardvo = null;
		boardvo = boardservice.getBySeq(seq);
		if (seq < 1 || boardvo == null ) {
			model.addAttribute("msg","없는 게시물입니다.");
			model.addAttribute("errorcode","showdetailBoardNotFoundException");

			return "errorPage";
		}

		model.addAttribute("boardvo",boardvo);
		return "detailView";
	}
	
	 //게시글 DB에 update하고 view 페이지로 
	@PostMapping("/modi")
	public String modifyForm(@Valid BoardVO boardvo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("msg","제목을 작성해주세요!");
			model.addAttribute("errorcode","modifyTitleNullException");
			model.addAttribute("boardvo",boardvo);
			return "errorPage";
		}
		if(boardvo==null) {
			model.addAttribute("msg","리스트에서 수정할 게시물을 먼저 선택해주세요");
			model.addAttribute("errorcode","modifyNotSelectBoardException");
			return "errorPage";
		}
		boardservice.updateBoard(boardvo);
		return "redirect:/view/"+boardvo.getSeq();
	}
	
	//해당 게시글 삭제
	@GetMapping("/delete/{seq}")
	public String deleteBoard(@PathVariable("seq") int seq, Model model) { // , required = false, defaultValue = "0"
		int result = boardservice.deleteBoard(seq);
		if (seq < 1 || result ==0) {
			model.addAttribute("msg","없는 게시물입니다.");
			model.addAttribute("errorcode","deleteBoardNotFoundBoard");

			return "errorPage";
		}
		return "redirect:/list";
	}
	
}

```



```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>앤톡 월드</title>
<script th:inline="javascript">
if([[${errorcode}]] == "pageNumberNotFound" ){
	if (confirm( "해당 페이지 번호가 없습니다. 첫 페이지로 돌아갑니다.")){
    	location.href ="/list"
	}
}else if ([[${errorcode}]] == "createTitleNullException" ) {
	if (confirm( "제목을 작성해주세요!")){
		/* form을 실행시키는 코드 추가하고, createModifyForm 으로 던져주기  */
    	location.href ="/list"
	}
}
</script>
</head>
<body>

	<h1 th:text="${msg}"></h1>

	<form th:if="${errorcode.equals('createTitleNullException')}"
		th:object="${boardvo}" th:action="@{/create}" method="post">



		<form th:if="${errorcode.equals('modifyTitleNullException')}"
			th:object="${boardvo}" th:action="@{/create}" method="post">
</body>
</htm>
```



Spring 에서 validation하고 해당 페이지로 정보가진 채로 다시 돌아가기

1. history.go(-1); 추가해서 전 페이지로 돌아가기 

   ```java
   @PostMapping("/create")
   public String procCreate(@Valid BoardVO boardvo, BindingResult result, Model model, HttpServletResponse response) throws IOException {
   		if (result.hasErrors()) {
   			response.setContentType("text/html; charset=UTF-8");
   			PrintWriter out = response.getWriter();
   			out.println("<script>alert('제목을 작성해주세요!');history.go(-1); </script>");  /* histroy*/
   			out.flush();
   		}
   		boardservice.createBoard(boardvo);
   		return "redirect:/view/" + boardvo.getSeq();
   	}
   ```

   

"~{templatename::selector}"

{templatename::fragmentname}

- `th:insert` is the simplest: it will simply insert the specified fragment as the body of its host tag.
- `th:replace` actually *replaces* its host tag with the specified fragment.
- `th:include` is similar to `th:insert`, but instead of inserting the fragment it only inserts the *contents* of this fragment.