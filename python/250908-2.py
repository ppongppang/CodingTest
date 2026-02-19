import sys
sys.stdin = open("250908-2.txt")
input = sys.stdin.readline

n = int(input())

a, b, c = map(int, input().split())
max_dp = [a, b, c]
min_dp = [a, b, c]

for _ in range(n-1): 
    a, b, c = map(int, input().split())
    
    new_max = [0] * 3
    new_min = [0] * 3
    
    new_max[0] = a + max(max_dp[0], max_dp[1])
    new_min[0] = a + min(min_dp[0], min_dp[1])
    
    new_max[1] = b + max(max_dp[0], max_dp[1], max_dp[2])
    new_min[1] = b + min(min_dp[0], min_dp[1], min_dp[2])
    
    new_max[2] = c + max(max_dp[1], max_dp[2])
    new_min[2] = c + min(min_dp[1], min_dp[2])
    
    max_dp = new_max
    min_dp = new_min

print(max(max_dp), min(min_dp))