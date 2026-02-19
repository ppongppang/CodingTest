import sys
sys.stdin = open("250918-1.txt")
input = sys.stdin.readline

n = int(input())
sick = input().strip() 
num = [int(input()) for _ in range(n)]

stack = []

for i in sick:
    if i.isalpha():
        stack.append(num[ord(i) - 65])
    else:
        b = stack.pop()  
        a = stack.pop()  

        if i == '+':
            result = a + b
        elif i == '-':
            result = a - b 
        elif i == '*':
            result = a * b
        elif i == '/':
            result = a / b 

        stack.append(result)

print('%.2f' % stack[-1])