import sys
sys.stdin = open("999999.txt")
input = sys.stdin.readline

def find(x) :
    if parent[x] != x :
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b) :
    root_a = find(a)
    root_b = find(b)

    if root_a != root_b :
        if rank[root_a] < rank[root_b]:
            parent[root_a] = root_b
        elif rank[root_a] > rank[root_b]:
            parent[root_b] = root_a
        else:
            parent[root_b] = root_a
            rank[root_a] += 1

T = int(input())
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    
    parent = list(range(n+1))
    rank = [0] * (n+1)

    result = []

    for i in range(m) :
        op, a, b = map(int, input().split())

        if op == 0 :
            union(a,b)
        else :
            if find(a) == find(b):
                result.append("1")
            else:
                result.append("0")
    print(f"#{test_case} {''.join(result)}")