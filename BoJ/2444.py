N = int(input())

for i in range(1, 2 * N):
  if i <= N:
    blank_count = N - i
    count = 2 * i - 1
    print(' ' * blank_count + '*' * count)
  elif i > N:
    blank_count = i - N
    count = 2 * (2 * N - i) - 1
    print(' ' * blank_count + '*' * count)
