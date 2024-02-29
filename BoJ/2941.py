word = input()
alphabet = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
sum = 0

for i in alphabet:
  # 해당 크로아티아 알파벳 제거
  word = word.replace(i, '0')

print(len(word))
