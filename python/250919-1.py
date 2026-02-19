def solution(participant, completion):
    hash_dict = {}
    
    for name in participant:
        hash_dict[name] = hash_dict.get(name, 0) + 1
    
    for name in completion:
        hash_dict[name] -= 1
    
    for name in hash_dict:
        if hash_dict[name] == 1:
            return name