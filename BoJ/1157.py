word = input().lower()
word_list = list(set(word))
cnt = []

for w in word_list:
  count = word.count(w)
  cnt.append(count)

if cnt.count(max(cnt)) >= 2:
  print('?')
else:
  print(word_list[cnt.index(max(cnt))].upper())
