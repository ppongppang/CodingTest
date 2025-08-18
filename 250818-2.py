import sys
sys.stdin = open("250818-2.txt")
input = sys.stdin.readline

word = input().strip()
left = list(word)
right = [] 

m = int(input())

for _ in range(m) :
    cmd = input().strip()

    if cmd == 'L' : 
        if left :
            right.append(left.pop())

    elif cmd == 'D' :
        if right :
            left.append(right.pop())

    elif cmd == 'B' :
        if left : 
            left.pop()

    else : 
        char = cmd[2]
        left.append(char)
    
result = left + right[::-1]

print(''.join(result))