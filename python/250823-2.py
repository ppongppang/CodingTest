import sys
sys.stdin = open("250823-2.txt")
input = sys.stdin.readline

n = int(input())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort(reverse=True)

result = []

for i in range(n) :
    result.append(a[i] * b[i])

print(sum(result))