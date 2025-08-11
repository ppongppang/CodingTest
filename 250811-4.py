import sys
sys.stdin = open("250811-4.txt")

n = int(input())

m = int(input())

s = input()

cur = 0
count= 0
result = 0

while(cur < (m-1)) :
    if s[cur:cur+3] == 'IOI' :
        count += 1
        cur += 2
        if count == n :
            result += 1
            count -= 1
    
    else : 
        count= 0
        cur += 1
print(result)