def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    
    for i in reserve[:]:
        if i in lost:
            reserve.remove(i)
            lost.remove(i) 
    
    for i in lost[:]:

        if i-1 in reserve:
            reserve.remove(i-1)
            lost.remove(i)

        elif i+1 in reserve:
            reserve.remove(i+1)
            lost.remove(i)
    
    answer = n - len(lost)
    return answer