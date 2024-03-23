result = list([0] * 10001)

for i in range(1, 10001):
  str_num = str(i)
  sum = i
  for s in str_num:
    sum += int(s)

  if (sum < 10001):
    result[sum] = 1

for i in range(len(result)):
  if result[i] == 0 and i != 0:
    print(i)
