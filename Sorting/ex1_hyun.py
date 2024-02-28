n, k = map(int, input().split())
array_a = list(map(int, input().split()))
array_b = list(map(int, input().split()))

# a, b 정렬 후 a에서 젤 작은 거랑 b에서 젤 큰 거를 k번 바꿔치기 하면 됨
array_a.sort()
array_b.sort()

# print(array_a)
# print(array_b)

for i in range(k):
  if array_a[i] < array_b[-1 - i]:
  # a의 원소가 b의 원소보다 작을 때에만 교체
    array_b[-1 - i], array_a[i]= array_a[i], array_b[-1 - i]

print(sum(array_a))