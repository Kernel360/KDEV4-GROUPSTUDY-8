N = int(input())
lst = [list(map(int,input().split())) for _ in range(N)]

dic = dict()

for x,y in lst:
    if y not in dic:
        dic[y] = []
    dic[y].append(x)

answer = 0    
for data in dic.values():
    data.sort()
    for i in range(len(data)):
        if i == 0:
            answer += data[i+1] - data[i]
        elif i == len(data) - 1:
            answer += data[i] - data[i-1]
        else:
            answer += min(data[i+1] - data[i], data[i] - 
            data[i-1])

print(answer)