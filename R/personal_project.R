library(RSelenium)
library(tm)
library(SnowballC) 
library(wordcloud)
library(RColorBrewer)
library(tm)
library(stringr)
library(dplyr)
library(tidyr) 

##동적 크롤링=================================
remDr <- remoteDriver(remoteServerAddr="localhost", port=4445, browserName ="chrome")
remDr$open()
urls <- c("https://news.google.com/search?q=%22North%20Korea%22%20%2B%20%22South%20Korea%22&hl=en-US&gl=US&ceid=US%3Aen","https://news.google.com/search?q=%22Moon%20Jae-in%22%20%20%2B%22Kim%20jong%20un%22&hl=en-US&gl=US&ceid=US%3Aen", "https://news.google.com/search?q=%22South%20Korea%22%20%20%22USA%22&hl=en-US&gl=US&ceid=US%3Aen","https://news.google.com/search?q=%22%22Moon%20Jae%20in%22%22%20%20%22Trump%22&hl=en-US&gl=US&ceid=US%3Aen","https://news.google.com/search?q=%22Kim%20jong%20un%22%20%2B%22Trump%22&hl=en-US&gl=US&ceid=US%3Aen","https://news.google.com/search?q=%22North%20Korea%22%20%20%22USA%22&hl=en-US&gl=US&ceid=US%3Aen")



for(i in seq(from=1,to=5,by=2)){
  titles <- c()
  for(index in 0:1){
    remDr$navigate(urls[i+index])
    webElem <-remDr$findElement("css","body")
    remDr$executeScript("scrollTo(0,document.body.scrollHeight)",args=list(webElem))
    Sys.sleep(1)
    title <- remDr$findElements(using="css",".DY5T1d")
    title <- sapply(title, function(x){x$getElementText()})
    titles <-c(titles, unlist(title))
  }
  if(i==1){
    Korea <- titles    
    write.csv(Korea, "Korea.csv")
  }
  else if(i==3){
    South <- titles
    write.csv(South, "South.csv")
  }else{
    North <- titles
    write.csv(North, "North.csv")
  }
}
remDr$close()


##전처리=========================================
useNIADic()
for(i in 1:3){
  if(i==1)
    docs <- Korea
  
  else if(i==2)
    docs <- South
  else
    docs <- North
  docs <- tolower(docs)
  docs <- unique(docs)
  docs <-gsub("(trump)","",docs) 
  docs <- Corpus(VectorSource(docs))
  docs <- tm_map(docs, stripWhitespace)
  docs <- tm_map(docs, tolower)
  docs <- tm_map(docs, removeNumbers)
  docs <- tm_map(docs, removeWords, stopwords("english"))
  docs <- tm_map(docs, removePunctuation)
  docs <- tm_map(docs, stemDocument)
  
  
  #============감성 분석(긍정 & 부정==================
  my.df.text <- tibble(id=1:length(docs), doc=docs$content)
  my.df.text.word <- my.df.text %>% 
    unnest_tokens(word, doc) 
  
  myresult.sa <- my.df.text.word %>% 
    inner_join(get_sentiments("nrc")) %>% 
    count(word, id, sentiment) %>% 
    spread(sentiment, n, fill=0)
  
  myagg <- summarise(group_by(myresult.sa, id),
                     pos.sum=sum(positive),
                     neg.sum=sum(negative),   
                     pos.sent=pos.sum-neg.sum)
  print(sum(myagg$pos.sent))
  if(i==1)
    result_Ko = sum(myagg$pos.sent)
  else if(i==2)
    result_So = sum(myagg$pos.sent)
  else
    result_No = sum(myagg$pos.sent)
  
}

library(ggplot2)
ggplot(data=myagg, aes(x=pos.sum)) + geom_bar()
ggplot(data=myagg, aes(x=neg.sum)) + geom_bar()
ggplot(data=myagg, aes(x=pos.sent)) + geom_bar()

emolex <- data.frame(get_sentiments("nrc"))
table(emolex$sentiment) # 다양한 감정들을 알려줌
myresult.sa <- my.df.text.word %>% 
  inner_join(get_sentiments("nrc")) %>% 
  count(word, id, sentiment) %>% 
  spread(sentiment, n, fill=0)
myagg <- summarise(group_by(myresult.sa, id),
                   pos.sum=sum(positive),
                   neg.sum=sum(negative),   
                   pos.sent=pos.sum-neg.sum)

ggplot()
