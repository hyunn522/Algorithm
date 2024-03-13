# test case 개수
T = int(input())

for _ in range(T):
  # 후보자 수
  n = int(input())
  n_list = []
  max = 0
  sum = 0

  for _ in range(n):
    # 각 후보자가 받은 득표 수
    score = int(input())
    sum += score
    if score >= max:
      max = score

    n_list.append(score)

  # 득표 결과
  if (n_list.count(max) > 1):  # 최다 득표자 1명 초과
    print('no winner')
  elif (max > sum / 2):  # 최다 득표자가 과반수
    print('majority winner', n_list.index(max) + 1)
  else:  # 최다 득표자가 절반 이하 득표
    print('minority winner', n_list.index(max) + 1)
