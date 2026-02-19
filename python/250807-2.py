import sys
sys.stdin = open("250807-2.txt")

n = int(input())

paper = [list(map(int, input().split())) for _ in range(n)]
white =0
blue =0

def count_paper(x, y, n) :
    global white, blue 
    count = 0

    for i in range(x, x+n):
        for j in range(y, y+n):
            if paper[i][j] :
                count += 1

    if not count :
        white +=1 
    elif count == n ** 2 :
        blue += 1
    else :
        count_paper(x, y, n//2)
        count_paper(x + n//2 , y, n//2)
        count_paper(x, y+ n//2, n//2)
        count_paper(x + n//2, y +n//2, n//2)
    return

count_paper(0,0,n)
print(white)
print(blue)

