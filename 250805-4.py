import sys
sys.stdin = open("250805-4.txt")

n = int(sys.stdin.readline())

coordinate = list(map(int, sys.stdin.readline().split()))

arr = sorted(set(coordinate))

dic = {arr[i]:i for i in range(len(arr))}

for i in coordinate :
    print(dic[i], end=" ")