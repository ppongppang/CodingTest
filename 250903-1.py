import sys
import math
sys.stdin = open("250903-1.txt")
input = sys.stdin.readline

m, n = map(int, input().split())

MAX = 1000000

prime = [True for _ in range(MAX+1)]

prime[1] = False

for i in range(2, int(math.sqrt(MAX)) + 1) :
    if prime[i] == True :
        j = 2
        while i * j <= MAX :
            prime[i*j] = False
            j += 1

for i in range(m, n+1) :
    if prime[i] :
        print(i)