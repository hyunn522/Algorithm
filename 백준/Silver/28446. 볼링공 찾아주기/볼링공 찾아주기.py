# sys 라이브러리 사용하지 않으면 시간 초과
import sys

input = sys.stdin.readline

M = int(input())
balls = {}  # key를 공으로, value를 사물함으로

for _ in range(M):
  data = list(map(int, input().split()))

  if data[0] == 1:  # 볼링공을 넣는 경우
    balls[data[2]] = data[1]
  else:  # 볼링공의 사물함 정보를 출력하는 경우
    print(balls.get(data[1]))
