import sys
sys.stdin = open("250816-2.txt")
input = sys.stdin.readline

n = int(input())

stairs = []
for _ in range(n) :
    stair = int(input())
    stairs.append(stair)

dp = [0] *n

if len(stairs) <= 2 :
    print(sum(stairs))
else : 
    dp[0] = stairs[0]
    dp[1] = stairs[0] + stairs[1]
    for i in range(2, n) :
        dp[i] = max(dp[i-3]+stairs[i-1]+stairs[i], dp[i-2]+stairs[i])
    print(dp[-1])

