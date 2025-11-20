import sys
from collections import deque
sys.stdin = open("251120-5.txt")
input = sys.stdin.readline

def bfs() :

    queue = deque([[1,1]])
    visited = [[False] * 16 for _ in range(16)]
    visited[1][1] = True

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]


    while queue :
        x, y = queue.popleft()

        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < 16 and 0 <= ny < 16 and not visited[nx][ny]:
                if maze[nx][ny] == 3:
                    return 1
                if maze[nx][ny] == 0:
                    visited[nx][ny] = True
                    queue.append([nx, ny])
            
    return 0

T = 10
for test_case in range(1, T + 1):
    a = int(input())

    maze = [list(map(int, input().strip())) for _ in range(16)]

    result = bfs()

    print(f"#{test_case} {result}")