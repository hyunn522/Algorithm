#N 입력받기
n = int(input())

count = 0

for i in range(n + 1): #hour
  for j in range(60): #minute
    for k in range(60): #second
      #매 시각 안에 '3'이 포함되어 있다면 count 증가
      if '3' in str(i) + str(j) + str(k):
        count += 1

print(count)