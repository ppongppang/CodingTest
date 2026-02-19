import sys
from collections import deque
import heapq
sys.stdin = open("251120-1.txt")
input = sys.stdin.readline


def dij(n, board) :

    dist = [[float('inf')] * n for _ in range(n)]
    dist[0][0] = 0

    pq = [(0, 0, 0)]

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while pq:
        cost, x, y = heapq.heappop(pq)

        if cost > dist[x][y] :
            continue

        if x == n-1 and y == n-1 :
            return cost
        
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n :
                new_cost = cost + board[nx][ny]

                if new_cost < dist[nx][ny] :
                    dist[nx][ny] = new_cost
                    heapq.heappush(pq, (new_cost, nx, ny))

    return dist[n-1][n-1]






T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    board = [list(map(int, input().strip())) for _ in range(n)]

    result = dij(n, board)

    print(f"#{test_case} {result}")
