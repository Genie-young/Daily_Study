# MyBatis

## 1. Basics

네임스페이스(Namespaces)

> 인터페이스 바인딩을 가능하게 한다. 네임스페이스을 사용하고 자바 패키지의 네임스페이스을 두면 코드가 깔끔해지고 마이바티스의 사용성이 크게 향상될 것이다.

이름 분석(Name Resolution)   

> 타이핑을 줄이기 위해 마이바티스는 구문과 결과매핑, 캐시등의 모든 설정엘리먼트를 위한 이름 분석 규칙을 사용한다.

## 2. Mapper XML 파일 

- ### basics

  > SQL Map XML파일은 첫번째(first class)엘리먼트만을 가진다. ??이게 무슨 소리일깐

  

  - `cache` - 해당 네임스페이스을 위한 캐시 설정
  - `cache-ref` - 다른 네임스페이스의 캐시 설정에 대한 참조
  - `resultMap` - 데이터베이스 결과데이터를 객체에 로드하는 방법을 정의하는 엘리먼트
  - `sql` - 다른 구문에서 재사용하기 위한 SQL 조각
  - `insert` - 매핑된 INSERT 구문.
  - `update` - 매핑된 UPDATE 구문.
  - `delete` - 매핑된 DELEETE 구문.
  - `select` - 매핑된 SELECT 구문.

- ### Select

  ```html
  <select id="selectPerson" parameterType="int" resultType="hashmap">
    SELECT * FROM PERSON WHERE ID = #{id}
  </select>
  ```

  electPerson이고 int타입의 파라미터를 가진다. 그리고 결과 데이터는 HashMap 에 저장

  ```xml
  <!-- select 속성 -->
  <select
    id="selectPerson"
    parameterType="int"
    parameterMap="deprecated"
    resultType="hashmap"
    resultMap="personResultMap"
    flushCache="false"
    useCache="true"
    timeout="10"
    fetchSize="256"
    statementType="PREPARED"
    resultSetType="FORWARD_ONLY">
  ```

  | `id`            | 구문을 찾기 위해 사용될 수 있는 네임스페이스내 유일한 구분자 |
  | --------------- | ------------------------------------------------------------ |
  | `parameterType` | 구문에 전달될 파라미터의 패키지 경로를 포함한 전체 클래스명이나 별칭 |
  | parameterMap    | 외부 parameterMap을 찾기 위한 비권장된 접근방법. 인라인 파라미터 매핑과 parameterType을 대신 사용하라. |
  | `resultType`    | 이 구문에 의해 리턴되는 기대타입의 패키지 경로를 포함한 전체 클래스명이나 별칭. collection인 경우 collection 타입 자체가 아닌 collection 이 포함된 타입이 될 수 있다. resultType이나 resultMap을 사용하라. |
  | `resultMap`     | 외부 resultMap 의 참조명. 결과맵은 마이바티스의 가장 강력한 기능이다. resultType이나 resultMap을 사용하라. |
  | `flushCache`    | 이 값을 true 로 셋팅하면 구문이 호출될때마다 로컬, 2nd 레벨 캐시가 지워질것이다(flush). 디폴트는 false이다. |
  | `useCache`      | 이 값을 true 로 셋팅하면 구문의 결과가 2nd 레벨 캐시에 캐시 될 것이다. 디폴트는 true이다. |
  | `timeout`       | 예외가 던져지기 전에 데이터베이스의 요청 결과를 기다리는 최대시간을 설정한다. 디폴트는 셋팅하지 않는 것이고 드라이버에 따라 다소 지원되지 않을 수 있다. |
  | `fetchSize`     | 지정된 수만큼의 결과를 리턴하도록 하는 드라이버 힌트 형태의 값이다. 디폴트는 셋팅하지 않는 것이고 드라이버에 따라 다소 지원되지 않을 수 있다. |
  | `statementType` | STATEMENT, PREPARED 또는 CALLABLE 중 하나를 선택할 수 있다. 마이바티스에게 Statement, PreparedStatement 또는 CallableStatement를 사용하게 한다. 디폴트는 PREPARED이다. |
  | `resultSetType` | FORWARD_ONLY\|SCROLL_SENSITIVE\|SCROLL_INSENSITIVE\|DEFAULT(same as unset)중 하나를 선택할 수 있다. 디폴트는 셋팅하지 않는 것이고 드라이버에 다라 다소 지원되지 않을 수 있다. |
  | `databaseId`    | 설정된 databaseIdProvider가 있는 경우 마이바티스는 `databaseId` 속성이 없는 모든 구문을 로드하거나 일치하는 `databaseId`와 함께 로드될 것이다. 같은 구문에서 `databaseId`가 있거나 없는 경우 모두 있다면 뒤에 나온 것이 무시된다. |
  | `resultOrdered` | 이 설정은 내포된 결과를 조회하는 구문에서만 적용이 가능하다. true로 설정하면 내포된 결과를 가져오거나 새로운 주요 결과 레코드를 리턴할때 함께 가져오도록 한다. 이전의 결과 레코드에 대한 참조는 더 이상 발생하지 않는다. 이 설정은 내포된 결과를 처리할때 조금 더 많은 메모리를 채운다. 디폴트값은 `false` 이다. |

- ### insert, update, delete 

  ```xml
  <insert
    id="insertAuthor"
    parameterType="domain.blog.Author"
    flushCache="true"
    statementType="PREPARED"
    keyProperty=""
    keyColumn=""
    useGeneratedKeys=""
    timeout="20">
  
  <update
    id="updateAuthor"
    parameterType="domain.blog.Author"
    flushCache="true"
    statementType="PREPARED"
    timeout="20">
  
  <delete
    id="deleteAuthor"
    parameterType="domain.blog.Author"
    flushCache="true"
    statementType="PREPARED"
    timeout="20">
  ```

  | 속성               | 설명                                                         |
  | :----------------- | :----------------------------------------------------------- |
  | `id`               | 구문을 찾기 위해 사용될 수 있는 네임스페이스내 유일한 구분자 |
  | `parameterType`    | 구문에 전달될 파라미터의 패키지 경로를 포함한 전체 클래스명이나 별칭 |
  | `parameterMap`     | 외부 parameterMap 을 찾기 위한 비권장된 접근방법. 인라인 파라미터 매핑과 parameterType을 대신 사용하라. |
  | `flushCache`       | 이 값을 true 로 셋팅하면 구문이 호출될때마다 캐시가 지원질것이다(flush). 디폴트는 false 이다. |
  | `timeout`          | 예외가 던져지기 전에 데이터베이스의 요청 결과를 기다리는 최대시간을 설정한다. 디폴트는 셋팅하지 않는 것이고 드라이버에 따라 다소 지원되지 않을 수 있다. |
  | `statementType`    | STATEMENT, PREPARED 또는 CALLABLE중 하나를 선택할 수 있다. 마이바티스에게 Statement, PreparedStatement 또는 CallableStatement를 사용하게 한다. 디폴트는 PREPARED 이다. |
  | `useGeneratedKeys` | (입력(insert, update)에만 적용) 데이터베이스에서 내부적으로 생성한 키 (예를들어 MySQL또는 SQL Server와 같은 RDBMS의 자동 증가 필드)를 받는 JDBC getGeneratedKeys메소드를 사용하도록 설정하다. 디폴트는 false 이다. |
  | `keyProperty`      | (입력(insert, update)에만 적용) getGeneratedKeys 메소드나 insert 구문의 selectKey 하위 엘리먼트에 의해 리턴된 키를 셋팅할 프로퍼티를 지정. 디폴트는 셋팅하지 않는 것이다. 여러개의 칼럼을 사용한다면 프로퍼티명에 콤마를 구분자로 나열할수 있다. |
  | `keyColumn`        | (입력(insert, update)에만 적용) 생성키를 가진 테이블의 칼럼명을 셋팅. 키 칼럼이 테이블이 첫번째 칼럼이 아닌 데이터베이스(PostgreSQL 처럼)에서만 필요하다. 여러개의 칼럼을 사용한다면 프로퍼티명에 콤마를 구분자로 나열할수 있다. |
  | `databaseId`       | 설정된 databaseIdProvider가 있는 경우 마이바티스는 `databaseId` 속성이 없는 모든 구문을 로드하거나 일치하는 `databaseId`와 함께 로드될 것이다. 같은 구문에서 `databaseId`가 있거나 없는 경우 모두 있다면 뒤에 나온 것이 무시된다. |

  사용하는 데이터베이스가 다중레코드 입력을 지원한다면, `Author`의 목록이나 배열을 전달할수 있고 자동생성키를 가져올 수 있다.

  ```xml
  <insert id="insertAuthor" useGeneratedKeys="true" keyProperty="id">
    insert into Author (username, password, email, bio) values
    <foreach item="item" collection="list" separator=",">
      (#{item.username}, #{item.password}, #{item.email}, #{item.bio})
    </foreach>
  </insert>
  ```
  > mssql에서는 자동생성키를 지원하여 위와 같은 방식이 가능하지만 oracle에서는 아래의 방식을 지원한다. 

  ```xml
  <insert id="insertBoard" parameterType="boardvo">
     <selectKey keyProperty="seq" resultType="int" order="AFTER">
             select seq FROM Board WHERE id = #{id}
    </selectKey>
    insert into Board ( title, content ) 
    values ( #{title}, #{content} )
  </insert>
  ```

  ==> insert 구문에서 resultType을 지정해도 결과값의 영향 유무를 알려주는 0,1밖에 안들어오기 때문에 이게 seq값이라고 착각하면 안된다. 위와 같이  useGeneratedKeys, keyProperty를 사용하면 boardvo.seq에 자동으로 seq의 값이 셋팅된다.

  ```xml
  <selectKey
    keyProperty="id"
    resultType="int"
    order="BEFORE"
    statementType="PREPARED">
  ```

  | 속성            | 설명                                                         |
  | :-------------- | :----------------------------------------------------------- |
  | `keyProperty`   | selectKey구문의 결과가 셋팅될 대상 프로퍼티.                 |
  | `keyColumn`     | 리턴되는 결과셋의 칼럼명은 프로퍼티에 일치한다. 여러개의 칼럼을 사용한다면 칼럼명의 목록은 콤마를 사용해서 구분한다. |
  | `resultType`    | 결과의 타입. 마이바티스는 이 기능을 제거할 수 있지만 추가하는게 문제가 되지는 않을것이다. 마이바티스는 String을 포함하여 키로 사용될 수 있는 간단한 타입을 허용한다. |
  | `order`         | BEFORE 또는 AFTER를 셋팅할 수 있다. BEFORE로 설정하면 키를 먼저 조회하고 그 값을 keyProperty 에 셋팅한 뒤 insert 구문을 실행한다. AFTER로 설정하면 insert 구문을 실행한 뒤 selectKey 구문을 실행한다. 오라클과 같은 데이터베이스에서는 insert구문 내부에서 일관된 호출형태로 처리한다. |
  | `statementType` | 위 내용과 같다. 마이바티스는 Statement, PreparedStatement 그리고 CallableStatement을 매핑하기 위해 STATEMENT, PREPARED 그리고 CALLABLE 구문타입을 지원한다. |

- ### sql

  >  다른 구문에서 재사용가능한 SQL구문을 정의할 때 사용된다. 로딩시점에 정적으로 파라미터처럼 사용할 수 있다. 다른 프로퍼티값은 포함된 인스턴스에서 달라질 수 있다. 반복되는 쿼리를 미리 작성해 놓고 재활용 할 수 있게 해준다. 


  ```xml
  <sql id="userColumns"> ${alias}.id,${alias}.username,${alias}.password </sql>
  
  <select id="selectUsers" resultType="map">
    select
      <include refid="userColumns"><property name="alias" value="t1"/></include>,
      <include refid="userColumns"><property name="alias" value="t2"/></include>
    from some_table t1
      cross join some_table t2
  </select>
  ```

  프로퍼티값은 다음처럼 refid속성이나 include절 내부에서 프로퍼티값으로 사용할 수 있다.

```xml
<sql id="sometable">
  ${prefix}Table
</sql>

<sql id="someinclude">
  from
    <include refid="${include_target}"/>
</sql>

<select id="select" resultType="map">
  select
    field1, field2, field3
  <include refid="someinclude">
    <property name="prefix" value="Some"/>
    <property name="include_target" value="sometable"/>
  </include>
</select>
```



- ### Parameters

- #### 문자열 대체(String Substitution)

- ### Result Maps

  > 모든 칼럼의 값이 결과가 되는 간단한 구문에서는 HashMap에서 키 형태로 자동으로 매핑된다. 하지만 대부분의 경우 HashMap은 매우 좋은 도메인 모델이 되지는 못한다. 그래서 대부분 도메인 모델로는 자바빈이나 POJO 를 사용할 것이다. 마이바티스는 둘다 지원한다.


  ```xml
  <select id="selectUsers" resultType="com.someapp.model.User">
    select id, username, hashedPassword
    from some_table
    where id = #{id}
  </select>
  ```

​	sql의 컬럼명과 com.someapp.model.User의 필드변수의 이름이 같다면 매칭시킨다. 

```xml
<!-- XML설정파일에서 -->
<typeAlias type="com.someapp.model.User" alias="User"/>

<!-- SQL매핑 XML파일에서 -->
<select id="selectUsers" resultType="User">
  select id, username, hashedPassword
  from some_table
  where id = #{id}
</select>
```

클래스명이 길어서 alias를 주는 것도 코드를 줄이는 방법.

```xml
<select id="selectUsers" resultType="User">
  select
    user_id             as "id",
    user_name           as "userName",
    hashed_password     as "hashedPassword"
  from some_table
  where id = #{id}
</select>
```

칼럼명과 property명이 다르다면 위와 같이 맞춰주자

```xml
<resultMap id="userResultMap" type="User">
  <id property="id" column="user_id" />
  <result property="username" column="username"/>
  <result property="password" column="password"/>
</resultMap>
```

```xml
<select id="selectUsers" resultMap="userResultMap">
  select user_id, user_name, hashed_password
  from some_table
  where id = #{id}
</select>
```

위와 같이 명시적인 resultMap을 선언하는 방법도 있다.