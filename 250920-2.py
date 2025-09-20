def solution(sizes):
    answer = max(max(i) for i in sizes) * max(min(i) for i in sizes)
    
    
    return answer