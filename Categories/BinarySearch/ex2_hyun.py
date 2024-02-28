n, x = map(int, input().split())
array = list(map(int, input().split()))

# 정렬되어있으니까.. bisect_left, bisect_right 라이브러리 이용하기
from bisect import bisect_left, bisect_right

start = bisect_left(array, x)
end = bisect_right(array, x)

result = end - start
print(result)