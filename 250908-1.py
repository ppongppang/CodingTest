import sys
sys.stdin = open("250908-1.txt")
input = sys.stdin.readline

n, p = map(int, input().split())

melody = []

for _ in range(n) :
    melody.append(list(map(int, input().split())))

cnt = 0

stack = [[] for _ in range(7)]

for i in range(n) :
    string, pret = melody[i]
    if not stack[string] or stack[string][-1] < pret :
        stack[string].append(pret)
        cnt += 1
    else :
        while stack[string] and stack[string][-1] > pret:
                stack[string].pop()
                cnt += 1
        if not stack[string] or stack[string][-1] < pret :
            stack[string].append(pret)
            cnt += 1

print(cnt)