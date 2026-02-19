import sys
from collections import deque
sys.stdin = open("250911-1.txt")
input = sys.stdin.readline

dx = [-1,1,0,0]
dy = [0,0,-1,1]

ppu = [list(input().rstrip()) for _ in range(12)]
combo = 0

def bfs(x, y) :
    queue = deque()
    queue.append((x,y))

    visited[x][y] = True

    same = [(x,y)]

    while queue :
        x,y = queue.popleft()

        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < 12 and 0 <= ny < 6 and ppu[x][y] == ppu[nx][ny] and not visited[nx][ny] :
                queue.append((nx, ny))
                visited[nx][ny] = True
                same.append((nx, ny))
    return same

def clear (same) :
    for x, y in same :
        ppu[x][y] = "."

def down() :
    for y in range(6) :
        for x in range(10, -1, -1):
            for z in range(11,x,-1) :
                if ppu[x][y] != "." and ppu[z][y] == "." :
                    ppu[z][y] = ppu[x][y]
                    ppu[x][y] = "."



while True :
    boom = False
    visited = [[False] * 6 for _ in range(12)]

    for i in range(12) :
        for j in range(6) :
            if ppu[i][j] != "." and not visited[i][j] :
                same = bfs(i,j)

                if len(same) >= 4 :
                    boom =True
                    clear(same)
    
    if boom :
        down()
        combo += 1
    else :
        break

print(combo)