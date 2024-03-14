M = int(input())
# key를 공으로, value를 사물함으로
balls = {}

for _ in range(M):
  data = list(map(int, input().split()))

  if data[0] == 1:  # 볼링공을 넣는 경우
    index = data[2]
    balls[index] = data[1]
  else:  # 볼링공의 사물함 정보를 출력하는 경우
    index = data[1]
    print(balls[index])
