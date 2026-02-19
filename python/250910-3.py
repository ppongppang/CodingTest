import sys
from collections import deque
sys.stdin = open("250910-3.txt")
input = sys.stdin.readline

n = int(input())

queue = deque()

for _ in range(n):
    op = list(map(int, input().split()))

    if op[0] == 1 :
        queue.appendleft(op[1])
    elif op[0] == 2 :
        queue.append(op[1])
    elif op[0] == 3 :
        if queue :
            print(queue.popleft())
        else : 
            print(-1)
    elif op[0] == 4 :
        if queue :
            print(queue.pop())
        else :
            print(-1)
    elif op[0] == 5 :
        print(len(queue))
    elif op[0] == 6 : 
        if queue :
            print(0)
        else :
            print(1)
    elif (op[0] == 7):
        if (queue):
            print(queue[0])
        else:
            print(-1)
    elif (op[0] == 8):
        if (queue):
            print(queue[-1])
        else:
            print(-1)
