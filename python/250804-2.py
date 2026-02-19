while True:
    line = input().strip()
    if line == '0':  # 종료 조건
        break
        
    nums = list(map(int, line))
        
    if nums == nums[::-1]:
        print("yes")
    else:
        print("no")