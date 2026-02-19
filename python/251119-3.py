import sys
sys.stdin = open("251119-3.txt")
input = sys.stdin.readline

T = int(input())

for tc in range(T):
    n, k = map(int, input().split())
    bag_list = [list(map(int, input().split())) for _ in range(n)]

    dp = [0] * (k+1)

    for volume, value in bag_list :
        for i in range(k, volume - 1, -1) :
            dp[i] = max(dp[i], dp[i - volume] + value)

    print(f"#{tc+1} {dp[k]}")