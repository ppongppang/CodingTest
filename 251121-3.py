import sys
sys.stdin = open("999999.txt")
input = sys.stdin.readline

def increase(num) :
    num_str = str(num)

    for i in range(len(num_str) - 1) :
        if num_str[i] > num_str[i+1] :
            return False
    
    return True

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    num_list = list(map(int, input().split()))

    num_list.sort()

    max_num = -1
    for i in range(n) :
        for j in range(i+1, n) :
            x = num_list[i] * num_list[j]
            if increase(x) :
                if x > max_num :
                    max_num = x
            
    if max_num == -1 :
        print(f"#{test_case} {-1}")
    
    else : print(f"#{test_case} {max_num}")
    


