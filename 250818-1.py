import sys
sys.stdin = open("250818-1.txt")
input = sys.stdin.readline

s = input()
alp = [0 for _ in range(26)]

for i in s :
   alp[ord(i) - ord('a')] += 1

print(' '.join(map(str, alp)))