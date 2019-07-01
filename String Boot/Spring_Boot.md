# Spring Boot

## [ 1 ] spring 프로젝트 기본 구조

- src/main/java  ==> 작성되는 코드의 경로
- src/main/resources ==> 실행할 때 참고하는 기본 경로(주로 설정파일)
- src/test/java ==> 테스트 코드를 넣는 경로
- servlet-context.xml ==> 웹 관련 스프링 설정 파일
- root-context.xml ==> 스프링 설정 파일
- views ==>  

## [ 2 ] @(annotation)

1. @Component : component-scan으로 @Component이 있는 클래스에 대하여 bean 인스턴스를 생성한다.

2. @Controller, @Service, @Repository
   component 의 구체적인 역할을 지정한다.

3. @RestController
   view가 필요없는 API만 지원하는 서비스에서 사용 (Spring 4.0.1부터 제공)
   @RequestMapping 메서드가 기본적으로 @ResponseBody 의미를 가정한다.
   data(json, xml 등) return이 주목적
   즉, @RestController = @Controller + @ResponseBody

4. @RequestMapping

   모든 매핑 정보는 Spring에서 제공하는 HandlerMapping Class가 가지고 있다.
   1) Class Level Mapping : 모든 메서드에 적용되는 경우
   “/home”로 들어오는 모든 요청에 대한 처리를 해당 클래스에서 한다는 것을 의미한다.
   2) Handler Level Mapping : 요청 url에 대해 해당 메서드에서 처리해야 되는 경우
   “/home/employees” POST 요청에 대한 처리를 addEmployee()에서 한다는 것을 의미한다.
   value: 해당 url로 요청이 들어오면 이 메서드가 수행된다.
   method: 요청 method를 명시한다. 없으면 모든 http method 형식에 대해 수행된다.

5. @Autwired

   *Bean을 주입받는 방식 (3가지)*

   - @Autowired

   - setter
   - 생성자 (@AllArgsConstructor 사용) -> 권장방식

6. @Qualifier

   같은 타입의 빈이 두 개 이상이 존재하는 경우에 스프링이 어떤 빈을 주입해야 할지 알 수 없어서 스프링 컨테이너를 초기화하는 과정에서 예외를 발생시킨다.@Qualifier을 @Autowired와 함께 사용하여 정확히 어떤 bean을 사용할지 지정하여 특정 의존 객체를 주입

7. @Entity

   실제 DB의 테이블과 매칭될 클래스임을 명시

   클래스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭

   SalesManager.java -> sales_manager table

8. @Table

   엔티티 클래스에 매핑할 테이블 정보를 알려준다.
   이 어노테이션을 생략하면 클래스 이름을 테이블정보로 매핑

9. @Id
   해당 테이블의 PK 필드를 나타낸다.

10. @GeneratedValue
    PK의 생성 규칙을 나타낸다.
    TIP) 가능한 Entity의 PK는 Long 타입의 Auto_increment를 추천한다.
    기본값은 AUTO로, MySQL의 auto_increment와 같이 자동 증가하는 정수형 값이 된다.

11. @Column
    테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다.
    @Column을 생략하면 필드명을 사용해서 컬럼명과 매핑하게 된다.
    이 Annotation을 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용한다.
    Ex) 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex: title), 타입을 TEXT로 변경하고 싶거나(ex: content) 등의 경우에 사용된다.

    