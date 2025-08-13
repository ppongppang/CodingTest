from collections import deque
import sys
sys.stdin = open("250813-3.txt")

input = sys.stdin.readline

n = int(input().strip())
paint = [list(input().strip()) for _ in range(n)]

def bfs(board, sx, sy, visited):
    q = deque([(sx, sy)])
    visited[sx][sy] = 1
    color = board[sx][sy]
    while q:
        x, y = q.popleft()
        for dx, dy in ((-1,0),(1,0),(0,-1),(0,1)):
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and board[nx][ny] == color:
                visited[nx][ny] = 1
                q.append((nx, ny))

# 정상 시력
visited = [[0]*n for _ in range(n)]
cnt1 = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(paint, i, j, visited)
            cnt1 += 1

# 적록색약: G를 R로 변환
paint2 = [row[:] for row in paint]
for i in range(n):
    for j in range(n):
        if paint2[i][j] == 'G':
            paint2[i][j] = 'R'

visited = [[0]*n for _ in range(n)]
cnt2 = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(paint2, i, j, visited)
            cnt2 += 1

print(cnt1, cnt2)
