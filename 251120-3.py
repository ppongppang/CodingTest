import sys
sys.stdin = open("251120-3.txt")
input = sys.stdin.readline

def dfs(start, a) :
    global result
    x, y = start

    if len(a) == 7 :
        result.append(a)
        return
    for dx, dy in ((-1,0), (1,0), (0, -1), (0, 1)) :
        nx = x + dx
        ny = y + dy

        if 0 <= nx < 4 and 0 <= ny < 4 :
            dfs((nx, ny), a + [board[nx][ny]])


T = int(input())
for test_case in range(1, T + 1):
    board = [list(map(int, input().split())) for _ in range(4)]
    result = []

    for i in range(4) :
        for j in range(4) :
            dfs((i,j), [board[i][j]])

    result = list(set(map(tuple, result)))
    print(f"#{test_case} {len(result)}")