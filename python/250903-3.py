import sys
import math
sys.stdin = open("250903-3.txt")
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    m, n, x, y = map(int, input().split())
    
    lcm = math.lcm(m, n)
    found = False
    
    year = x
    while year <= lcm:
        remainder = year % n
        if remainder == 0:
            remainder = n
            
        if remainder == y:
            print(year)
            found = True
            break
            
        year += m
    
    if not found:
        print(-1)