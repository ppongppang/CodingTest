from collections import deque
import sys
sys.stdin = open("250814-2.txt")
input = sys.stdin.readline

m, n, h =map(int, input().split())
tomato = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]
visited = [[[False] * m for _ in range(n)] for _ in range(h)]

dx = [-1, 1, 0 ,0 ,0 ,0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

queue = deque()
for i in range(h) :
    for j in range(n) :
        for k in range(m) :
            if tomato[i][j][k] == 1:
                queue.append((i,j,k))

def bfs() :
    while queue :
        z, y, x = queue.popleft()
        for i in range(6) :
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]

            if nx < 0 or nx >= m or ny < 0 or ny >= n or nz < 0 or nz >= h :
                continue
            
            if tomato[nz][ny][nx] == 0 and not visited[nz][ny][nx] :
                visited[nz][ny][nx] = True
                tomato[nz][ny][nx] = tomato[z][y][x] + 1
                queue.append((nz, ny, nx))

bfs()

answer = 0
for i in tomato :
    for j in i:
        for k in j:
            if k == 0 :
                print(-1)
                exit(0)

            answer = max(answer, max(j))

print(answer -1 )