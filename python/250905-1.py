import sys
sys.stdin = open("250905-1.txt")
input = sys.stdin.readline

n = int(input())
num = []

for _ in range(n):
    a = int(input())
    num.append(a)

num.sort()

two_sum = []
for i in range(n):
    for j in range(n):
        two_sum.append(num[i] + num[j])

two_sum.sort()

def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return True
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return False

result = 0

for i in range(n-1, -1, -1):
    for j in range(n):
        target = num[i] - num[j]
        if binary_search(two_sum, target):
            result = num[i]
            break
    if result > 0:
        break

print(result)