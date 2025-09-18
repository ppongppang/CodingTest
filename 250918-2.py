import sys
sys.stdin = open("250918-2.txt")
input = sys.stdin.readline

n = int(input())
L = [0] + list(map(int, input().split()))
J = [0] + list(map(int, input().split()))

dp = [[0] * 101 for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, 101):
        dp[i][j] = dp[i-1][j] 
        
        if j > L[i]: 
            dp[i][j] = max(dp[i][j], dp[i-1][j-L[i]] + J[i])

print(dp[n][100])