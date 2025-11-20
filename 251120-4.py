import sys
sys.stdin = open("251120-4.txt")
input = sys.stdin.readline

T = 10
for test_case in range(1, T + 1):
    t = int(input())
    game = [list(map(int, input().split())) for _ in range(100)]

    end = 0
    for i in range(100) :
        if game[99][i] == 2 :
            end = i
            break
    
    x, y = end, 99


    while y > 0 :
        if x > 0 and game[y][x-1] == 1 :
            while x > 0 and game[y][x - 1] == 1:
                x -= 1

        elif x <99 and game[y][x+1] == 1 :
            while x < 99 and game[y][x + 1] == 1:
                x += 1

        y -= 1

    print(f"#{test_case} {x}")
