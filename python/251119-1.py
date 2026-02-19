import sys
sys.stdin = open("251118-2.txt")
input = sys.stdin.readline

def dfs(i, j, k, cnt) :
    global result
    if cnt == 5 :
        result = "YES"
        return
    
    nx = i + direction[k][0]
    ny = j + direction[k][1]

    if 0 <= nx < n and 0 <= ny < n and omok[nx][ny] == "o" :
        dfs(nx, ny, k, cnt + 1)



T = int(input())
for test_case in range(1, T + 1) : 
    n = int(input())

    omok = [list(input().rstrip()) for _ in range(n)]
    direction = [(-1,-1), (-1, 0), (-1,1), (0, -1), (0, 1), (1,-1), (1, 0), (1,1)]
    result = "NO"

    for i in range(n):
        for j in range(n):
            if omok[i][j] == 'o' :
                for k in range(8) :
                    dfs(i,j,k, 1)
                        

    print(f"#{test_case} {result}")