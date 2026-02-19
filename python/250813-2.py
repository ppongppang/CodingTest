import sys
sys.stdin = open("250813-2.txt")

n,m = map(int, input().split())

graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
cnt = 0

for _ in range(m) :
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(graph, v, visited) :
    visited[v] = 1
    for i in graph[v] :
        if visited[i] == 0 :
            dfs(graph, i, visited)

for i in range(1, n+1):
    if visited[i] == 0:
        dfs(graph, i, visited)
        cnt += 1

print(cnt)