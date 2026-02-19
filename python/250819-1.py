import sys
sys.stdin = open("250819-1.txt")
input = sys.stdin.readline

a, b, c = map(int, input().split())

def mul_mod(a, b, c) :
    if b == 1 :
        return a%c
    else : 
        result = mul_mod(a, b//2, c)
        if b % 2 == 0 :
            return (result*result)%c
        else :
            return (result * result * a) % c
    
print(mul_mod(a,b,c))