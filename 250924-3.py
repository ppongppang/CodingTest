from itertools import permutations
import math

def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    return True



def solution(numbers):
    answer = 0
    numbers = list(map(str, numbers))
    nums = []
    
    for i in range(1, len(numbers)+1) :
        nums += list(permutations(numbers, i))
    new_numbers = set(int(("").join(p)) for p in nums)
    
    for i in new_numbers :
        if is_prime(i) :
            answer+=1
    
    return answer