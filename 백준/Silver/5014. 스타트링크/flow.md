버튼을 누르는 "최소" 횟수를 구해야 함 -> BFS
- greedy로는 각 경우에 대한 최적해만 구하므로 전체적인 최적해를 구할 수 없음

<hr/>

첫 번째 시도 실패 이유
- 시작 위치(`s`)와 목표 위치(`g`)가 같은 경우를 고려하지 않음
- 위로 이동하는 단위(`u`)와 아래로 이동하는 단위(`d`)가 `0`인 경우를 고려하지 않음
<br/>

-> `s == g`인 경우에 대한 분기 처리

-> `result`를 `-1`로 초기화하여 `u`, `d`가 `0`인 경우 판별

=> 성공!
