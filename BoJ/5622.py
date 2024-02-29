S = input()
sum = 0
alphabets = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']

for s in S:
  for a in alphabets:
    if s in a:
      sum += alphabets.index(a) + 3

print(sum)
