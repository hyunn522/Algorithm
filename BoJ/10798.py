words = []
max_length = 0
result = ''

for _ in range(5):
  word_row = list(map(str, input()))
  words.append(word_row)
  if len(word_row) > max_length:
    max_length = len(word_row)

# 행렬 세로로 출력
for i in range(max_length):
  for j in range(5):
    if i > len(words[j]) - 1:
      result += ''
    else:
      result += words[j][i]

print(result)
