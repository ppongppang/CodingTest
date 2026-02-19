import sys
sys.stdin = open("250912-1.txt")
input = sys.stdin.readline

from collections import Counter

T = int(input())
for _ in range(T):
    n = int(input())
    
    if n == 0:
        print(0)
        continue
    
    numbers = list(map(int, input().split()))
    counter = Counter(numbers)
    
    count = 0
    
    # 가능한 안녕한 정수들 (제한된 범위)
    targets = [202021]  # 6자리
    
    # 7자리는 없음
    
    # 8자리: 20202021
    targets.append(20202021)
    
    # 9자리: 202002021 ~ 202092021
    for i in range(10):
        targets.append(int(f"20200{i}2021"))
    
    # 10자리: 202010021 ~ 202099021  
    for i in range(10, 100):
        targets.append(int(f"2020{i}2021"))
    
    # 각 target에 대해 가능한 쌍 찾기
    for target in targets:
        for num, freq in counter.items():
            complement = target - num
            if complement in counter:
                if num < complement:
                    count += freq * counter[complement]
                elif num == complement:
                    count += freq * (freq - 1) // 2
    
    print(count)