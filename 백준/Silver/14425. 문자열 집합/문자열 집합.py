N, M = map(int, input().split())
N_list = []
M_list = []
result = 0

for _ in range(N):
  str = input()
  N_list.append(str)

for _ in range(M):
  str = input()
  if str in N_list:
    result += 1
  else:
    continue

print(result)
