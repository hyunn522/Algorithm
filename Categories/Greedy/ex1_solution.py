n, k = map(int, input().split())
result = 0

while True:
  #target = N이 K로 나누어 떨어지는 가장 가까운 수
  target = (n // k) * k
  #result = 1을 빼는 연산을 몇 번 수행하는지
  result += (n - target)
  n = target

  #N이 K보다 작을 때(=더 이상 나눌 수 없을 때) 반복문 탈출
  if n < k:
    break

  #K로 나누기
  result += 1
  n //= k

#마지막으로 남은 (K보다 작은) N에 대해 1씩 빼기
result += (n - 1)
print(result)
