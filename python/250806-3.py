import sys
from collections import deque
input = sys.stdin.readline

def bfs(start_x, start_y):
    queue = deque([(start_x, start_y)])
    data[start_x][start_y] = -1
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if (0 <= nx < m) and (0 <= ny < n) and data[nx][ny] == 1:
                data[nx][ny] = -1
                queue.append((nx, ny))

T = int(input())

for _ in range(T):
    m, n, k = map(int, input().split())
    data = [[0 for _ in range(n)] for _ in range(m)]
    
    for _ in range(k):
        x, y = map(int, input().split())
        data[x][y] = 1
    
    count = 0
    for i in range(m):
        for j in range(n):
            if data[i][j] == 1:
                bfs(i, j)
                count += 1
    
    print(count)