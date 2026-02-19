import sys
from collections import deque
sys.stdin = open("251121-2.txt")
input = sys.stdin.readline

def bfs(start) :

    queue = deque([start])
    cnt = 1


    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    
    while queue :
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n :
                if maps[nx][ny] == maps[x][y] + 1 :
                    queue.append((nx, ny))
                    cnt += 1
                else :
                    continue
    
    return cnt


T = int(input())
for test_case in range(1, T + 1):
    n = int(input())

    maps = [list(map(int, input().split())) for _ in range(n)]

    room = []

    for i in range(n) :
        for j in range(n) :
            start_num = maps[i][j]
            move_cnt = bfs((i,j))
            room.append((start_num, move_cnt))
    
    room.sort(key=lambda x : (-x[1], x[0]))

    print(f"#{test_case} {room[0][0]} {room[0][1]}")