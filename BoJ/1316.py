N = int(input())
sum = 0

for _ in range(N):
  word = input()
  temp = []
  for char in word:
    if char not in temp:  # 새로운 문자가 나온 경우
      temp.append(char)
    else:  # 이전에 등장한 문자가 나온 경우
      if temp[-1] != char:  # 이전 문자와 다른 경우
        sum += 1
        break

print(N - sum)
