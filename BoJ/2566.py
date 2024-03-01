my_list = []
max = 0
max_row = 0
max_col = 0

# 행렬 최댓값 및 위치
for i in range(9):
  row = list(map(int, input().split()))
  my_list.append(row)
  for j in range(9):
    num = my_list[i][j]
    if num > max:
      max = num
      max_row = i
      max_col = j

print(max)
print(max_row + 1, max_col + 1)
