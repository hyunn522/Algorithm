A, B = input().split()

A_reverse = A[::-1]
B_reverse = B[::-1]

if A_reverse > B_reverse:
  print(A_reverse)
elif A_reverse < B_reverse:
  print(B_reverse)
