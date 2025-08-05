from collections import deque
import sys
sys.stdin = open("250805-3.txt")

n, k = map(int, input().split())

max_num = 100000

visited = [0] * (max_num +1)

def bfs() :
    queue = deque()

    queue.append(n)

    while queue :
        x = queue.popleft()

        if x == k :
            print(visited[k])
            break
        for j in (x-1, x+1, x * 2) :
            if 0 <= j <= max_num and not visited[j] :
                visited[j] = visited[x] +1
                queue.append(j)
bfs()
                  