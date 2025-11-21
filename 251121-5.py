import sys
sys.stdin = open("999999.txt")
input = sys.stdin.readline

T = int(input())
for test_case in range(1, T + 1):
    k, n, m = map(int, input().split())

    stop = list(map(int, input().split()))
    stop.sort()

    cur = 0
    cnt = 0

    while cur < n :
        next_stop = -1
        for i in range(cur + k , cur, -1) :
            if i >= n :
                next_stop = n
                break
            if i in stop :
                next_stop = i
                break
        
        if next_stop == -1 :
            cnt = 0
            break

        if next_stop < n :
            cnt += 1
            
        cur = next_stop

    print(f"#{test_case} {cnt}")


