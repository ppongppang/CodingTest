def solution(numbers, target):
    answer = 0
    stack = [(0,0)]
    
    while stack :
        idx, num = stack.pop()
        if idx == len(numbers) :
            if num == target :
                answer += 1
            continue
        
        stack.append((idx + 1, num + numbers[idx]))
        stack.append((idx + 1, num - numbers[idx]))
    return answer