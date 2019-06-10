sumOfOdd =0;
sumOf7th =0;
sumOf7878 =0;
for i in range(1,100) :
    if(i % 2 ==1) :
        sumOfOdd += i;
    if(i%7 ==0) :
        sumOf7th += i;

for i in range(12345, 100000):
    if(i%7878 ==0) :
        sumOf7878 += i;

print("홀수의 합 = ", sumOfOdd ," 7의 배수의 합 = ", sumOf7th ," 7878배수의 합 = ",sumOf7878)



