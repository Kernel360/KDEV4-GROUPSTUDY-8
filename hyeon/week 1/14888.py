n = int(input())
nums = list(map(int,input().split()))
operator = list(map(int,input().split()))

operator_lst = []

def check_all_operator(lst):
    global operator

    if sum(operator) == 0:
        operator_lst.append(lst)

    for i in range(4):
        if operator[i] > 0:
            operator[i] -= 1
            check_all_operator(lst + [i])
            operator[i] += 1

check_all_operator([])

def calculate(operator):
    t = 0
    result = nums[0]
    for i in range(1,n):
        if operator[t] == 0:
            result = result + nums[i]
            #더하기
        elif operator[t] == 1:
            result = result - nums[i]
            #빼기
        elif operator[t] == 2:
            result = result * nums[i]
            #곱셈
        elif operator[t] == 3:
            if result < 0 :
                result = -((-result)//nums[i])
            else:
                result = result//nums[i]
            #나눗셈
        t+=1

    return result

Min = float('inf')
Max = -float('inf')
for order in operator_lst:
    result = calculate(order)
    Min = min(result, Min)
    Max = max(result, Max)

print(Max, Min, sep="\n")