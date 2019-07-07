



# Spring Boot

## [ 1 ] spring 프로젝트 기본 구조

- src/main/java  ==> 자바 코드의 경로
- src/main/resources ==> 실행할 때 참고하는 기본 경로(주로 설정파일)
- src/main/resources/static : static한 파일(css,image,js 등) 디폴트 경로
- src/main/resources/templates : thymeleaf, freemaker 및 기타 서버 사이드 템플릿 파일의 경로
- src/test/java ==> 테스트 코드를 넣는 경로
- servlet-context.xml ==> 웹 관련 스프링 설정 파일
- root-context.xml ==> 스프링 설정 파일

## [ 2 ] 스타터

1. spring -boot-starter : 스프링 부트의 코어, auto-configuration, logging.yml  제공
2. spring-boot-starter-app : 관점 지향 프로그래밍(AOP) 제공
3. spring-boot-starter-batch : 스프링 배치를 사용하는데 필요한 스타터
4. spring-boot-starter-data-jpa: 스프링 데이터 jpa 와 하이버네이트를 사용하는데 필요한 스타터
5. spring-boot-starter-data-redis : 메모리 저장 방식의 저장소인 redis 와 레디스를 사용하게끔 도와주는 제디스 설정 자동화 스타터 
6. spring-boot-starter-data-rest : 스프링 데이터 저장소(repository) 방식에 맞춘 REST API를 제공하는 데 사용되는 스타터
7. spring -boot-starter-thymeleaf : 타임리프 템플릿 엔진을 사용하는데 필요한 스타터
8. spring -boot-starter-jdbc :  톰캣 JDBC 커넥션 풀에 사용하는 스타터
9. spring-boot-starter-security : 각종 보안에 사용하는 스프링 시큐리티 스타터
10. spring -boot-starter-oauth2 : OAuth2 인증에 사용하는 스타터
11. spring-boot-starter-validation 자바 빈 검증에 사용하는 스타터
12. spring -boot-starter-web : 웹을 만드는데 사용하는 스타터(스프링 MVC, REST형, 임베디드 톰캣, 기타 라이브러리 포함)


## [ 3 ] Spring boot test annotation

- @SpringBootTest

  통합 테스트를 제공하는 기본적인 스프링 부트 테스트 어노테이션. 설정을 임의로 변경 가능 && 여러 단위 테스트를 하나의 통합된 테스트로 수행 가능

  객체 생성 방식 

  1. @SpringBootTest의 속성 classes에 빈이 될 클래스 지정해주기. 

  ```java
  import org.junit.Test;
  import org.junit.runner.RunWith;
  import org.springframework.boot.test.context.SpringBootTest;
  import org.springframework.test.context.junit4.SpringRunner;
  //RunWith : JUnit에 내장된 러너 대신 정의된 러너 클래스를 사용 
  @RunWith(SpringRunner.class) 
  //@SpringBootTest는 항상 SpringJunit4ClassRunner를 상속받은 위의 RunWith가 필요함. !필수!
  //클래스를 지정해주지 않으면 애플리케이션 상의 정의된 모든 빈 생성.
  @SpringBootTest(classes = {ArticleServiceImpl.class, CommonConfig.class})
  public class ApplicationTests {
  	//ArticleServiceImpl.class에서 가져온 것
      @Autowired
      private ArticleServiceImpl articleServiceImpl;
      @Test //contextLoads 메소드가 단위 테스트 대상 메소드임을 지정.
  	public void contextLoads() {
  	}
  }
  ```

  2. @TestConfiguration : 기존의 Configuration을 커스터마이징 하고 싶은 경우

  SpringBootTest의 classes 속성을 이용했을 경우에는 TestConfiguration은 감지되지 않음. ==> 이럴때는 classes 속성에 추가를 해주자! 

  ```java
  @RunWith(SpringRunner.class)
  @SpringBootTest
  public class TestConfigArticleServiceImplTest {
      @TestConfiguration 
      public static class TestConfig {
          @Bean
          public RestTemplate restTemplate() {
              return new RestTemplate() { };
          }
      }
  }
  ```

  3. @Import : classes 속성을 사용 하면서 동시에 import로 다른 빈을 생성함.

  ```java
  @RunWith(SpringRunner.class)
  @SpringBootTest(classes = ArticleServiceImpl.class)
  @Import(TestConfig.class) 
  public class TestConfigArticleServiceImplTest {
      @Test
      public void test() {
      //메소드 실행 내용
      }
  }
  ```

  추가 : MockBean

  @MockBean을 사용해서 Mock 객체를 빈으로 등록 가능. 같은 객체는 한번만 등록함.  

- @WebMvcTest

- @DataJpaTest

- @RestClientTest

- @JsonTest

## [  ] @(annotation) 

==> 클래스, 메서드, 필드 등 프로그램 요소에 정보를 제공하는 기법, 타겟 요소를 제어/관리/명시하는 등의 다양한 기능 가능

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

12. @Value 

    프로퍼티의 키를 사용하여 특정한 값을 호출 가능 

    ```yml
    < 'application.yml 파일' >
    property :
    	test :
    		name : property depth test
    propertyTest : test
    propertyTestList : a,b,c
    ```
    

    ```java
    package com.example.demo;
    
    import static org.hamcrest.Matchers.is;
    import static org.junit.Assert.assertThat;
    
    import java.util.List;
    
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.context.junit4.SpringRunner;
    
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class AutoconfigurationApplicationTests {
    	// 깊이가 존재하는 키값에 대해 '.'으로 구분하여 해당 값을 매핑
    	@Value("${property.test.name}")
    	private String propertyTestName;
    
    	// 단일 키값을 매핑
    	@Value("${propertyTest}")
    	private String propertyTest;
    
    	// YAML파일에 키값이 존재하지 않으면 디폴트값이 매핑되도록 설정
    	@Value("${noKey:default value}")
    	private String defaultValue;
    
    	// 여러 값을 나열할 때는 배열형으로
    	@Value("${propertyTestList}")
    	private String[] propertyTestArray;
    
    	// SpEL을 사용하여 ','를 기준으로 List에 매핑
    	@Value("${'${propertyTestList}'.split(',')}")
    	private List<String> propertyTestList;
    
    	@Test
    	public void testValue() {
    		// assertThat의 첫번째, 두번째 파라미터가 같아야한다.
    		assertThat(propertyTestName, is("property depth test"));
    		assertThat(propertyTest, is("test"));
    		assertThat(defaultValue, is("default value"));
    		assertThat(propertyTestArray[0], is("a"));
    		assertThat(propertyTestArray[1], is("b"));
    		assertThat(propertyTestArray[2], is("c"));
    
    		assertThat(propertyTestList.get(0), is("a"));
    		assertThat(propertyTestList.get(1), is("b"));
    		assertThat(propertyTestList.get(2), is("c"));
    	}
    }
    ```

    

13. @ConfigurationProperties

    접두사를 사용하여 더 객체지향적으로 프로퍼티를 매핑함.

    ```yml
    < 'application.yml' 파일>
    fruit:
    	list:
    	- name : banana
    	  color : yellow
    	- name : apple
    	  color : red
    	- name : water melon
    	  color : green
    ```

    ```java
    // 파일명 : com/demo/pojo/FruitProperty.java
    import java.util.List;
    import java.util.Map;
    
    import org.springframework.boot.context.properties.ConfigurationProperties;
    import org.springframework.stereotype.Component;
    
    import lombok.Data;
    @Data
    //@ConfigurationProperties를 사용하려면 component선언을 해서 의존성 주입이 가능하게 만들어야 함.
    @Component 
    //접두사가 fruit인 프로퍼티키값을 읽어와서 필드값에 매핑함.
    //application.yml이 아닌 다른 이름의 yaml파일을 사용할때는 (prefix ="fruit")로 사용.
    @ConfigurationProperties("fruit")
    public class FruitProperty{
    	private List<Map> list;
    	/*pojo 매핑 방법
     	private List<Fruit> list;
     	==> 아래의 코드들도 모두 <Map>을 <Fruit>로 바꿔주자! 
     */
    	public List<Map> getList() {
    		return list;
    	}
    
    	public void setList(List<Map> list) {
    		this.list = list;
    	}
    	
    }
    ```

    ```java
    package com.example.demo;
    
    import java.util.List;
    import java.util.Map;
    
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.context.junit4.SpringRunner;
    
    import static org.hamcrest.Matchers.is;
    import static org.junit.Assert.assertThat;
    
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class PropertyTest{
    	@Autowired
    	FruitProperty fruitProperty;
    	
    	@Test
    	public void test() {
    		List<Map> fruitData = fruitProperty.getList();
    		assertThat(fruitData.get(0).get("name"), is("banana"));
    		assertThat(fruitData.get(0).get("color"), is("yellow"));
    
    		assertThat(fruitData.get(0).get("name"), is("apple"));
    		assertThat(fruitData.get(0).get("color"), is("red"));
    		
    		assertThat(fruitData.get(0).get("name"), is("water melon"));
    		assertThat(fruitData.get(0).get("color"), is("green"));
    		/*pojo 매핑 방법
    		List<Fruit> fruitData = fruitProperty.getList();
    		assertThat(fruitData.get(0).getName(), is("banana"));
    		assertThat(fruitData.get(0).getColor(), is("yellow"));
    		*/
    
    	}
    }
    ```



- 