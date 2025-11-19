import sys
sys.stdin = open("251119-2.txt")
input = sys.stdin.readline

def check_num(n) :
    x, y = 1, 1
    if n == 1 :
        return x, y
    
    for i in range(2,n+1) :
        nx = x + 1
        ny = y - 1

        if ny == 0 :
            nx = 1
            ny = x + 1

        x = nx
        y = ny
    
    return x, y

def find_position(x, y) :
    hang = x + y - 1

    before = hang * (hang-1) // 2

    now = x

    return before + now

T = int(input())
for test_case in range(1, T + 1):
    p, q = map(int, input().split())

    x1, y1 = check_num(p)
    x2, y2 = check_num(q)

    x3, y3 = x1+x2, y1+y2

    print(f'#{test_case} {find_position(x3, y3)}')