import sys
sys.stdin = open("250811-2.txt")

t = int(input())

for _ in range(t):
    n = int(input())

    dp = [0] * (n+1)

    for i in range(1, n+1) :
        if i == 1 :
            dp[i] = 1
        elif i == 2 :
            dp[i] = 2
        elif i == 3 :
            dp[i] = 4
        else :
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

    print(dp[n])