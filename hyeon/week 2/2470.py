N = int(input())
lst = list(map(int,input().split()))
lst.sort()

def check():
    result = float('inf')
    answer = []
    start = 0
    end = N-1

    while(start < end):
        sum = lst[start] + lst[end]

        if abs(result) > abs(sum):
            answer = [lst[start], lst[end]]
            result = sum

        if sum > 0:
            end -= 1 
        elif sum < 0:
            start += 1
        else:
            break
    
    return answer

print(*check())

