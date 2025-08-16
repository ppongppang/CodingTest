import sys
sys.stdin = open("250816-1.txt")
input = sys.stdin.readline

n, m = map(int, input().split())

pokemon = []
pokemon_dict = {} 

for i in range(n):
    name = input().rstrip()
    pokemon.append(name)
    pokemon_dict[name] = i + 1  

for i in range(m):
    problem = input().rstrip()
    if problem.isdigit():
        print(pokemon[int(problem)-1])
    else:
        print(pokemon_dict[problem])  