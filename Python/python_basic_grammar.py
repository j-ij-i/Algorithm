# 파이썬 기본 문법 정리
a = 2
print(a)

# 첫번째 i는 최종 나오는 모습?
#
array1 = [i for i in range(1,10)]
print(array1)

array2 = [i*i for i in range(1,10)]
print(array2)

M = 1
N = 2
# 리스트 컴프리헨션의 좋은 예시 (N X M)
array3 = [[0] * M for _ in range(N)]

# 리스트 컴프리헨션의 잘못된 예시 (N X M)
array4 = [[0] * M] * N
# 이 경우에는 array4[1][1]=5 하게 되면 [0][1] [2][1] ... 모두 5가 될 수 있음

# 파이썬에서 반복을 수행하되 반복을 위한 변수의 값을 무시하고자 할 때는 언더바를 사용
# 1. for문 내의 i의 값이 영향을 주는 경우
summary = 0
for i in range(1,10):
    summary += i
print(summary)

# 2. 단순히 내부적으로 반복적인 코드가 필요할 경우
for _ in range(5):
    print("hello")

# 특정 원소만 제거
a = [1,2,3,4,5,6]
remove_set = {3,5}

result = [i for i in a if i not in remove_set]
print(result)

# 문자열 이스케이프 문자 \
string = "Don't you know \"Python\"?"
print(string)

# 튜플 자료형
# - 리스트와 유사하지만 한번 선언된 값을 변경불가능하며 리스트는 ([]), 튜플은 (())
# - 튜플은 공간효율적
tu = (1,2,3,4)
# tu[2] = 8 이런건 불가능

# 튜플은 언제쓰나요?
# 튜플은 서로 다른 성질의 데이터를 묶어서 관리할 때 사용 (최단 경로 알고리즘에서  (비용,노드 번호)의 형태로 튜플 자료형을 이용)
# 데이터의 나열을 해싱의 키값으로 사용해야할 때(튜플은 변경이 불가능하여 키 값으로 사용가능)
# 리스트보다 메모리를 효율적으로 사용해야할 때

# 사전 자료형
# 키와 값으로 데이터를 가지는 자료형 -> hash 같은거?
# 변경 불가능한 자료형을 키값으로 사용
# 파이썬의 자료형은 해시 테이블을 이용해서 O(1)의 시간으로 처리가 가능하다
data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'

data2 = {
    '메리' : '고양이',
    '두부' : '강아지'
}
print(data)
print(data2)
if '사과' in data:
    print("사과가 존재합니다.")

# 키 데이터만 뽑아서 리스트로 이용할 때 => keys()
# 값 데이터만 뽑아서 리스트로 사용할 때 => values()
print(data.keys())
print(data.values())


# 리스트나 튜플은 순서가 있기 때문에 인덱싱으로 통해 자료형의 값을 얻을 수 있음
# 하지만 사전 자료형이나 집합 자료형은 순서가 없음

# 집합 자료형
# 중복을 허용하지 않음
# 순서 x
# 리스트 혹은 문자열을 이용해서 초기화 가능 => set() 함수 이용
dataset = set([1,1,1,2,3,4,4,4,5])
dataset2 = {1,1,1,2,3,4,4,4,5}
print(dataset)
print(dataset2)
dataset.add(7)
dataset.update([8,9])
dataset.remove(3)
print(dataset)

# input() => 한 줄의 문자열을 입력 받는 함수
# map() => 리스트의 모든 원소에 각각 특정한 함수를 적용
# 공백을 기준으로 구분된 데이터를 입력 받을 때
list(map(int, input().split()))
# 공백을 기준으로 데이터
a,b,c = map(int,input().split())

# 데이터의 개수 입력
n = int(input())
# 입력받은 정수 리스트
data = list(map(int, input().split()))

# 사용자로부터 빠르게 받는 경우
# sys.stdin.readlion()
# 단 입력 후 엔터가 줄바꿈 기호로 입력되어 rstrip() 매서드와 함께 사용