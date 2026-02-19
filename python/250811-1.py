import sys
sys.stdin = open("250811-1.txt")

n, k = map(int, input().split())

coins = []
answer = 0

for _ in range(n) :
    coins.append(int(input()))
coins.sort(reverse=True)

for coin in coins :
    if k >= coin :
        answer += k // coin
        k %= coin
        if k <= 0 :
            break

print(answer)