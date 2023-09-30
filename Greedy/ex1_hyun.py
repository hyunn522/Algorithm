n = 25
k = 5
count = 0

while n != 1:
  if n % k == 0:
    n = n // k
    count += 1
  else:
    n = n - 1
    count += 1

print(count)
