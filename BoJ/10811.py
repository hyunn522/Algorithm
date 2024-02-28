N, M = map(int, input().split())

# N개의 바구니
basket = list(range(1, N + 1))

for _ in range(M):
  i, j = map(int, input().split())

  # 역순으로 만들고자 하는 범위의 슬라이스 및 reverse
  sliced_basket = basket[i - 1:j]
  sliced_basket.reverse()

  # 원본 바구니의 i-1번째 인덱스에 차례로 삽입 -> 최종 결과 역순으로 보임
  basket[i - 1:j] = sliced_basket

print(*basket)
