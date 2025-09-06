import sys
import heapq
sys.stdin = open("250906-3.txt")
input = sys.stdin.readline

T = int(input())

def solve() :
    k = int(input())
    mins = []
    maxs = []

    visited = [False for _ in range(k)]

    for i in range(k) :
        op, num = input().split()
        num = int(num)
        if op == 'I' :
            heapq.heappush(mins, (num, i))
            heapq.heappush(maxs, (-num, i))
        elif num == -1 :
            if mins :
                visited[heapq.heappop(mins)[1]] = True
        elif num == 1 :
            if maxs :
                visited[heapq.heappop(maxs)[1]] = True

        while mins and visited[mins[0][1]] :
            heapq.heappop(mins)
        while maxs and visited[maxs[0][1]] :
            heapq.heappop(maxs)

    if mins:
        print(-maxs[0][0], mins[0][0])
    else:  
        print('EMPTY')

for _ in range(T) :
    solve()