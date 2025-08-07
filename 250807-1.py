import sys
sys.stdin = open("250807-1.txt")

T = int(input())

for _ in range(T) :
    n = int(input())

    dp = [[]] * 41
    dp[0] = [1,0]
    dp[1] = [0,1]
    dp[2] = [1,1]

    for i in range(3, n+1) :
        dp[i] = [dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1]]

    print(dp[n][0], dp[n][1])
    