import sys
sys.stdin = open("250906-2.txt")
input = sys.stdin.readline

n = int(input())
company = set()

for _ in range(n):
    name, action = input().split()
    if action == "enter" :
        company.add(name)

    else :
        company.remove(name)

result = sorted(company, reverse=True)

for i in result :
    print(i)