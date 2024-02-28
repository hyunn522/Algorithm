N = int(input())
N_list = list(map(int, input().split()))
sum = 0

# 최고 점수
M = sorted(N_list, reverse=True)[0]

for i in N_list:
  sum += i / M * 100

print(sum / N)
