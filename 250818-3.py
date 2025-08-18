from collections import deque
import sys
sys.stdin = open("250818-3.txt")
input = sys.stdin.readline

n, m = map(int, input().split())

paper = [list(map(int, input().split())) for _ in range(n)]

visited = [[False] * m for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(start_x, start_y) :
    queue = deque([(start_x, start_y)])
    visited[start_x][start_y] = True
    size = 1

    while queue :
        x, y = queue.popleft()

        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m :
                if visited[nx][ny] == False and paper[nx][ny] == 1 :
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                    size += 1
    return size

picture = 0
max_size = 0

for i in range(n) :
    for j in range(m) :
        if paper[i][j] == 1 and not visited[i][j] :
            picture += 1
            current_size = bfs(i, j)
            max_size = max(max_size, current_size)

print(picture)
print(max_size)
