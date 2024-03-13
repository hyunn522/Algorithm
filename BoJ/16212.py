N = int(input())
nums = list(map(int, input().split()))
# 오름차순으로 정렬
nums.sort()

for i in range(len(nums)):
  if (i != len(nums) - 1):
    print(nums[i], end=' ')
  else:
    print(nums[i])
