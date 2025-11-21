import sys
sys.stdin = open("251121-1.txt")
input = sys.stdin.readline

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())

    room = [0] * 201

    for i in range(n) :
        cur, go = map(int, input().split())

        if cur % 2 == 0 :
            cur -= 1
        if go % 2 == 0 :
            go -= 1

        start = min(cur, go) // 2
        end = max(cur, go) // 2

        for i in range(start, end+1):
            room[i] += 1
        
    print(f"#{test_case} {max(room)}")    