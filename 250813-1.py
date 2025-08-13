import sys
sys.stdin = open("250813-1.txt")

input = sys.stdin.readline

n = int(input())
con = int(input())
cnt = 0 

graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for _ in range(con):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(n) :
    global cnt
    visited[n] = 1

    for i in graph[n] :
        if visited[i] == 0 :
            dfs(i)
            cnt +=1

dfs(1)

print(cnt)