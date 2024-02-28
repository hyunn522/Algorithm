# 1부터 30까지 리스트 생성
num = list(range(1, 31))

# 입력받은 숫자를 리스트에서 제거
for _ in range(28):
  n = int(input())
  num.remove(n)

print(min(num))
print(max(num))
