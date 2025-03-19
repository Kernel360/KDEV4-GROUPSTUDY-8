import sys
from collections import deque

N,L,R = map(int,sys.stdin.readline().split())
graph = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

dr = [[1,0],[-1,0],[0,1],[0,-1]]
def bfs(x,y,k):
    global visited
    Sum = graph[x][y]
    cnt = 1
    q= deque([[x,y]])
    visited[x][y] = k

    while(q):
        x,y = q.popleft()
        for dx,dy in dr:
            nx = x+dx
            ny = y+dy
            if 0<=nx<N and 0<=ny<N and not visited[nx][ny]:
                if L<=abs(graph[x][y] - graph[nx][ny]) <= R:
                    visited[nx][ny] = k
                    Sum += graph[nx][ny]
                    cnt+=1
                    q.append([nx,ny])

    return Sum // cnt

answer = -1
while(1):
    answer+=1
    visited = [[0]*N for _ in range(N)]
    lst = dict()
    k = 1
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                lst[k] = bfs(i,j,k)
                k+=1

    if k == N*N + 1:
        break

    for i in range(N):
        for j in range(N):
            graph[i][j] = lst[visited[i][j]]

print(answer)