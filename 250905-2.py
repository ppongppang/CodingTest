import sys
input = sys.stdin.readline


def make_calbe(cables, length, n) :
    if length == 0 :
        return False
    
    count = 0
    for cable in cables :
        count += cable // length
        if count >= n :
            return True
    
    return count >= n


k, n = map(int, input().split())

cables = []
for _ in range(k):
    cables.append(int(input()))

left = 1
right = max(cables)

answer = 0


while left <= right :
    mid = (left + right) // 2

    if make_calbe(cables, mid, n) :
        answer = mid
        left = mid + 1
    else : 
        right = mid - 1
    

print(answer)