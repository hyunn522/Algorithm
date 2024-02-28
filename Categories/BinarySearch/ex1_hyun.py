# 떡의 개수(n)과 필요한 떡의 길이(m) 입력
n, m = map(int, input.split())
# 각 떡의 높이를 리스트에 저장
height = list(map(int, input.split()))

#설정한 높이와 주어진 개별 떡의 높이 차이의 합이 m 이상
#높이 차이가 0보다 작으면 무시, 0 이상일 때만 더하기
#높이를 어케 설정하지..
#정렬해서 이진 탐색?
height.sort()

def binary_search(array, target, start, end):
  while start <= end:
    mid = (start + end) // 2
    if array[mid] > target:
      end = mid - 1
    else:
      start = mid + 1

for i in range(n):
  # 어카묘?