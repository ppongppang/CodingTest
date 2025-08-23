import sys
sys.stdin = open("250823-1.txt")
input = sys.stdin.readline

n = int(input())

rope = []

for _ in range(n) :
    rope.append(int(input()))

rope.sort(reverse=True)
result = []

for j in range(n) :
    result.append(rope[j] * (j+1))

print(max(result))