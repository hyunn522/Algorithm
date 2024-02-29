black = list(map(int, input().split()))

# black + white
total = [1, 1, 2, 2, 2, 8]
white = [0, 0, 0, 0, 0, 0]

for i in range(6):
  white[i] = total[i] - black[i]

print(*white)
