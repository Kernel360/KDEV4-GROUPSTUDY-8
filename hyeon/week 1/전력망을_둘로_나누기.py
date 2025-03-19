from collections import deque


def solution(n, wires):
    answer = float('inf')
    graph = [[] for _ in range(n + 1)]

    for x, y in wires:
        graph[x].append(y)
        graph[y].append(x)

    def bfs(x, lst):
        q = deque([x])
        visited = [0] * (n + 1)
        visited[x] = 1
        result = 0
        while (q):
            cur_x = q.popleft()
            for next_x in graph[cur_x]:
                if not visited[next_x] and not (cur_x == lst[0] and next_x == lst[1]) and not (
                        cur_x == lst[1] and next_x == lst[0]):
                    visited[next_x] = 1
                    q.append(next_x)
                    result += 1
        return result

    for x, y in wires:
        answer = min(answer, abs(bfs(x, [x,y]) - bfs(y, [x,y])))

    return answer