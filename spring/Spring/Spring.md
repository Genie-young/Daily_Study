# Spring

## [ spring framework 입문 ]

- 핵심 기술 > 

- 메이븐의 라이프 사이클 패키지 빌드를 실행하면 프로젝트를 빌드해서 패키지를 만든다. 이 패키지는 jar 형태 프로젝트<packiging> 타입에 아무것도 지정하지 않으면 jar ==> jar파일이 있는 지를 빌드에 찍힌 로고로 알 수 있음.

- applicatino.properties 에 

  ```
  logging.level.org.springframework.web=DEBUG
  ```

  와 같이 설정하면 디버그 모드로 로그를 볼 수 있음.

1. Bean //bean 등록방법 

   1) component scan을 통해 등록 

   application context가 알고있는 객체 life cycle call back==>bean으로 등록하는 annotation 처리기

   component 

   component, repository, service, controller, 

   repository의 경우 인터페이스가 특정한  클래스(Repository<Owner, Integer>)를 상속받아 @선언 안해도 자동으로 IOC컨테이너에 등록됨.

   2) bean으로 직접 등록

   ```java
   //SampleConfig 클래스 
   @Configuration  // 자동으로 application context scan해서 컨테이너에 등록  
   public class SampleController{
       @Bean
       public SampleController sampleController(){
           return new SmapleController
       }
   }
   ```

   

2. 의존성 주입 방법 - dependence injection

   - 생성자로 주입받는 방법 : 순환 의존하는 A와 B 클래스가 있을 때 생성자로 하면 안돌아감.
   - @Autowired로 주입받는 방법
   - setter로 주입받는 방법

3. AOP (Aspect Oriented Programming) 

   ==>관심사 중심으로 

   ```java
   //원래 코드를 아래 코드로 
   class A{
       method a(){
           AAAA -> AAAA
           집에 있는데 집에 가고 싶어요
           BBBB -> BBBB
       }
       method b(){
           AAAA -> AAAA
           먹고 있는데 뭔가 먹고 싶어요
           BBBB -> BBBB
       }
   }
   class B{
       method a(){
           AAAA -> AAAA
           집에 있는데 집에 가고 싶어요
           BBBB -> BBBB
       }
       method b(){
           AAAA -> AAAA
           먹고 있는데 뭔가 먹고 싶어요
           BBBB -> BBBB
       }
   }
   
   ```
   ```java
   class A{
       method a(){
            집에 있는데 집에 가고 싶어요
       }
       method b(){
           먹고 있는데 뭔가 먹고 싶어요
       }
   }
   class A{
       method a(){
            집에 있는데 집에 가고 싶어요
       }
       method b(){
           먹고 있는데 뭔가 먹고 싶어요
       }
   }   
   class AAAABBBB{
       method aaaabbbb(JoinPoint point){
           AAAA
           point.execute()
           BBBB
       }
   }
   ```

   ```java
   StopWatch stopWatch = new StopWatch();
   stopWatch.start();
   stopWatch.stop();
   ```

   A.java -> A.class -> (AOP) -> 메모리 // 컴파일할 때 바이트 코드를 조작함.

   프록시패턴(Spring AOP) ==> 원코드에 영향을 적게 주면서 client 코드를 추가하는 방법 

4. 

```java
    @GetMapping("/owners/find")
    public String initFindForm(Map<String, Object> model) {
        model.put("owner", new Owner());
        return "owners/findOwners";
    }
```

```html
<!-- findOwners.html-->
<form th:object="${owner}" th:action="@{/owners}" method="get"
    class="form-horizontal" id="search-owner-form">
       <input class="form-control" th:field="*{lastName}" size="30"
            maxlength="80" />
            <button type="submit" class="btn btn-default">Find
          Owner</button>
      </form>
```

```java
 @GetMapping("/owners")
    public String processFindForm(Owner owner, BindingResult result, Map<String, Object> model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }
}
   
```

```java
public interface Payment{
    void pay(int amount);
}
```

```java
public class Store{
    Payment payment;
    public Store(Payment payment){
        this.payment = payment;
    }
    public void buySomething(){
        payment.pay(amount:100);
    }
}
```

