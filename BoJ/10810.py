N, M = map(int, input().split())

# N개의 빈 바구니 생성
basket = [0 for _ in range(N)]

for _ in range(M):
  i, j, k = map(int, input().split())
  for n in range(i - 1, j):
    basket[n] = k

# 리스트 내용을 대괄호 없이 출력
print(*basket)
