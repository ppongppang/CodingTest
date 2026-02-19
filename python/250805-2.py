n, m = map(int, input().split())

not_heard = set()
for _ in range(n):
    not_heard.add(input().strip())

not_seen = set()
for _ in range(m):
    not_seen.add(input().strip())

not_heard_seen = not_heard & not_seen

result = sorted(not_heard_seen)
print(len(result))
for name in result:
    print(name)