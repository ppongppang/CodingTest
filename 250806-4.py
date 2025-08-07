import sys
sys.stdin = open("250806-4.txt")

n = int(input())

weight = list(map(int, input().split()))

weight.sort()

start = 1

for i in weight :
    if start < i :
        break

    start += i


print(start)
