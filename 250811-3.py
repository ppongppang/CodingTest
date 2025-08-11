import heapq
import sys
sys.stdin = open("250811-3.txt")

n = int(sys.stdin.readline())

heap = []

for _ in range(n):
    x = int(sys.stdin.readline())

    if x > 0 :
        heapq.heappush(heap, x)
    
    elif x == 0 :
        if heap :
           print(heapq.heappop(heap))
        else :
            print(0)