As-Is
- 크기가 k인 부분집합 뿐 아니라, 모든 경우의 부분집합에 대해 다 DFS 탐색
- 사용하는 경우 ex) 주어진 배열에서 합이 k인 부분집합, 0/1 knapsack, 모든 부분수열

To-Be
- 크기가 k인 부분집합에 대해서만 탐색

`map.merge(key, 1, Integer::sum)` : key 없으면 1 저장, 있으면 기존 값과 1을 Integer::sum으로 재저장

`list.toArray(new String[0])` : list를 배열로 바꿈
