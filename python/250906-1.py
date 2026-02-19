import sys
import math
sys.stdin = open("250906-1.txt")
input = sys.stdin.readline

n, s = map(int, input().split())

nums = list(map(int, input().split()))

mins = math.inf

total = nums[0]
end = 0

for i in range(n) :
    while (end < n and total < s) :
        end += 1
        if end != n :
            total += nums[end]
    if end == n :
        break
    mins = min(mins, end - i + 1)
    total -= nums[i]

if mins == math.inf :
    print(0)
else : print(mins)