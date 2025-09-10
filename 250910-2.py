import sys
sys.stdin = open("250910-2.txt")
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
dp = [[0 for _ in range(21)] for _ in range(n)]

for i in range(n): 
    if i==0 :
        dp[i][nums[0]] = 1
    else :
        for j in range(21) :
            if dp[i-1][j] >0 :
                if 0 <= j + nums[i] <= 20 :
                    dp[i][j+nums[i]] += dp[i-1][j]
                if 0 <= j - nums[i] <= 20 :
                    dp[i][j-nums[i]] += dp[i-1][j]

print(dp[n-2][nums[n-1]])