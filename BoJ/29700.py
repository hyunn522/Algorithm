N, M, K = map(int, input().split())
# 가능한 경우의 수
result = 0

for _ in range(N):
  row = input()

  # 연속된 빈자리 개수
  count = 0
  for i in range(len(row)):
    if row[i] == '1':  # 해당 자리가 이미 찬 자리일 때
      count = 0
    elif count < K - 1:  # 해당 자리가 빈 자리이면서 아직 K명만큼의 자리가 차지 않았을 때
      count += 1
    elif count == K - 1:  # 해당 자리가 빈 자리이면서 K명의 자리가 찼을 때
      result += 1
    elif count > K - 1:  # 해당 자리가 빈 자리이면서 K개 이상의 자리가 비었을 때
      count = 1

print(result)
