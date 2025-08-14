from collections import deque
import sys
sys.stdin = open("250814-3.txt")
input = sys.stdin.readline

n, m = map(int, input().split())
 
board = [0] * 101
visited = [False] * 101
 
ladder = dict()
for _ in range(n):
    i,j = map(int,input().split())
    ladder[i] = j
 
snake = dict()
for _ in range(m):
    i,j = map(int,input().split())
    snake[i] = j

def bfs(start):
    q = deque()
    q.append(start)
 
    visited[start] = True
 
    while q:
        cur = q.popleft()
 
        for i in range(1, 7):
            next = cur + i
 
            if 0 < next <= 100 and not visited[next]:
                if next in ladder:
                    next = ladder[next]
                
                if next in snake:
                    next = snake[next]
                
                if not visited[next]:
                    q.append(next)
                    visited[next] = True
                    board[next] = board[cur] + 1
 
bfs(1) 
print(board[100])