import sys
from collections import deque
sys.stdin = open("999999.txt")
input = sys.stdin.readline

def solve(R, C, grid):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    
    visited = set()
    
    queue = deque([(0, 0, 0, 0)])
    
    while queue:
        x, y, d, mem = queue.popleft()
        
        state = (x, y, d, mem)
        if state in visited:
            continue
        visited.add(state)
        
        cmd = grid[x][y]
        
        if cmd == '@':
            return "YES"
        
        new_dirs = []
        if cmd == '<':
            new_dirs = [2]
        elif cmd == '>':
            new_dirs = [0]
        elif cmd == '^':
            new_dirs = [3]
        elif cmd == 'v':
            new_dirs = [1]
        elif cmd == '_':
            new_dirs = [0] if mem == 0 else [2]
        elif cmd == '|':
            new_dirs = [1] if mem == 0 else [3]
        elif cmd == '?':
            new_dirs = [0, 1, 2, 3]
        else:
            new_dirs = [d]
        
        new_mem = mem
        if cmd.isdigit():
            new_mem = int(cmd)
        elif cmd == '+':
            new_mem = (mem + 1) % 16
        elif cmd == '-':
            new_mem = (mem - 1) % 16
        
        for nd in new_dirs:
            nx = (x + dx[nd]) % R
            ny = (y + dy[nd]) % C
            queue.append((nx, ny, nd, new_mem))
    
    return "NO"


T = int(input())
for test_case in range(1, T + 1):
    R, C = map(int, input().split())
    grid = [input().rstrip() for _ in range(R)]
    
    result = solve(R, C, grid)
    print(f"#{test_case} {result}")

    