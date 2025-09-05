import sys
import math
sys.stdin = open("250905-3.txt")
input = sys.stdin.readline

n, m = map(int, input().split())
a = []
mn = math.inf

for _ in range(n) :
    a.append(int(input()))

a.sort()

end = 0

for i in range(n) :
    while(end < n and a[end]- a[i] < m) :
        end += 1
    if (end == n ) :
        break
    mn = min(mn, a[end]-a[i])

print(mn)
