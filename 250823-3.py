import sys
sys.stdin = open("250823-3.txt")
input = sys.stdin.readline

n,m,l = map(int, input().split())

locations = [0] + list(map(int, input().split())) + [l]

locations.sort()

start = 1
end = l - 1

while start <= end :
    mid = (start+end) // 2
    cnt = 0

    for i in range(len(locations)-1) :
        if locations[i+1] - locations[i] > mid :
            cnt += (locations[i+1] - locations[i] - 1) // mid

    if cnt <= m :
        end = mid - 1
    else : 
        start = mid + 1

print(start)