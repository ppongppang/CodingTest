def solution(phone_book):
    
    hashmap = {}
    
    for nums in phone_book :
        hashmap[nums] = 1
    
    for nums in phone_book :
        pre = ""
        for num in nums :
            pre += num
            
            if pre in hashmap and pre != nums :
                return False
    
    return True