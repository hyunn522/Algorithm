## Set<int[]> vs. Set<List<Integer>>
`Set<int[]>`에 `new int[]{0, 0}`을 두 번 넣으면 **서로 다른 객체로 인식**한다.

`Set`은 중복 체크를 위해 `equals()`와 `hashCode()`를 사용한다.

배열은 `Object`를 상속받으므로 기본 동작을 사용 : `equals()`는 참조 주소를 비교하고, `hashCode()` 또한 주소 기반 해시값을 반환한다.

따라서 각각 만들어진 두 배열은 주소가 다르므로, 내부 값과 상관없이 다른 것으로 취급한다.

`List` 인터페이스는 `equals()`와 `hashCode()`를 값을 기준으로 비교하도록 재정의한다.

따라서 같은 길이이며 각 위치의 값이 같으면 `equals()`가 `true`를 반환하기 때문에 `Set<List<Integer>>`가 의도한 대로 동작한다.
