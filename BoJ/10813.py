N, M = map(int, input().split())

# n번 바구니에 n번 공이 든 바구니 N개 생성
basket = list(range(1, N + 1))

for _ in range(M):
  i, j = map(int, input().split())
  # i번 바구니와 j번 바구니의 공 교환
  temp = basket[i - 1]
  basket[i - 1] = basket[j - 1]
  basket[j - 1] = temp

print(*basket)
