N = int(input())
result = 0

# 초기 전체 범위 (색종이가 없는 부분은 0, 있는 부분은 1)
array = [[0] * 100 for _ in range(100)]

for _ in range(N):
  new_x, new_y = map(int, input().split())

  # 색종이가 있는 위치를 1로 표시
  for i in range(new_x, new_x + 10):
    for j in range(new_y, new_y + 10):
      array[i][j] = 1

# 전체 범위 중 색종이가 있는 부분의 넓이
for i in range(100):
  for j in range(100):
    if array[i][j] == 1:
      result += 1

print(result)
