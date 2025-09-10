import sys
from collections import deque
sys.stdin = open("250910-1.txt")
input = sys.stdin.readline

n, m = map(int, input().split())

soldier = []

for _ in range(m) :
    soldier.append(list(input().strip()))



def bfs(color) :
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    result = 0
    visit = [[False] * n for _ in range(m)]
    queue = deque()

    for i in range(m) :
        for j in range(n) :
            if soldier[i][j] != color :
                continue
                
            if not visit[i][j] :
                queue.append((i,j))
                visit[i][j] = True
                count = 1

                while queue :
                    x, y = queue.popleft()

                    for k in range(4) :
                        nx = x + dx[k]
                        ny = y + dy[k]

                        if nx < 0 or nx >= m or ny < 0 or ny >= n :
                            continue
                            
                        if soldier[nx][ny] != color :
                            continue

                        if not visit[nx][ny] :
                            queue.append((nx,ny))
                            visit[nx][ny] = True
                            count +=1
                result += count * count
    return result

print(bfs('W'), bfs('B'))