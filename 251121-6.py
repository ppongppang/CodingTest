import sys
sys.stdin = open("999999.txt")
input = sys.stdin.readline

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    
    diff = [0] * 5002

    for i in range(n) :
        a, b = map(int, input().split())

        diff[a] += 1 
        diff[b+1] -= 1

    stop = [0] * 5001

    for i in range(1, 5001) :
        stop[i] = stop[i-1] + diff[i]

    p = int(input())
    result = []

    for i in range(p) :
        c = int(input())
        result.append(str(stop[c]))
    
    print(f"#{test_case} {' ' .join(result)}")