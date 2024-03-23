# test case 개수
C = int(input())

for _ in range(C):
  student_list = list(map(int, input().split()))
  student_num = student_list[0]
  student_scores = student_list[1:]
  score_sum = sum(student_scores)
  average = float(score_sum / student_num)

  count = 0
  for score in student_scores:
    if score > average:
      count += 1

  result = count / student_num * 100
  # 소수점 셋째자리 수까지 반올림하여 출력
  print('{0:.3f}%'.format(result))
