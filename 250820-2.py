import sys
sys.stdin = open("250820-2.txt")
input = sys.stdin.readline

n, m = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

c = [0] * (n+m)
aidx = 0
bidx = 0

for i in range(n+m) :
    if bidx == m :
        c[i] = a[aidx]
        aidx += 1
    elif aidx == n :
        c[i] = b[bidx]
        bidx += 1
    elif a[aidx] <= b[bidx] :
        c[i] = a[aidx]
        aidx += 1
    else :
        c[i] = b[bidx]
        bidx += 1

print(*c)
