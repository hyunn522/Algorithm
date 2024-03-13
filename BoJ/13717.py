# test case 개수
N = int(input())
# 이름과 진화한 포켓몬 수 저장 위해 dictionary 사용
N_list = {}
max_name = ''

for i in range(N):
  name = input()
  need, have = map(int, input().split())
  new = 0
  # 첫 번째 반복일 때에만 max_name 초기화
  if (i == 0):
    max_name = name

  # 2개씩의 보상 추가
  while (have >= need):
    have -= need
    have += 2
    new += 1

  N_list[name] = new

  # max_name 갱신
  if (new > N_list[max_name]):
    max_name = name

num_list = list(N_list.values())

print(sum(num_list))
print(max_name)
