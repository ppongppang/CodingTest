import sys
sys.stdin = open("251120-2.txt")
input = sys.stdin.readline

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    score = list(map(int, input().split()))
    result = {0}
    
    for l in score :
        final = set()
        for s in result :
            final.add(s + l)
            final.add(s)
        result = final
    print(f"#{test_case} {len(final)}")