import sys
sys.stdin = open("250812-3.txt")

n, m = map(int, input().split())

tree = list(map(int, input().split()))
tree.sort()

start, end = 1, max(tree)

while start <= end :
    cut = 0
    mid = (start + end) // 2

    for i in tree :
        if i >= mid :
            cut += i - mid

    if cut >= m :
        start = mid + 1
    else :
        end = mid - 1

print(end)