import sys
sys.stdin = open("251118-1.txt")
input = sys.stdin.readline

T = int(input())

dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]

for test_case in range(1, T + 1) :
    n, m = map(int, input().split())

    board = [[0] * (n+1) for _ in range(n+1)]
    board[n//2][n//2] = 2
    board[n//2+1][n//2] = 1
    board[n//2][n//2+1] = 1
    board[n//2+1][n//2+1] = 2

    for i in range(m) :
        x, y, color = map(int, input().split())
        board[y][x] = color

        for j in range(8) :
            flip = []
            nx, ny = x + dx[j] , y + dy[j]

            while 0 < nx <= n and 0 < ny <= n:
                if board[ny][nx] == 0 :
                    break
                elif board[ny][nx] == color :
                    for fx, fy in flip :
                        board[fy][fx] = color
                    break
                else :
                    flip.append((nx,ny))
                    nx += dx[j]
                    ny += dy[j]

    
    black = sum(row.count(1) for row in board)
    white = sum(row.count(2) for row in board)

    print(f"#{test_case} {black} {white}")