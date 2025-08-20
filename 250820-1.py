import sys
sys.stdin = open("250820-1.txt")
input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0

for mask in range(1, 1 << n): 
    subset_sum = 0
    
    for i in range(n):
        if mask & (1 << i): 
            subset_sum += arr[i]
    
    if subset_sum == s:
        cnt += 1

print(cnt)