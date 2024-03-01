N, M = map(int, input().split())
list_A = []
list_B = []
list_sum = []

for _ in range(N):
  row = list(map(int, input().split()))
  list_A.append(row)

for _ in range(N):
  row = list(map(int, input().split()))
  list_B.append(row)

# 행렬 덧셈
for row in range(N):
  for col in range(M):
    print(list_A[row][col] + list_B[row][col], end=' ')
  print()
