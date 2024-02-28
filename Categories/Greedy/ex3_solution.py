n = int(input())
data = list(map(int, input().split()))
data.sort()  #공포도 오름차순 정렬

result = 0  #총 그룹의 수
count = 0  #현재 그룹에 포함된 모험가의 수

for i in data:  #공포도를 낮은 것부터 하나씩 확인하며
  count += 1  #현재 그룹에 해당 모험가 포함
  if count >= i:  #현재 확인하고 있는 모험가의 수 >= 현재 공포도
    result += 1  #그룹 결
    count = 0

print(result)
