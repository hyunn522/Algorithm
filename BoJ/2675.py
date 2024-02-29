T = int(input())

for _ in range(T):
  R, S = input().split()
  for s in S:
    print(s * int(R), end='')
  print('')
