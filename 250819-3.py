import sys
sys.stdin = open("250819-3.txt")
input = sys.stdin.readline

n, m = map(int, input().split())

num = [0] * 10
issued = [False] * 11

def func(k) :
    if k == m :
        for i in range(m) :
            print(num[i], end=' ')
        print()
        return
    
    for i in range(1, n+1) :
        if not issued[i] :
            num[k] = i
            issued[i] = True
            func(k+1)
            issued[i] = False

func(0)