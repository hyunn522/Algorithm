N, B = map(str, input().split())
b = int(B)
result = 0

for i in range(len(N)):
  m = (ord(N[i]) - ord('A')) + 10 if 'A' <= N[i] <= 'Z' else int(N[i])
  result += m * (b**(len(N) - i - 1))

print(result)
