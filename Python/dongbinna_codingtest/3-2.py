# n,m,k 공백으로 구분받기
n,m,k = map(int, input().split())
# 여러개의 수 공백으로 구분하여 입력받기
data = list(map(int, input().split()))

data.sort() # 입력 받은 수들을 정리하기

first = data[n-1]
