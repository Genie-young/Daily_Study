# R

## 1. R의 기본 문법

### 1.변수 정의 및  벡터

```R
english <- c(90,80,60,70)
math <-c(50,60,100,20)
data.frame(english, math)
sequential1 <- seq(1,5)
sequential2 <- seq(1,10, by=2)
sequential3 <- rep(c(1,2,3), times | each) //times는 전체 반복, each는 각 원소
```



### 2. 숫자 및 문자 함수

```R
x <- c(1,2,3,4)
mean(x)  #평균
max(x)   #최댓값
min(x)   #최솟값
median(x)#wnddkdrkqt
sqrt(x)  #분산의 제곱근(평균과 단위를 맞춰주기 위해)
sd(x)     #표준편차
quantile(s) #사분위수 구하기
sort(x, decreasing=T)#정렬
```



```
str <- c("he", "ll", "o")
paste(str, collapse=",") # "He,ll,o"

```



< 평균과 중앙값 >

 최빈값 = 중앙값 ==> 최빈값 = 평균 , 좌우대칭

최빈값 or 중앙값 ==> 최빈 =중앙값 <평균 , 꼬리가 오른쪽으로 늘어짐

최빈 or 중앙값 ==> 최빈 =중앙값 > 평균, 꼬리가 왼쪽으로 늘어짐. 



<데이터의 크기>

행이 많다 ==> 컴퓨터가 느려짐 ==> 고사양 장비 구축

열이 많다 ==> 분석 방법의 한계 ==> 고급 분석 방법



### 3. 외부데이터 이용하기

```R
#excel파일 읽기
library(readxl)
df_exam <- read_excel("excel_exam.xlsx", col_name=F, sheet=3)
#col_name=T는 첫행을 변수명으로 인식

#csv파일 읽기, 쓰기
df_csv_exam <-read.csv("csv_exam.csv", stringAsFactors=F)
write.csv(df_midterm, file="df_midterm.csv")

#RData(.rda)파일 읽기, 쓰기
save(df_midterm, file="df_midterm.rda")
load("df_midterm.rda")

#txt파일 한줄씩 읽기
txt<-readLines("hiphop.txt")
```





### 4. 데이터 속성 함수

```R
head()   #앞부분 출력
tail()   #뒷부분 출력
View()   #뷰어창에서 데이터 확인
dim()    #차원 출력
str()    #속성 출력
summary()#요약 통계량 출력(min, 1st Qu, median, mean, 3rd Qu, max)
quantile()#사분위수	



```



### 5. dplyr 라이브러리

#### 1) rename() , 변수명 바꾸기

```R
library(dplyr)
df_row <-data.frame(var1 = c(1,2,1),
					var2 = c(2,3,2))
df_new <-rename(df_raw, v1 <- var1) #꼭 재대입해야함.
```



#### 2) 전처리 함수

```R
filter()    #행 추출
select()    #열 추출
arrange()   #정렬
mutate()    #변수 추가
summarise() #집단별 통계치 산출
group_by()  #집단별로 나누기
left_join() #데이터 합치기(열)
bind_row()  #데이터 합치기(행)
```

 - filter()   #행 추출

   ```R
   exam %>% fileter(class == 1)
   ```

 - select()  #열 추출

   ```
   exam %>% select(math) %>% head
   exam %>% select(-math)
   ```

 - arrange()   #정렬

   ```R
   arrange(class, math)      #클래스를 기준으로 정렬하고 그 상태에서 math로 정렬함.
   arrange(desc(math))       #내림차순 정렬 ==> default 는 오름차순
   ```

 - mutate()    #변수 추가

   ```R
   exam <-exam %>% mutate(total = math+english+science, mean =(math+english+science)/3)
   exam <-exam %>% mutate(total =math+english+science) %>% arrange(total) %>% head
   ```

 - summarise() #통계치 산출 - 집단별로

   ```R
   exam %>% summarise(mean_math = mean(math))
   ```
   summarise 요약 통계 함수
   
   ```R
   mean()   #평균
   sd()     #평균
   sum()    #표준편차
   sum()    #합계
   median() #중앙값
   min()    #최솟값
   max()    #최댓값
   n()      #행 개수
   ```
   
 - group_by()  #집단별로 나누기

   ```R
   exam %>% group by(class) %>% summarise(mean_math = mean(math), n = n()) 
   ```

 - left_join() #데이터 합치기(열)

	- bind_row()  #데이터 합치기(행)



#### 3) 연산자

```R
%in%    #매칭확인     
mpg %>% filter( manufacturer%in% c("honda" ,"chevrolet", "ford")) 
^ , **  #제곱
%/%     #나눗셈의 몫
%%      #나눗셈의 나머지
```



### 6. 파생변수 생성

```R
mpg$total <-(mpg$cty + mpg$hwy)/2
mpg$test <- ifelse(mpg$total>=20, "pass","fail")
```



### 7. 빈도 확인(빈도표, 빈도막대그래프)

```R
table(mpg$test) #빈도표
qplot(mpg$test) #빈도막대그래프
```



### 8. 합치기

```R
total <-left_join(test1, test2, by="id")  #id속성을 기준으로 test1의 열과 test2의 열을 합침
group_all <- bing_rows(group_a, group_b)  #데이터의 행을 합침
```



### 9. 결측치 정제

#### 1)결측치 찾기

```R
is.na(df)
table(is.na())
df %>% filter(!is.na(score))  #score에서 NA아닌 값들만 추출

df <- na.omit(df)             #모든 변수에 결측치가 없는 데이터 추출
mean(df$score, na.rm =T)      #NA값을 연산에 포함하지 않음.
exam(c(3,8,15),"math") <- NA  #math열 중에서 3,8,15번째 행을 NA값으로 변경함.

```

#### 2) 결측치 대체하기( Imputation )

```R
exam$math <- ifelse(is.na(exam$math), mean(exam$math), exam$math)  #평균값으로 대체
```



### 10. 이상치 정제하기

```R
table(outlier$score)     #이상치 확인
outlier$sex <- ifelse(outlier$sex == 3, NA, outlier$sex)
```

boxplot으로 확인하기

```R
boxplot(mpg$hwy)
```

- 상자밑면 - 1사분위수 - 하위 25%위치 값
- 상자 내 굵은 선 - 2사분위수 - 하위 50%값, 중앙값
- 상자 윗면 - 3사분위수 - 하위 75% 위치 값
- 상자 밖 가로선 : 극단치 경계
- 상자 밖 점섬 : 극단치





------

## 2. Graph

### 1. ggplot2

- ggplot2 레이어 구조

  1 단계 : 배경설정(축)

  2 단계 : 그래프 추가

  3 단계 : 설정 추가(축 범위, 색, 표식)

  ```R
  library(ggplot2)
  #산점도 만들기
  ggplot(data=mpg, aes(x=displ, y=hwy))     #배경 그림 설정하기
  ggplot(data=mpg, aes(x=displ, y=hwy)) +geom_point() +   #배경 위에 산점도 추가하기
  xlim(3,6) + #x축의 범위 설정하기 
  ylim(10,30) #y축의 범위 설정하기
  
  #막대그래프 만들기
  ggplot(data=mpg, aes(x=drv,y=mean_hwy))+geom_col()  
  ggplot(data=mpg, aes(x=reorder(drv, -mean_hwy), y=mean_hwy)) +geom_col()  
  #drv를 x축으로 하고, mean_hwy를 기준으로 내림차순정렬함. 
  
  # 빈도 막대그래프 만들기
  ggplot(data=mpg, aes(x=drv)) + geom_bar() 
  
  #시계열 그래프 만들기
  ggplot(data=econoics, aex(x=date, y=unemploy)) + geom_line()
  
  #boxplot
  ggplot(data=mpg,aex(x=drv, y= hwy)) + geom_boxplot()
  
  ggplot(data=df, aes(x=reorder(drv,meanHwy), y=meanHwy))+geom_col() #reorder(정렬대상변수(factor), 연속형변수) drv을 meanHwy를 기준으로 오름차순으로 정렬.
  ggplot(data=df, aes(x=reorder(drv,-meanHwy), y=meanHwy))+geom_col() #내림차순정렬
  
  ```

- ggplot2  more

  치트 시트 : Rstudio -> help -> cheatsheets -> dataVisualization with ggplot2

  사용자가 만든 그래프 보기 : bit.ly/2s5cmdc



## 3. 추가

### 1. Data.frame 함수

```R
rbind(c(1,2,3), c(4,5,6))    #벡터를 하나의 행으로 만들어 더함. 결과 2x3 행렬
cbind(c(1,2,3), c(4,5,6))    #벡터를 열로 만들어 더함. 결과 3x2 행렬
```

### 2.matrix

```R
a<-matrix(1:9,ncol=3)		#열의 갯수가 3인 matrix를 만들어라3.
```

### 3. apply 함수

```R
apply(a,2,sum)					#~자료에~함수를 적용해라
apply(iris[ ,1:4], 2, sum)		 #1~4열까지 각 열의 합계 출력
apply(iris[ ,1:4], 2, mean)
apply(iris[ ,1:4], 2, max)
apply(iris[ ,1:4], 2, min)
apply(iris[ ,1:4], 2, sd)		#표준 편차

rowSums(iris[,1:4])				#colSums
rowMeans(iris[,1:4])			#colMeans

res<-lapply(1:3, function(x) {x*2})  #리스트의 각 열에 function을 적용한 벡터를 return.
class(sapply(iris[,1:4], mean))		#벡터
tapply(1:10,rep(1,10),sum) 			#tapply(벡터,그룹색인,그룹단위적용함수)   
```



### 4. doBy

```
summaryBy(Sepal.Length~Species,iris)		#species그룹 별로 length의 mean값 구하기
iris[order(iris$Sepal.Length,iris$Sepal.Width,decreasing = TRUE), ] #오름차순 정렬한 인덱스 반환하는 order 함수
```



### 5. 샘플 함수

```
sample(1:45, 6)					#비복원추출
sample(1:45, 6, replace =TRUE)	  #복원추출
```



### 6. Subset

```R
subset(iris, Species=="setosa")		#setosa품종인 애들의  subset을 return
subset(iris, select=c(Species,Sepal.Length))
iris[, !names(iris) %in% c("Species","Sepal.Length")]
```



### 7. KoNLP

```R
library(rJava) 	#오류날 때, Sys.setenv(JAVA_HOME='C:\\Program Files\\Java\\jre1.8.0_211') 
library(KoNLP)	#시스템 변수에 JAVA_HOME추가해서 C:\Program Files\Java\jdk-12.0.1\bin 추가
library(stringr)
useNIADic()		#한나눔 사전 다운
txt<-str_replace_all(txt,"\\W"," ")		#특수기호 없이 가져옴.

nouns<-extractNoun(txt)		#명사추출
wordcount<-table(unlist(nouns))
df<-as.data.frame(wordcount,stringsAsFactors =F)
df<-filter(df, nchar(Var1)>=2)
```



### 8. wordCloud

```R
pal<-brewer.pal(10, "Dark2")	#팔레트 다운
wordcloud(words=df$word, freq=df$freq, min.freq = 3, max.words = 100,colors=pal,scale=c(4,0.3),random.order=F)

```



### 9.문자열 함수

```R
tolower("Eye for eye")
toupper("Eye for eye")

nchar('korea')
nchar('대한 민국')

mysentence<-"Learning R is so interesting"
mystr<-strsplit(mysentence, split=" ")
mystr[[1]]
mystr[[1]][1]
mystr[[1]][5]
strsplit(mystr[[1]][5],split="")	##단어 -> 문자로 분리

paste(myletters[[1]],collapse = "")
rwiki_para<-strsplit(rwiki,split="\n") #문단을 문장단위로 쪼개서 리스트로 return

test<-str_replace_all(test,"\\W"," ") 	#특수문자를 filter함.
test<-str_replace_all(test,"\\d"," ")	#숫자를 filter함.

```

# interactive plot 그리기



다음주부터 상관분석을 좀 해야해요.

결과를 미친 요소들 중에서 어떤 요소들이 크게 영향을 미치는지.

```R
install.packages("devtools")
library(devtools)
install_github("cardiomoon/kormaps2014")
library(kormaps2014)
str(changeCode(korpop1))


# 지도를 그리고 지도 위에 지역별로 나눠서 지역별 인구를 기준으로 인구가 많은 지역은
# 과밀지역 같은 경우에는 색상을 진한 색으로
# 그렇지 않은 지역은 연한 색으로
# 어떤 지역이 인구밀도가 높은지 해보겠습니다.

library(ggiraphExtra)
library(ggplot2)
# 이 두가지 라이브러리는 지도를 그리기 위해서는 필수죠.

library(dplyr)
korpop1<-rename(korpop1,
       pop="총인구_명",
       name="행정구역별_읍면동")
str(changeCode(kormap1))
ggChoropleth(data=korpop1,
             aes(fill=pop, # 색상별로 표현할 변수
                 map_id=code,  # 지역 기준이 되는 변수를 코드를 기준으로 하겠다.
                 tooltip=name), # 지도 위 표시할 지역명
             map=kormap1, # 지도 데이터
             interactive = T # 인터렉티브
             )
# choropleth라는 의미는 지도로 나눠서 뭔가를 입힌다는 용어가 되겠습니다.
# 이 함수 의미 그대로 구현을 해서, 지도로 표현을 한 번 해보겠는데,
# 이 함수를 이용할 때는 데이터를 줘야할 텐데,

# 한글을 그대로 넣어줘도 되는데 문제가 생기는 경우가 있어요
# 그래서 컬럼명을 영어로 좀 바꿔줄 필요가 있습니다.
# 지역 기준에 해당하는 변수가 있습니다.
# 지도 관련된 api는 많이 있습니다.

str(changeCode(tbc))
# tbc라는 데이터 셋이 있는데요, 우리나라 지역별로
# 결핵환자 몇 명이 있는지 나타내는 데이터 셋입니다.
# newPts라고 돼있는 부분이 결핵환자 수에요

ggChoropleth(data=tbc,
             aes(fill=NewPts,
                 map_id=code,
                 tooltip=name1),
             map=kormap1,
             interactive = T
             )
```

# interactive plot 그리기

```R
install.packages("plotly")
library(plotly)

# interactive 하지 않은 plot 그리기
ggplot(data=mpg, aes(x=displ,
                      y=hwy,
                      col=drv))+
  geom_point()

# interactive plot 그리기
p<-ggplot(data=mpg, aes(x=displ,
                        y=hwy,
                        col=drv))+
  geom_point()

ggplotly(p)
```



# interactive bar plot 그리기

```R
# 다이아몬드라고 검색해봅시다.
str(diamonds)
# 다이아몬드들의 속성과 등급들을 나타내는 데이터 셋이에요
# 가격을 결정하는데, 중요한 요소는 무엇이냐 유추해 볼 수 있는 데이터 셋인데
# x축에는 cut, y축에는 clarity를 줘서 컷 마다 clarity에 따라 어떻게 가격이 변하는지 보자구요

ggplot(data=diamonds, aes(x=cut, fill=clarity))+
  geom_bar(position="dodge")
# dodge라고 하면, 이렇게 됩니다.
p<-ggplot(data=diamonds, aes(x=cut, fill=clarity))+
  geom_bar(position="dodge")
ggplotly(p)
```



![1558486345671](C:/Program%20Files/Typora/img/11.png)



# 시계열 그래프 그리기

```R
# interactive 시계열 그래프도 그려보죠

# 시계열 그래프(dygraphs)
install.packages("dygraphs")
library(dygraphs)
str(economics)
head(economics)
str(economics)
tail(economics)
# psavert: personal saving rate

# library 중에서 xts라는 library가 있는데 시계열 데이터셋을 만들어주는 라이브러리입니다.
library(xts)
eco<-xts(economics$unemploy, order.by = economics$date)
# orderby는 시간에 해당하는 데이터를 부여하면 될 것 같아요
# 사실 order.by가 행 index로 들어가죠.
dygraph(eco)
# 마우스를 갖다대보세요.
# 날짜에 대해서 범위를 잡을 수도 있거든요.
dygraph(eco) %>% 
  dyRangeSelector() # dyR하고 기다리시면 dyrangeselector가 나올거에요
```

# 여러개의 시계열 그래프 그리기

```R
# 이렇게 저는 그래프를 하나만 출력했는데 여러개를 나타내 볼게요.
# 저축률을 위에다가 출력해볼게요.

eco_a<-xts(economics$psavert, order.by = economics$date)
eco_b<-xts(economics$unemploy/1000, order.by = economics$date)

eco2<-cbind(eco_a, eco_b)
eco2
str(eco2)
# 다른 이름으로 변경할 수 있습니다.
colnames(eco2)<-c("psavert", "unemploy")
head(eco2)
dygraph(eco2) %>% 
  dyRangeSelector()

# 나중에 주식 예측하는거 만들어볼텐데 dyGraph를 만들어서 하면 보기가 좋죠.

```



# 학습정리

## 인덱싱

```R
# 변수: 연속, 범주형 변수
exam<-read.csv("Data/csv_exam.csv")
exam
exam[] # 대괄호로 나타낼 때는 위치를 나타내는 index
exam[2, ]

# class가 1인 행 추출

exam[exam$class==1, ] # 이 패턴을 많이 쓰니까 기억하는 것이 좋아요.
exam %>%  # 내가 쓴 표현임.
  filter(class==1)

# 수학점수 80점 이상인 행 추출
exam[exam$math>=80, ]

# 2반 이면서 영어점수가 70점 이상인 행 추출
exam[exam$class==2 & exam$english>=70, ]

# 영어점수 90점 미만이거나 과학이 50점 미만인 것 추출
exam[exam$english<90 | exam$science<50, ]

# exam에 가보면 맨 왼쪽에 1부터 시작해서 행 인덱스라고 불러요.
# 행 인덱스는 열로 보지 않습니다.
# id, class, math, english, science가 열이고 행 인덱스는 열이 아니라구요

# id열 추출
exam[, "id"]
exam[, 1]

# class, math열 추출
exam[, c("class", "math")]
exam[, c(2, 3)]

# 1행 3열 추출
exam[1, 3]

# 5행 math열 추출
exam[5, "math"]

# math가 50점 이상인 행에 대한 english열
exam[exam$math>=50, "english"]

#math가 50점 이상인 행에 대한 english, science열 추출
exam[exam$math>=50, c("english", "science")]

# 수학>=50, 영어>=80인 학생에 대해
# 각 반의 전과목 총 평균을 출력
```



## dplyr를 사용

```R
# dplyr를 사용
exam %>% 
  filter(math>=50 & english>=80) %>% 
  mutate(tot=(math+english+science)/3) %>% 
  group_by(class) %>% 
  summarise(myMean=mean(tot))
```



## aggregate 사용(예전 방법입니다. 추천하지 않음)

```R
# dplyr가 좀 더 최신 방법인거고, 예전 방법은 어그리게이트 함수를 사용할 수 있어요
# 내장 함수를 사용(aggregate)
exam$tot<-(exam$math+exam$english+exam$science)/3
aggregate(data=exam[exam$math>=50 & exam$english>=80, ], tot~class,mean)
# 두 번째 인자는 formula가 오는데 tild 오른쪽에 오면돼요.
# 물결 기준 오른쪽이 group_by가 오고, 왼쪽이 함수를 적용할 대상이 와요.
```



## dplyr 사용 예제

```R
# mpg 데이터에서 dplyr를 사용해서 다음과 같이 출력하기
# class   meanTot
# compact xxx
# suv     yyy

mpg %>%
  mutate(tot=(hwy+cty)/2) %>% 
  filter(class=="compact" | class=="suv") %>% 
  group_by(class) %>% 
  summarise(meanTot=mean(tot))

# data가 바로 안나온다면, tibble을 dataframe으로 변환하는 것도 좋습니다.
# mpg<-as.data.frame(mpg). tibble에서는 데이터가 생략되어 나올 수 있습니다.

```



## 데이터 타입

```R
# 연속형 변수 (Numeric)
# 범주형 변수(Factor)
var1 <- c(1, 2, 3, 1, 2) # 수치형
var2 <- factor(c(1, 2, 3, 1, 2)) # 범주형
var1
var2

var1+3
var2+3 # 범주형에 대해서는 연산을 못하죠

levels(var2) # levels는 범주형 변수에 대해서 나오는 거라서 출력 되지만,
levels(var1) # var1는 범주형이 아니라서 안 나옵니다.
var3 <- c("a", "b", "b", "c")
var4 <- factor(c("a", "b", "b", "c"))
var3
var4

mean(var1)
mean(var2) # 수치형이 아니라서 NA가 출력됩니다.

var2 <- as.numeric(var2) # 수치형으로 변환

# as.data.frame() # 많이 쓰임
# as.character() # 많이 쓰임
# as.Date() # 많이 쓰임

# 벡터: 1차원, 한 가지 변수 타입으로 구성
# 행렬: 2차원, 한 가지 변수 타입으로 구성
# DF: 2차원, 다양한 변수 타입으로 구성
# array: 다차원(>=3), 한 가지 변수 타입으로 구성
# list: 2차원 이상(다차원), 다양한 변수 타입으로 구성

# 1. 벡터(1개 이상의 값, 1가지 타입)
a <- 1

# 2. DF(2차원,)
x1 <- data.frame(v1=c(1, 2, 3),
                 v2=c('a', 'b', 'c'))
x1
class(x1)

# 3. 행렬(2차원, 한 가지 타입)
x2 <- matrix(c(1:10), ncol=2)
x2

# 4. 배열(array, 2차원 이상, 한 가지 타입)
x3 <- array(1:20, dim=c(2, 5, 2)) # 행, 열, 깊이(depth)
x3

# 5. 리스트(list, 2차원 이상, 다양한 타입)
x4 <- list(f1=a, # 벡터
           f2=x1, # 데이터 프레임
           x3=x2, # 매트릭스
           f4=x3 # 배열
           ) # f1이라는 column에 대한 값으로. 각각의 데이터들을 줄 수 있습니다.
x4

# 함수의 리턴 결과가 리스트 타입인 경우가 많아요.
x <- boxplot(mpg$cty)
class(x)

# x 를 출력해보면 stats는 matrix로 보입니다.


> x$stats[, 1]
[1]  9 14 17 19 26
# 여기에서 중위수가 17인데, 
> x$stats[, 1][3] # 이런식으로 사용하면 돼요.

```



## list, vector 다루기

```R
myvector <- c(1:6, 'a') # 숫자와 문자가 같이 있으면 벡터에서는 문자가 됩니다.
str(myvector)

mylist <- list(1:6, 'a') # list에서는 다른 열로 나뉘어서 들어갑니다.
mylist

obj1 <- 1:4
obj2 <- 6:10
obj3 <- list(obj1, obj2)
obj3 # 각각의 열로 나뉘어서 들어갑니다.

mylist <- list(obj1, obj2, obj3)
mylist # 3번째 항목에는 리스트가 들어가는데, 여기 안에 또 두개로 나뉘어집니다.

# 벡터로 구성된 자료 -> [] 사용
# 리스트 형식 -> [[]] 사용

mylist[[3]][1] # list
mylist[[3]][[1]] # integer형 vector

# unlist: 리스트 -> 벡터
myvector <- c(1:6, 'a')
mylist <- list(1:6, 'a')
unlist(mylist) # 리스트 였던 것이 벡터가 됨
myvector

unlist(mylist) == myvector

mean(mylist[[1]][1:6])
mean(unlist(mylist)[1:6]) # NA가 나옴. 이유는 문자 벡터이기 때문에 mean함수가 적용이 안됨.

name1 <- "Donald"
myspace <- " "
name2 <- "Trump"
list(name1, myspace, name2)
unlist(list(name1, myspace, name2))

name <- c("갑", "을", "병", "정")
gender <- c(2, 1, 1, 2) # 성별을 갖는 수치 값 저장
mydata <- data.frame(name, gender)
mydata

attr(mydata$name, "what the variable means") <- "이름"
mydata$name
# attr 함수는 대상의 속성을 지정할 때 사용하는 함수입니다.
# 두 번째 인자는 일종의 별칭 정도로 받아들이시면 됩니다. 
# 데이터에 대한 부가적인 설명을 하고자 하는 경우에 attr 함수로 추가해주면 좋아요.
# 프로그래밍 할 때 주석을 다는 것처럼 유사한 것이라고 생각하시면 돼요.

attr(mydata$gender, "what the variable means") <- "성별"
mydata$gender
# 이런 것을 meta data라는 용어를 쓰죠.
# data를 설명하는 data 정도로 받아들이면 됩니다.

# 속성값 추출
mydata$gender.character <- attr(mydata$gender, "what the variable means")

mydata$gender

```



## apply 함수 복습

```R
mylist <- list(1:4, 6:10, list(1:4, 6:10))
mylist

# mylist에 3번을 평균을 구하고 싶다면?
mylist[[3]]
lapply(mylist[[3]], mean)
# lapply를 할 때 주의할 점인데, apply함수들이 사실 적용하고자 하는 데이터, 두 번째에는 함수가 오지 않습니까
# lapply에는 list가 들어가죠
lapply(mylist, mean) # 1번과 2번은 평균이 나오죠. 3번째 요소는 NA로 나오네요 그쵸.
# 왜 NA로 나오냐면 자료구조가 3번째는 벡터가 아니라 리스트이기 때문입니다.
lapply(mylist[c(1, 2, c(1, 2))], mean) # 이게 요소로 들어가는거에요.
# 리스트 안에 리스트가 들어가 있는 경우에는 이렇게 기재하시면 돼요.

wordlist <- c("the", "is", "a", "the")
doc1freq <- c(3, 4, 2, 4)
doc2freq <- rep(1, 4)

tapply(doc1freq, wordlist, length)
tapply(doc2freq, wordlist, length)
tapply(doc1freq, wordlist, sum)
tapply(doc2freq, wordlist, sum)

# tapply에서는 첫 번째 인자를 vector를 줬었죠, 두 번째 인자는 그룹화를 하기 위한 index를 줬었죠
tapply(1:10, rep(1, 10), sum)
# tapply(<vector>, <group index>, <function>)
# 함수는 그룹 단위로 함수가 적용이 된거 거든요

sent1 <- c("earth", "to", "earth")
sent2 <- c("ashes", "to", "ashes")
sent3 <- c("dust", "to", "dust")
# 한 문장에서 to는 1번, to가 아닌 단어는 2번 등장했습니다.
# 3개 문장에서 등장한 단어빈도 조사(tapply)
myfreq <- c(rep(1, length(sent1)), rep(1, length(sent2)), rep(1, length(sent3)))
# 1 1 1 1 1 1 1 1 1 1
tapply(myfreq, c(sent1, sent2, sent3), sum)

```

# 문자열 나누는 연습

```R
# 연습용 문자열
R_wiki <- "R is a programming language and software environment for statistical computing and graphics supported by the R Foundation for Statistical Computing. The R language is widely used among statisticians and data miners for developing statistical software and data analysis. Polls, surveys of data miners, and studies of scholarly literature databases show that R's popularity has increased substantially in recent years.
R is a GNU package. The source code for the R software environment is written primarily in C, Fortran, and R. R is freely available under the GNU General Public License, and pre-compiled binary versions are provided for various operating systems. While R has a command line interface, there are several graphical front-ends available."
# 문장을 단어 단위로 구분.
# 1. 문단 단위로 분리
r_wiki_para <- strsplit(R_wiki, split="\n")
r_wiki_para # 2개의 문단으로 분리됨

# 2. 문단 -> 문장 단위로 분리
r_wiki_sent <- strsplit(r_wiki_para[[1]], split="\\. ")
r_wiki_sent

# 3. 문장 -> 단어 단위로 분리
r_wiki_sent
r_wiki_word <- list()
for(i in 1:2){
  r_wiki_word[[i]] <- strsplit(r_wiki_sent[[i]], split=" ")
}
r_wiki_word

# r wiki word에 보면, language 단어만 추출
r_wiki_word[[1]][[2]][3]

```

# 정규 표현식

```R
> mysentence <- "Learning R is so interesting"
> regexpr('ing', mysentence)
[1] 6 # 6번째 위치에서 매칭 되었다는 의미입니다.
attr(,"match.length")
[1] 3 # matching되는 문자열의 길이가 얼마냐
attr(,"index.type")
[1] "chars" # matching되는 타입은 무엇이냐
attr(,"useBytes")
[1] TRUE

loc.begin <- as.vector(gregexpr('ing', mysentence)[[1]])

loc.length <- attr(gregexpr('ing', mysentence)[[1]], "match.length")

loc.end <- loc.begin + loc.length - 1

# regexec함수는 regexpr과 비슷.
# 간단한 표현 정도에서는 두 함수가 같은데,
regexpr('interesting', mysentence)
regexec('interesting', mysentence)

# regexec는 표현이 좀 더 자유로워요
regexec('in(t)erestin(g)', mysentence)
# 18 20 28: 18 28의 위치에서 matching되는데 interesting과 t, g가 각각 매칭됨.

regexec('so (intere(s)ting)', mysentence)
# 중첩된 표현으로도 매칭 가능
# 14 11 1의 길이만큼 매칭됨

# 다시 r_wiki_sent로 하기

# 아래와 같이 입력하면 벡터가 됩니다.
unlist(r_wiki_sent)

# software 단어 검색
mysentences <- unlist(r_wiki_sent)
regexpr("software", mysentences)

# 2회 이상 software라는 단어가 등장했는지 여부
gregexpr("software", mysentences)

mytemp <- regexpr("software", mysentences)
my.begin <- as.vector(mytemp)
my.begin[my.begin==-1] <- NA
my.begin

my.length <- attr(mytemp, "match.length")

my.end <- my.begin + my.length - 1

my.locs <- matrix(NA, nrow=length(my.begin), ncol=2) # 7행 2열의 matrix가 만들어집니다.
colnames(my.locs) <- c('begin', 'end') # matrix에서 column의 이름을 바꿈
my.locs

rownames(my.locs) <- paste('sentence', 1:length(my.begin), sep = ".")
my.locs

# for 문으로 값을 할당하는 방법
for(i in 1:length(my.begin)){
  my.locs[i, ] <- cbind(my.begin[i], my.end[i])
}

cbind(my.begin[1], my.end[1])
# cbind(my.begin, my.end) 이렇게 하면 한 방에 합쳐짐.

# 함수중에 grep이라는 함수 많이 쓰는데요.
grep('software', mysentences) # [1] 1 2 5 의 의미는 1, 2, 5번 문장에서 발견됨
grepl('software', mysentences) # l의 의미는 logic의 약자입니다. return 값이 논리형으로 나옵니다.

# mysentence에서 ing -> ING로 변환
sub("ing", "ING", mysentence) # 치환하는 함수입니다.
gsub("ing", "ING", mysentences) # 모두 치환하는 함수입니다.

# 고유명사인데 공백으로 나뉘어져 있으면 하나의 단어로 안 보이기 때문에 묶어주는 것이 필요합니다.
sent1 <- r_wiki_sent[[1]][1]
new.sent1 <- gsub("R Foundation for Statistical Computing",
     "R_Foundation_for_Statistical_Computing",
     sent1)

# sent1에 저장되어 있는 것이 첫 번째 문단에 있는 첫 번째 문장인데, 공백으로 구분해 볼게요.
sum(table(strsplit(sent1, split=" "))) # 전체 단어의 개수

new.sent1
sum(table(strsplit(new.sent1, split=" "))) # 전체 단어의 개수가 줄어든 것을 볼 수 있습니다.

# 단어 제거
drop.sent1 <- gsub("and |by |for |the ", "", new.sent1)
sum(table(strsplit(drop.sent1, split=" ")))


# 패턴 저장
mypattern <- regexpr('ing', mysentence)
# 패턴과 매치되는 문자열 추출
regmatches(mysentence, mypattern)

mypattern <- gregexpr('ing', mysentence)
regmatches(mysentence, mypattern)

# invert옵션: 해당 표현을 제외
regmatches(mysentence, mypattern, invert = T)

mysentences
substr()

# ing로 끝나는 모든 단어를 추출하기!!. interesting => o, singer => x
my2sentence <- c("Learning R is so interesting", "He is a fascinating singer")
regexpr("ing", my2sentence)
mypattern0 <- gregexpr("ing", my2sentence) # 다 나타났으면 좋겠다면, gregexpr
regmatches(my2sentence, mypattern0)

# ing 앞에 알파벳만 올 수 있음
mypattern1 <- gregexpr("[[:alpha:]](ing)", my2sentence) # 모든 알파벳 문자를 나타내는 정규식
regmatches(my2sentence, mypattern1)

# ing 앞에 최소 1회 이상 알파벳이 올 수 있도록 정규식 변경
mypattern2 <- gregexpr("[[:alpha:]]{1, }(ing)", my2sentence) # 모든 알파벳 문자를 나타내는 정규식
regmatches(my2sentence, mypattern2)
# {1, } 콤마 왼쪽에 1이 있는 것은 한글자 이상, 오른쪽에 아무것도 없이 때문에 무한대까지

# ing로 끝나는 모든 단어 추출하기
mypattern3 <- gregexpr("[[:alpha:]]{1, }(ing)\\b", my2sentence)
regmatches(my2sentence, mypattern3)

mypattern3 <- gregexpr("[[:alpha:]]+(ing)\\b", my2sentence) # 더하기 기호는 {1, }와 같은 의미. 1글자 이상
regmatches(my2sentence, mypattern3)

mysentences
mypattern <- gregexpr("[[:alpha:]]+(ing)\\b", mysentences) # 더하기 기호는 {1, }와 같은 의미. 1글자 이상
myings <- regmatches(mysentences, mypattern)
table(unlist(myings))

# 대소문자를 일괄 통일(대 -> 소)
mypattern <- gregexpr("[[:alpha:]]+(ing)\\b", tolower(mysentences)) # 더하기 기호는 {1, }와 같은 의미. 1글자 이상
myings <- regmatches(tolower(mysentences), mypattern)
table(unlist(myings))

```



## 연습문제

1. mysentences에서 stat~ 로 시작되는 표현 추출
2. 가장 많이 사용된 단어?
3. 총 몇 개의 알파벳 문자가 쓰였을까?
4. 가장 많이 사용된 알파벳 문자는?
5. 4번 결과를 시각화