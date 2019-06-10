from random import randint

video = []
for i in range(10) :
    video.append(randint(0,255))

print("원 영상 ==> ",video)

for i in range(10):
    video[i] += 10
print("결과 영상 ==> ",video)
