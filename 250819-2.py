import sys
sys.stdin = open("250819-2.txt")
input = sys.stdin.readline

n, r, c = map(int, input().split())

def z(n, r, c) :

    if n == 0:
        return 0
    
    half = 2 ** (n-1)
    if (r < half and c < half) :
        return z(n-1, r, c)
    elif (r < half and c >= half) :
        return half*half + z(n-1, r, c-half)
    elif (r >= half and c < half) :
        return (half*half) * 2 + z(n-1, r-half, c)
    return (half*half)*3 + z(n-1, r-half, c-half)
    

print(z(n,r,c))