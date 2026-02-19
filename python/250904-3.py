import sys
sys.stdin = open("250904-3.txt")
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))

a.sort()

def search(target) :
    start = 0
    end = n-1   
    while start <= end :
        mid = (start+end) // 2
        if a[mid] <  target :
            start = mid+1
        elif a[mid] > target :
            end = mid - 1
        else :
            return 1
    return 0

for i in range(m) :
    print(search(b[i]))