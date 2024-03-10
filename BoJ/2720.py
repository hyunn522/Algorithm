# test case 갯수
T = int(input())
T_list = list(range(T))

for i in range(T):
  # test case 입력
  T_list[i] = int(input())

for i in range(T):
  # 각 test case별로 결과를 담을 리스트
  result = [0, 0, 0, 0]

  num = T_list[i]
  # 거스름돈이 남을 때까지 계산
  while (num != 0):
    if (num >= 25):
      result[0] += 1
      num -= 25
    elif (num >= 10):
      result[1] += 1
      num -= 10
    elif (num >= 5):
      result[2] += 1
      num -= 5
    else:
      result[3] += 1
      num -= 1

  # 결과 출력
  print(result[0], result[1], result[2], result[3])
