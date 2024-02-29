time_sum = 0  # 학점의 총합
score_sum = 0  # (학점 * 과목평점)의 총합
average = 0  # 전공 평점

for _ in range(20):
  subject, time, grade = map(str, input().split())
  if grade == 'P':
    continue
  else:
    time_sum += float(time)
    if grade == 'A+':
      score_sum += float(time) * 4.5
    elif grade == 'A0':
      score_sum += float(time) * 4.0
    elif grade == 'B+':
      score_sum += float(time) * 3.5
    elif grade == 'B0':
      score_sum += float(time) * 3.0
    elif grade == 'C+':
      score_sum += float(time) * 2.5
    elif grade == 'C0':
      score_sum += float(time) * 2.0
    elif grade == 'D+':
      score_sum += float(time) * 1.5
    elif grade == 'D0':
      score_sum += float(time) * 1.0
    else:
      score_sum += 0

average = score_sum / time_sum
# 소수점 아래 6번째까지 나타냄
print(round(average, 6))
